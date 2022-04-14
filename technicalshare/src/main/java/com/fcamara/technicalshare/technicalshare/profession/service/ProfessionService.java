package com.fcamara.technicalshare.technicalshare.profession.service;

import com.fcamara.technicalshare.technicalshare.profession.dto.ProfessionDTO;
import com.fcamara.technicalshare.technicalshare.profession.model.Profession;
import com.fcamara.technicalshare.technicalshare.profession.repository.ProfessionRepository;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessionService {

    private final ProfessionRepository professionRepository;

    public Profession registerProfession(ProfessionDTO professionDTO, Profile Profile){
        Profession newProfession = new Profession();
        newProfession.setOccupation(professionDTO.getOccupation());
        newProfession.setStartDate(professionDTO.getStartDate());
        newProfession.setFinalDate(professionDTO.getFinalDate());
        newProfession.setDescription(professionDTO.getDescription());
        newProfession.setExperienceLevel(professionDTO.getExperienceLevel());
        newProfession.setProfileProfession(Profile);
        return professionRepository.save(newProfession);
    }
    
}
