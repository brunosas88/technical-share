package com.fcamara.technicalshare.technicalshare.profile.service;

import com.fcamara.technicalshare.technicalshare.academiceducation.model.AcademicEducation;
import com.fcamara.technicalshare.technicalshare.academiceducation.service.AcademicEducationService;
import com.fcamara.technicalshare.technicalshare.links.model.Links;
import com.fcamara.technicalshare.technicalshare.links.service.LinksService;
import com.fcamara.technicalshare.technicalshare.profession.model.Profession;
import com.fcamara.technicalshare.technicalshare.profession.service.ProfessionService;
import com.fcamara.technicalshare.technicalshare.profile.dto.ProfileDTO;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.profile.repository.ProfileRepository;
import com.fcamara.technicalshare.technicalshare.requisition.model.Requisition;
import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import com.fcamara.technicalshare.technicalshare.skill.service.SkillService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.fcamara.technicalshare.technicalshare.utils.GlobalVariables.NULL_VALUE;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final LinksService linksService;
    private final SkillService skillService;
    private final ProfessionService professionService;
    private final AcademicEducationService academicEducationService;

    @Transactional
    public ProfileDTO registerProfile(ProfileDTO profileDTO) {
        Profile newProfile = profileRepository.save(ProfileDTO.convertToModel(profileDTO));
        newProfile.getLinksList().addAll(registerProfileLinks(profileDTO, newProfile));
        newProfile.getExpertiseList().addAll(registerProfileSkills(profileDTO, newProfile));
        newProfile.getProfessionList().addAll(registerProfileProfessions(profileDTO, newProfile));
        newProfile.getAcademicEducationList().addAll(registerProfileAcademics(profileDTO, newProfile));
        return ProfileDTO.convertToDTO(newProfile);
    }

    private List<AcademicEducation> registerProfileAcademics(ProfileDTO profileDTO, Profile newProfile) {
        return profileDTO.getAcademicEducationList()
                .stream()
                .map(newAcademicEducation -> academicEducationService.registerAcademicEducation(newAcademicEducation, newProfile))
                .collect(Collectors.toList());
    }

    private List<Profession> registerProfileProfessions(ProfileDTO profileDTO, Profile newProfile) {
        return profileDTO.getProfessionList()
                .stream()
                .map(newProfession -> professionService.registerProfession(newProfession, newProfile))
                .collect(Collectors.toList());
    }

    private List<Skill> registerProfileSkills(ProfileDTO profileDTO, Profile newProfile) {
        return profileDTO.getExpertiseList()
                .stream()
                .map(newSkill -> skillService.registerProfileSkill(newSkill, newProfile))
                .collect(Collectors.toList());
    }

    private List<Links> registerProfileLinks(ProfileDTO profileDTO, Profile newProfile) {
        return profileDTO.getLinksListDTO()
                .stream()
                .map(newLink -> linksService.registerLink(newLink, newProfile))
                .collect(Collectors.toList());
    }
    

    public ProfileDTO findProfile (String email) {
        return ProfileDTO.convertToDTO(profileRepository.findProfileByEmail(email));
    }

    public Page<ProfileDTO> findAllProfile(String toExcludeProfileEmail, Pageable pageable) {
        List<ProfileDTO>  profileDTOList = extractUnecessaryProfile(profileRepository.findAll(pageable.getSort()) , toExcludeProfileEmail);
        return ListToPage(profileDTOList, pageable);
    }

    public Page<ProfileDTO> findProfileByUserName (String name , String toExcludeProfileEmail, Pageable pageable) {
        List<ProfileDTO> profileDTOList = extractUnecessaryProfile(profileRepository.findProfileByUserNameIgnoreCaseContains(name, pageable.getSort()), toExcludeProfileEmail);
        return ListToPage(profileDTOList, pageable);
    }

    public Page<ProfileDTO> findProfilesBySkill(String firstSkill, String secondSkill, String filterXP, Pageable pageable, String toExcludeProfileEmail) {
        List<ProfileDTO> profileDTOList;
        if( (Objects.equals(firstSkill,NULL_VALUE) && Objects.equals(secondSkill,NULL_VALUE)) || (Objects.equals(firstSkill,null) && Objects.equals(secondSkill,null))) {
            return findAllProfile(toExcludeProfileEmail, pageable);
        } else if(Objects.equals(firstSkill,NULL_VALUE) || Objects.equals(firstSkill,null)) {
            Skill skill = skillService.getSkillBySkill(secondSkill);
            profileDTOList = extractUnecessaryProfile(skill.getProfileExpertiseList(), toExcludeProfileEmail);
        } else if(Objects.equals(secondSkill,NULL_VALUE) || Objects.equals(secondSkill,null)) {
            Skill skill = skillService.getSkillBySkill(firstSkill);
            profileDTOList = extractUnecessaryProfile(skill.getProfileExpertiseList(), toExcludeProfileEmail);
        } else {
            profileDTOList = findByMultipleSkills(firstSkill, secondSkill, toExcludeProfileEmail);
        }
        return ListToPage(FilteredProfiles(filterXP, profileDTOList), pageable);
    }

    private List<ProfileDTO> findByMultipleSkills(String firstSkill, String secondSkill, String toExcludeProfileEmail) {
        List<ProfileDTO> profileDTOList;
        List<String> emailList = skillService.findByMultipleSkills(firstSkill, secondSkill);
        List<Profile> profileList = new ArrayList<>();
        emailList.forEach(email -> profileList.add(profileRepository.findProfileByEmail(email)));
        profileDTOList = extractUnecessaryProfile(profileList, toExcludeProfileEmail);
        return profileDTOList;
    }

    private List<ProfileDTO> FilteredProfiles(String filterXP, List<ProfileDTO> profileDTOList) {
        if( Objects.equals(filterXP, NULL_VALUE) || Objects.equals(filterXP, null) ) {
            return profileDTOList;
        } else {
            return profileDTOList.stream().filter(profileDTO -> Objects.equals(profileDTO.getProfessionList().get(0).getExperienceLevel(), filterXP)).collect(Collectors.toList());
        }
    }

    private Page ListToPage(List list, Pageable pageable) {
        if (pageable.getOffset() >= list.size()) {
            return Page.empty();
        }
        int startIndex = (int)pageable.getOffset();
        int endIndex = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ?
                list.size() :
                pageable.getOffset() + pageable.getPageSize());
        List subList = list.subList(startIndex, endIndex);
        return new PageImpl(subList, pageable, list.size());
    }

    private List<ProfileDTO> extractUnecessaryProfile(List<Profile> profileList, String toExcludeProfileEmail) {
        Profile user = profileRepository.findProfileByEmail(toExcludeProfileEmail);
        profileList.remove(user);
        return profileList.stream().map(ProfileDTO::convertToDTO).collect(Collectors.toList());
    }
    
    
    public void registerRequisitionProfile(Requisition requisition, String profileEmail) {
        Profile user = profileRepository.findProfileByEmail(profileEmail);
        user.getMentoringListReceived().add(requisition);
        profileRepository.save(user);
    }

    public void deleteRequisitionFromLearner(Requisition toBeRemovedRequisition, String profileEmail) {
        Profile user = profileRepository.findProfileByEmail(profileEmail);
        user.getMentoringListReceived().remove(toBeRemovedRequisition);
        profileRepository.save(user);
    }

    public void deleteRequisitionFromMentor(Requisition toBeRemovedRequisition, String profileEmail) {
        Profile user = profileRepository.findProfileByEmail(profileEmail);
        user.getMentoringListGiven().remove(toBeRemovedRequisition);
        profileRepository.save(user);
    }
    

    

}