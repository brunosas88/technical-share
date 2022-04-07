package com.fcamara.technicalshare.technicalshare.academiceducation.dto;

import com.fcamara.technicalshare.technicalshare.academiceducation.model.AcademicEducation;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AcademicEducationDTO {

    private String course;
    private LocalDate startDate;
    private LocalDate finalDate;
    private String institution;

    public static AcademicEducationDTO convertToDTO(AcademicEducation academicEducation) {
        AcademicEducationDTO dto = new AcademicEducationDTO();
        dto.setCourse(academicEducation.getCourse());
        dto.setStartDate(academicEducation.getStartDate());
        dto.setFinalDate(academicEducation.getFinalDate());
        dto.setInstitution(academicEducation.getInstitution());

        return dto;
    }
}
