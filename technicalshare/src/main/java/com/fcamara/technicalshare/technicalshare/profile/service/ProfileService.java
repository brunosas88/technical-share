package com.fcamara.technicalshare.technicalshare.profile.service;

import com.fcamara.technicalshare.technicalshare.academiceducation.service.AcademicEducationService;
import com.fcamara.technicalshare.technicalshare.links.service.LinksService;
import com.fcamara.technicalshare.technicalshare.profession.service.ProfessionService;
import com.fcamara.technicalshare.technicalshare.profile.dto.ProfileDTO;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.profile.repository.ProfileRepository;
import com.fcamara.technicalshare.technicalshare.skill.service.SkillService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final LinksService linksService;
    private final SkillService skillService;
    private final ProfessionService professionService;
    private final AcademicEducationService academicEducationService;

    public ProfileDTO findProfile (String email) {
        return ProfileDTO.convertToDTO(profileRepository.findProfileByEmail(email));
    }

    public ProfileDTO registerProfile(ProfileDTO profileDTO) {

        Profile newProfile = profileRepository.save(ProfileDTO.convertToModel(profileDTO));

        newProfile.getLinksList().addAll(profileDTO.getLinksListDTO()
                .stream()
                .map(newLink -> linksService.registerLink(newLink, newProfile))
                .collect(Collectors.toList())
        );
        newProfile.getExpertiseList().addAll(profileDTO.getExpertiseList()
                .stream()
                .map(newSkill -> skillService.registerProfileSkill(newSkill))
                .collect(Collectors.toList())
        );
        newProfile.getInterestsList().addAll(profileDTO.getInterestsList()
                .stream()
                .map(newSkill -> skillService.registerProfileSkill(newSkill))
                .collect(Collectors.toList())
        );
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

    public List<ProfileDTO> findAllProfile() {
        return profileRepository.findAll().stream().map(ProfileDTO::convertToDTO).collect(Collectors.toList());
    }
}
