package com.fcamara.technicalshare.technicalshare.contact.repository;

import com.fcamara.technicalshare.technicalshare.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
