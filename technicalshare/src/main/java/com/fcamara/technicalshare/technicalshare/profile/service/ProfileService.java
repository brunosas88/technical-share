package com.fcamara.technicalshare.technicalshare.profile.service;

import com.fcamara.technicalshare.technicalshare.academiceducation.service.AcademicEducationService;
import com.fcamara.technicalshare.technicalshare.links.service.LinksService;
import com.fcamara.technicalshare.technicalshare.profession.service.ProfessionService;
import com.fcamara.technicalshare.technicalshare.profile.dto.ProfileDTO;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.profile.repository.ProfileRepository;
import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import com.fcamara.technicalshare.technicalshare.skill.service.SkillService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final LinksService linksService;
    private final SkillService skillService;
    private final ProfessionService professionService;
    private final AcademicEducationService academicEducationService;

    public ProfileDTO registerProfile(ProfileDTO profileDTO) {

        Profile newProfile = profileRepository.save(ProfileDTO.convertToModel(profileDTO));

        newProfile.getLinksList().addAll(profileDTO.getLinksListDTO()
                .stream()
                .map(newLink -> linksService.registerLink(newLink, newProfile))
                .collect(Collectors.toList())
        );
        newProfile.getExpertiseList().addAll(profileDTO.getExpertiseList()
                .stream()
                .map(newSkill -> skillService.registerProfileSkill(newSkill, newProfile))
                .collect(Collectors.toList())
        );
//        newProfile.getInterestsList().addAll(profileDTO.getInterestsList()
//                .stream()
//                .map(newSkill -> skillService.registerProfileSkill(newSkill))
//                .collect(Collectors.toList())
//        );
        newProfile.getProfessionList().addAll(profileDTO.getProfessionList()
                .stream()
                .map(newProfession -> professionService.registerProfession(newProfession, newProfile))
                .collect(Collectors.toList())
        );
        newProfile.getAcademicEducationList().addAll(profileDTO.getAcademicEducationList()
        .stream()
        .map(newAcademicEducation -> academicEducationService.registerAcademicEducation(newAcademicEducation, newProfile))
        .collect(Collectors.toList())
        );

        return ProfileDTO.convertToDTO(newProfile);
    }

    public Page<ProfileDTO> findAllProfile(Pageable pageable) {
        return profileRepository.findAll(pageable).map(ProfileDTO::convertToDTO);
    }

    public ProfileDTO findProfile (String email) {
        return ProfileDTO.convertToDTO(profileRepository.findProfileByEmail(email));
    }
    public Page<ProfileDTO> findProfileByUserName (String name, Pageable pageable) {
        return profileRepository.findProfileByUserNameIgnoreCaseContains(name, pageable).map(ProfileDTO::convertToDTO);
    }

    public Page<ProfileDTO> getProfileBySkill(String requiredSkill, String filterXP, Pageable pageable) {
        Skill skill = skillService.getSkillBySkill(requiredSkill);
        List<ProfileDTO> profileDTOList = skill.getProfileExpertiseList().stream().map(ProfileDTO::convertToDTO).collect(Collectors.toList());
        if(Objects.equals(filterXP, null) ) {
            return toPage(profileDTOList, pageable);
        }
        else {
            List<ProfileDTO> profileDTOListFiltered = profileDTOList.stream().filter( profileDTO -> Objects.equals(profileDTO.getProfessionList().get(0).getExperienceLevel(),filterXP)).collect(Collectors.toList());
            return toPage(profileDTOListFiltered, pageable);
        }

    }

    public Page<ProfileDTO> fyndByMultipleSkills(String firstSkill, String secondSkill, Pageable pageable) {
        List<String> emailProfileList = skillService.findByMultipleSkills(firstSkill, secondSkill);
        List<ProfileDTO> profileList = new ArrayList<>();
        emailProfileList.forEach(email -> {
            profileList.add(findProfile(email));
        });
        return toPage(profileList, pageable);
    }


    private Page toPage(List list, Pageable pageable) {
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
}
