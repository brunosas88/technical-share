package com.fcamara.technicalshare.technicalshare.skill.dto;

import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SkillDTO {

    private String skill;
    private String subcategory;
    private String category;

    public static SkillDTO convertToDTO(Skill skill) {
        SkillDTO dto = new SkillDTO();
        dto.setSkill(skill.getSkill());
        dto.setSubcategory(skill.getSubcategory());
        dto.setCategory(skill.getCategory());
        return dto;
    }
}
