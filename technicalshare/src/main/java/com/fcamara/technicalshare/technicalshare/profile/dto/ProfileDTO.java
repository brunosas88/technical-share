package com.fcamara.technicalshare.technicalshare.profile.dto;

import com.fcamara.technicalshare.technicalshare.academiceducation.dto.AcademicEducationDTO;
import com.fcamara.technicalshare.technicalshare.links.dto.LinksDTO;
import com.fcamara.technicalshare.technicalshare.profession.dto.ProfessionDTO;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.requisition.dto.RequisitionDTO;
import com.fcamara.technicalshare.technicalshare.skill.dto.SkillDTO;
import lombok.*;

import java.util.ArrayList;
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
    private List<LinksDTO> linksListDTO = new ArrayList<>();
    private List<SkillDTO> expertiseList = new ArrayList<>();
    private List<ProfessionDTO> professionList = new ArrayList<>();
    private List<AcademicEducationDTO> academicEducationList = new ArrayList<>();
    private List<RequisitionDTO> mentoringListReceived = new ArrayList<>();
    private List<RequisitionDTO> mentoringListGiven = new ArrayList<>();

    public static ProfileDTO convertToDTO (Profile Profile) {
        ProfileDTO dto = new ProfileDTO();
        dto.setUserName(Profile.getUserName());
        dto.setEmail(Profile.getEmail());
        dto.setBio(Profile.getBio());
        dto.linksListDTO = Profile.getLinksList()
                .stream()
                .map(LinksDTO::convertToDTO)
                .collect(Collectors.toList());
       dto.expertiseList = Profile.getExpertiseList()
               .stream()
               .map(SkillDTO::convertToDTO)
               .collect(Collectors.toList());
       dto.professionList = Profile.getProfessionList()
               .stream()
               .map(ProfessionDTO::convertToDTO)
               .collect(Collectors.toList());
       dto.academicEducationList = Profile.getAcademicEducationList()
               .stream()
               .map(AcademicEducationDTO::convertToDTO)
               .collect(Collectors.toList());
       dto.mentoringListGiven = Profile.getMentoringListGiven()
               .stream()
               .map(RequisitionDTO::convertToDTO)
               .collect(Collectors.toList());
        dto.mentoringListReceived = Profile.getMentoringListReceived()
                .stream()
                .map(RequisitionDTO::convertToDTO)
                .collect(Collectors.toList());
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