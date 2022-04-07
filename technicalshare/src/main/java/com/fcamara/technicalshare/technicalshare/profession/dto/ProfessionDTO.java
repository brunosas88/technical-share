package com.fcamara.technicalshare.technicalshare.profession.dto;

import com.fcamara.technicalshare.technicalshare.profession.model.Profession;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfessionDTO {

    private String occupation;
    private Integer duration;
    private String description;
    private String experienceLevel;

    public static ProfessionDTO convertToDTO(Profession profession) {
        ProfessionDTO dto = new ProfessionDTO();
        dto.setOccupation(profession.getOccupation());
        dto.setDuration(profession.getDuration());
        dto.setDescription(profession.getDescription());
        dto.setExperienceLevel(profession.getExperienceLevel());

        return dto;
    }
}
