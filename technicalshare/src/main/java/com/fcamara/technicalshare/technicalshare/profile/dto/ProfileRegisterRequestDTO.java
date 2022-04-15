package com.fcamara.technicalshare.technicalshare.profile.dto;

import com.fcamara.technicalshare.technicalshare.academiceducation.dto.AcademicEducationDTO;
import com.fcamara.technicalshare.technicalshare.links.dto.LinksDTO;
import com.fcamara.technicalshare.technicalshare.profession.dto.ProfessionDTO;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.requisition.dto.RequisitionDTO;
import com.fcamara.technicalshare.technicalshare.skill.dto.SkillDTO;
import com.fcamara.technicalshare.technicalshare.user.dto.UserDTO;
import com.fcamara.technicalshare.technicalshare.user.model.User;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfileRegisterRequestDTO {

    @NotBlank
    private String userName;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String bio;
    private String image;
    private List<LinksDTO> linksListDTO = new ArrayList<>();
    private List<SkillDTO> expertiseList = new ArrayList<>();
    private List<ProfessionDTO> professionList = new ArrayList<>();
    private List<AcademicEducationDTO> academicEducationList = new ArrayList<>();
    private List<RequisitionDTO> mentoringListReceived = new ArrayList<>();
    private List<RequisitionDTO> mentoringListGiven = new ArrayList<>();

    public static Profile convertToProfileModel(ProfileRegisterRequestDTO profileRegisterRequestDTO) {
        Profile model = new Profile();
        model.setUserName(profileRegisterRequestDTO.getUserName());
        model.setEmail(profileRegisterRequestDTO.getEmail());
        model.setBio(profileRegisterRequestDTO.getBio());
        model.setImage(profileRegisterRequestDTO.getImage());
        return model;
    }

    public static UserDTO convertToUserDTO(ProfileRegisterRequestDTO dto) {
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword(dto.getPassword());
        userDTO.setUserName(dto.getEmail());
        userDTO.setRoles(new ArrayList<>(){{add("CLIENT");}});
        return userDTO;
    }


}