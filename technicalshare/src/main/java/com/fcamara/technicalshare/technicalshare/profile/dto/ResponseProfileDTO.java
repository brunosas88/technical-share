package com.fcamara.technicalshare.technicalshare.profile.dto;

import com.fcamara.technicalshare.technicalshare.academiceducation.model.AcademicEducation;
import com.fcamara.technicalshare.technicalshare.links.dto.ResponseLinksDTO;
import com.fcamara.technicalshare.technicalshare.links.model.Links;
import com.fcamara.technicalshare.technicalshare.profession.model.Profession;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseProfileDTO {

    private String userName;
    private String email;
    private String bio;
    private List<ResponseLinksDTO> linksList;
    private List<Skill> expertiseList;
    private List<Skill> interestsList;
    private List<Profession> professionList;
    private List<AcademicEducation> academicEducationList;

    public static ResponseProfileDTO convertToDTO (Profile profile) {
        ResponseProfileDTO dto = new ResponseProfileDTO();
        dto.setUserName(profile.getUserName());
        dto.setEmail(profile.getEmail());
        dto.setBio(profile.getBio());
        dto.linksList = profile.getLinksList()
                .stream()
                .map(ResponseLinksDTO::convertToDTO)
                .collect(Collectors.toList());


        return dto;
    }
}
