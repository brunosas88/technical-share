package com.fcamara.technicalshare.technicalshare.profession.dto;

import com.fcamara.technicalshare.technicalshare.profession.model.Profession;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseProfessionDTO {

    private String occupation;
    private Integer duration;
    private String description;
    private String experienceLevel;

    public static ResponseProfessionDTO convertToDTO(Profession profession) {
        ResponseProfessionDTO dto = new ResponseProfessionDTO();
        dto.setOccupation(profession.getOccupation());
        dto.setDuration(profession.getDuration());
        dto.setDescription(profession.getDescription());
        dto.setExperienceLevel(profession.getExperienceLevel());

        return dto;
    }
}
