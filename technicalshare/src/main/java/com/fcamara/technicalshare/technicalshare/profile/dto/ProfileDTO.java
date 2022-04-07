package com.fcamara.technicalshare.technicalshare.profile.dto;

import com.fcamara.technicalshare.technicalshare.academiceducation.dto.ResponseAcademicEducationDTO;
import com.fcamara.technicalshare.technicalshare.links.dto.LinksDTO;
import com.fcamara.technicalshare.technicalshare.profession.dto.ResponseProfessionDTO;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.skill.dto.ResponseSkillDTO;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfileDTO {

    private String userName;
    private String email;
    private String bio;
    private List<LinksDTO> linksListDTO;
//    private List<ResponseSkillDTO> expertiseList;
//    private List<ResponseSkillDTO> interestsList;
//    private List<ResponseProfessionDTO> professionList;
//    private List<ResponseAcademicEducationDTO> academicEducationList;

    public static ProfileDTO convertToDTO (Profile profile) {
        ProfileDTO dto = new ProfileDTO();
        dto.setUserName(profile.getUserName());
        dto.setEmail(profile.getEmail());
        dto.setBio(profile.getBio());
        dto.linksListDTO = profile.getLinksList()
                .stream()
                .map(LinksDTO::convertToDTO)
                .collect(Collectors.toList());
//        dto.expertiseList = profile.getExpertiseList()
//                .stream()
//                .map(ResponseSkillDTO::convertToDTO)
//                .collect(Collectors.toList());
//        dto.interestsList = profile.getInterestsList()
//                .stream()
//                .map(ResponseSkillDTO::convertToDTO)
//                .collect(Collectors.toList());
//        dto.professionList = profile.getProfessionList()
//                .stream()
//                .map(ResponseProfessionDTO::convertToDTO)
//                .collect(Collectors.toList());
//        dto.academicEducationList = profile.getAcademicEducationList()
//                .stream()
//                .map(ResponseAcademicEducationDTO::convertToDTO)
//                .collect(Collectors.toList());

        return dto;
    }

    public static Profile convertToModel(ProfileDTO profileDTO) {
        Profile model = new Profile();
        model.setUserName(profileDTO.getUserName());
        model.setEmail(profileDTO.getEmail());
        model.setBio(profileDTO.getBio());
        return model;
    }
}
