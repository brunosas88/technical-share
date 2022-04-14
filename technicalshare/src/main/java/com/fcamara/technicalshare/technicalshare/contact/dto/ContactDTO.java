package com.fcamara.technicalshare.technicalshare.contact.dto;

import com.fcamara.technicalshare.technicalshare.contact.model.Contact;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactDTO {

    private String contact;
    private String type;

    public static ContactDTO convertToDTO(Contact contact) {
        ContactDTO dto = new ContactDTO();
        dto.setContact(contact.getContact());
        dto.setType(contact.getType());
        return dto;
    }
}
