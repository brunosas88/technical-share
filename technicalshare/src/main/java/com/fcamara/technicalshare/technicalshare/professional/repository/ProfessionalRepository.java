package com.fcamara.technicalshare.technicalshare.Professional.repository;

import com.fcamara.technicalshare.technicalshare.Professional.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {
}
