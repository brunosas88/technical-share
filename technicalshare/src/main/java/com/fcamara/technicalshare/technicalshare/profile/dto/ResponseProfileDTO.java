package com.fcamara.technicalshare.technicalshare.profile.dto;

import com.fcamara.technicalshare.technicalshare.links.model.Links;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseProfileDTO {

    private String userName;
    private String email;
    private String bio;
    private List<Links> linksList;
    private List<Skill> expertiseList;
    private List<Skill> interestsList;

    public static ResponseProfileDTO convertToDTO (Profile profile) {
        ResponseProfileDTO dto = new ResponseProfileDTO();
        dto.setUserName(profile.getUserName());
        dto.setEmail(profile.getEmail());
        dto.setBio(profile.getBio());
        //dto.linksList = profile.getLinksList().stream().map()
        return dto;
    }
}
