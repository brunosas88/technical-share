package com.fcamara.technicalshare.technicalshare.links.repository;

import com.fcamara.technicalshare.technicalshare.links.model.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinksRepository extends JpaRepository<Links, Integer> {
}
