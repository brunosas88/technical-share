package com.fcamara.technicalshare.technicalshare.AcademicEducation.repository;

import com.fcamara.technicalshare.technicalshare.AcademicEducation.model.AcademicEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicEducationRepository extends JpaRepository<AcademicEducation, Integer> {
}