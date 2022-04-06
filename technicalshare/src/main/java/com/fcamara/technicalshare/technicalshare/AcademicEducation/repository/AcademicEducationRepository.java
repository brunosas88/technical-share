package com.fcamara.technicalshare.technicalshare.academicEducation.repository;

import com.fcamara.technicalshare.technicalshare.academicEducation.model.AcademicEducation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicEducationRepository extends JpaRepository<AcademicEducation, Integer> {
}