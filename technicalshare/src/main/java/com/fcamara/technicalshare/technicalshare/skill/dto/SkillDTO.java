package com.fcamara.technicalshare.technicalshare.skill.dto;

import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SkillDTO {
    @NotBlank
    private String skill;
    @NotBlank
    private String area;

    public static SkillDTO convertToDTO(Skill skill) {
        SkillDTO dto = new SkillDTO();
        dto.setSkill(skill.getSkill());
        dto.setArea(skill.getArea());
        return dto;
    }
}
