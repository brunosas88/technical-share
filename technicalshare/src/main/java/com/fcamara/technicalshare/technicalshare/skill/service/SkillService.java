package com.fcamara.technicalshare.technicalshare.skill.service;

import com.fcamara.technicalshare.technicalshare.skill.dto.SkillDTO;
import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import com.fcamara.technicalshare.technicalshare.skill.repository.SkillRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public Skill registerProfileSkill(SkillDTO skillDTO){
        return skillRepository.findSkillBySkill(skillDTO.getSkill());
    }

    public List<SkillDTO> registerSkill(List<SkillDTO> skillDTOList){
        skillDTOList.forEach (skillDTO -> {
            Skill newSkill = new Skill();
            newSkill.setSkill(skillDTO.getSkill());
            newSkill.setSubcategory(skillDTO.getSubcategory());
            newSkill.setCategory(skillDTO.getCategory());
            skillRepository.save(newSkill);
        });
        return getAllSkills();
    }

    public List<SkillDTO> getAllSkills() {
        return skillRepository.findAll().stream().map(SkillDTO::convertToDTO).collect(Collectors.toList());
    }
    
}
