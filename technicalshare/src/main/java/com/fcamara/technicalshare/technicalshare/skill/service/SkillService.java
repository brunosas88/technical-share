package com.fcamara.technicalshare.technicalshare.skill.service;

import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
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

    public Skill registerProfileSkill(SkillDTO skillDTO, Profile newProfile){
        Skill skillRegistered = skillRepository.findSkillBySkill(skillDTO.getSkill());
        skillRegistered.getProfileExpertiseList().add(newProfile);
        return skillRegistered;
    }

    public List<SkillDTO> registerSkill(List<SkillDTO> skillDTOList){
        skillDTOList.forEach (skillDTO -> {
            Skill newSkill = new Skill();
            newSkill.setSkill(skillDTO.getSkill());
            newSkill.setArea(skillDTO.getArea());
            skillRepository.save(newSkill);
        });
        return getAllSkills();
    }

    public List<SkillDTO> getAllSkills() {
        return skillRepository.findAll().stream().map(SkillDTO::convertToDTO).collect(Collectors.toList());
    }

    public Skill getSkillBySkill(String skill){
        return skillRepository.findSkillBySkill(skill);
    }

    public void deleteSkillsBySkill(String skill) {
        skillRepository.deleteSkillBySkill(skill);
    }

    public void deleteAllSkills() {
        skillRepository.deleteAll();
    }

    
}
