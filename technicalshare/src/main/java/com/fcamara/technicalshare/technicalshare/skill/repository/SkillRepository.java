package com.fcamara.technicalshare.technicalshare.skill.repository;

import com.fcamara.technicalshare.technicalshare.skill.model.Skill;
import com.fcamara.technicalshare.technicalshare.skill.repository.projection.ProfileProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

    Skill findSkillBySkill(String skill);

    @Query(
            value = "SELECT p1.id as id, p1.username as userName, p1.email as email, p1.bio as bio " +
                    "FROM ( "+
                    "SELECT p.id, p.username, p.email, p.bio" +
                    " FROM profile p " +
                    "JOIN profile_skill_expertise pse ON p.id = pse.id_profile " +
                    "JOIN skill s ON s.id = pse.id_skill " +
                    "WHERE s.skill = :firstSkill " +
                    ") AS p1" +
                    " JOIN profile_skill_expertise pse ON  p1.id = pse.id_profile " +
                    "JOIN skill s ON s.id = pse.id_skill " +
                    "WHERE s.skill = :secondSkill ", nativeQuery = true
    )
    List<ProfileProjection> findByMultipleSkill(String firstSkill, String secondSkill);

    void deleteSkillBySkill(String skill);

}
