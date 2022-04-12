package com.fcamara.technicalshare.technicalshare.profession.dto;

import com.fcamara.technicalshare.technicalshare.profession.model.ExperienceLevelEnum;
import com.fcamara.technicalshare.technicalshare.profession.model.Profession;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfessionDTO {

    private String occupation;
    private String description;
    private String experienceLevel;
    private LocalDate startDate;
    private LocalDate finalDate;

    public static ProfessionDTO convertToDTO(Profession profession) {
        ProfessionDTO dto = new ProfessionDTO();
        dto.setOccupation(profession.getOccupation());
        dto.setStartDate(profession.getStartDate());
        dto.setFinalDate(profession.getFinalDate());
        dto.setDescription(profession.getDescription());
        dto.setExperienceLevel(profession.getExperienceLevel());

        return dto;
    }
}
