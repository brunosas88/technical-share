package com.fcamara.technicalshare.technicalshare.academiceducation.repository;

import com.fcamara.technicalshare.technicalshare.academiceducation.model.AcademicEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicEducationRepository extends JpaRepository<AcademicEducation, Integer> {
}