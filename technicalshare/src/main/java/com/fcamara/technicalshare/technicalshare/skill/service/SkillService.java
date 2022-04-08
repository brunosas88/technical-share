package com.fcamara.technicalshare.technicalshare.skill.service;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.skill.dto.SkillDTO;
import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import com.fcamara.technicalshare.technicalshare.skill.repository.SkillRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public Skill registerSkill(SkillDTO skillDTO, Profile Profile){
        Skill newSkill = new Skill();

        newSkill.setSkill(skillDTO.getSkill());
        newSkill.setSubcategory(skillDTO.getSubcategory());
        newSkill.setCategory(skillDTO.getCategory());
        // newSkill.setProfileSkill(profile);
        return skillRepository.save(newSkill);
    }
    
}
