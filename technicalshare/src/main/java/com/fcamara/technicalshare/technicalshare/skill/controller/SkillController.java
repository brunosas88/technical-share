package com.fcamara.technicalshare.technicalshare.skill.controller;

import com.fcamara.technicalshare.technicalshare.skill.dto.SkillDTO;
import com.fcamara.technicalshare.technicalshare.skill.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @PostMapping
    public ResponseEntity<List<SkillDTO>> registerSkill (@RequestBody List<SkillDTO> skillDTOList) {
        return ResponseEntity.ok(skillService.registerSkill(skillDTOList));
    }

    @GetMapping
    public ResponseEntity<List<SkillDTO>> getAllSkills () {
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    @DeleteMapping("/{skill}")
	public void deleteSkillsBySkill(@PathVariable String skill) {
		skillService.deleteSkillsBySkill(skill);
	}

    @DeleteMapping("/{id}")
	public void deleteById(@PathVariable String skill) {
		skillService.deleteById(skill);
	}

    @DeleteMapping
	public void deleteAllSkills() {
		skillService.deleteAllSkills();
	}

}
