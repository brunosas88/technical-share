package com.fcamara.technicalshare.technicalshare.skill.dto;

import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseSkillDTO {

    private String skill;
    private String subcategory;
    private String category;

    public static ResponseSkillDTO convertToDTO(Skill skill) {
        ResponseSkillDTO dto = new ResponseSkillDTO();
        dto.setSkill(skill.getSkill());
        dto.setSubcategory(skill.getSubcategory());
        dto.setCategory(skill.getCategory());
        return dto;
    }
}
