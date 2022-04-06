package com.fcamara.technicalshare.technicalshare.skill.repository;

import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
