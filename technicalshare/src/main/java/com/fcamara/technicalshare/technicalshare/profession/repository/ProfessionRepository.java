package com.fcamara.technicalshare.technicalshare.profession.repository;

import com.fcamara.technicalshare.technicalshare.profession.model.Profession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
}
