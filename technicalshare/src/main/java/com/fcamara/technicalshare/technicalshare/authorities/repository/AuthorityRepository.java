package com.fcamara.technicalshare.technicalshare.authorities.repository;


import com.fcamara.technicalshare.technicalshare.authorities.model.Authority;
import com.fcamara.technicalshare.technicalshare.authorities.model.AuthorityKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, AuthorityKey> {
}
