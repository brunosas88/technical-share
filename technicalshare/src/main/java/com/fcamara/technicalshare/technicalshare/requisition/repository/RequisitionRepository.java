package com.fcamara.technicalshare.technicalshare.requisition.repository;

import com.fcamara.technicalshare.technicalshare.requisition.model.Requisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitionRepository extends JpaRepository<Requisition, Integer> {


}
