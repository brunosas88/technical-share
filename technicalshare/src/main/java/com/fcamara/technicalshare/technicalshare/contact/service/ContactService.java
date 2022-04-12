package com.fcamara.technicalshare.technicalshare.contact.service;

import com.fcamara.technicalshare.technicalshare.contact.dto.ContactDTO;
import com.fcamara.technicalshare.technicalshare.contact.model.Contact;
import com.fcamara.technicalshare.technicalshare.contact.repository.ContactRepository;
import com.fcamara.technicalshare.technicalshare.requisition.model.Requisition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact registerContact(ContactDTO contactDTO, Requisition requisition) {
        Contact newContact = new Contact();
        newContact.setContact(contactDTO.getContact());
        newContact.setType(contactDTO.getType());
        newContact.setRequisition(requisition);
        return contactRepository.save(newContact);
    }
}
