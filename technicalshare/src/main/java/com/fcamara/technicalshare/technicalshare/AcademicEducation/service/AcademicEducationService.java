package com.fcamara.technicalshare.technicalshare.academiceducation.service;

import com.fcamara.technicalshare.technicalshare.academiceducation.dto.AcademicEducationDTO;
import com.fcamara.technicalshare.technicalshare.academiceducation.model.AcademicEducation;
import com.fcamara.technicalshare.technicalshare.academiceducation.repository.AcademicEducationRepository;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcademicEducationService {

    private final AcademicEducationRepository academicEducationRepository;

    public AcademicEducation registerAcademicEducation(AcademicEducationDTO academicEducationDTO, Profile Profile){
        AcademicEducation newAcademicEducation = new AcademicEducation();
        newAcademicEducation.setCourse(academicEducationDTO.getCourse());
        newAcademicEducation.setStartDate(academicEducationDTO.getStartDate());
        newAcademicEducation.setFinalDate(academicEducationDTO.getFinalDate());
        newAcademicEducation.setInstitution(academicEducationDTO.getInstitution());
        newAcademicEducation.setProfileAcademic(Profile);
        return academicEducationRepository.save(newAcademicEducation);
    }
    
}