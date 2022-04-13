package com.fcamara.technicalshare.technicalshare.requisition.dto;

import com.fcamara.technicalshare.technicalshare.contact.dto.ContactDTO;
import com.fcamara.technicalshare.technicalshare.requisition.model.Requisition;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequisitionDTO {

    private Integer id;
    private String userName;
    @NotBlank
    private String userEmail;
    private String requiredUserName;
    @NotBlank
    private String requiredUserEmail;
    private String subject;
    private String keyWords;
    private Boolean urgency;
    private String message;
    private List<ContactDTO> contactList = new ArrayList<>();

    public static RequisitionDTO convertToDTO(Requisition requisition) {
        RequisitionDTO dto = new RequisitionDTO();
        dto.setId(requisition.getId());
        dto.setUserName(requisition.getUserName());
        dto.setUserEmail(requisition.getUserEmail());
        dto.setRequiredUserName(requisition.getRequiredUserName());
        dto.setRequiredUserEmail(requisition.getRequiredUserEmail());
        dto.setSubject(requisition.getSubject());
        dto.setKeyWords(requisition.getKeyWords());
        dto.setUrgency(requisition.getUrgency());
        dto.setMessage(requisition.getMessage());
        dto.contactList = requisition.getContactList().stream().map(ContactDTO::convertToDTO).collect(Collectors.toList());

        return dto;
    }

    public static Requisition convertToModel(RequisitionDTO dto) {
        Requisition model = new Requisition();
        model.setUserName(dto.getUserName());
        model.setUserEmail(dto.getUserEmail());
        model.setRequiredUserName(dto.getRequiredUserName());
        model.setRequiredUserEmail(dto.getRequiredUserEmail());
        model.setSubject(dto.getSubject());
        model.setKeyWords(dto.getKeyWords());
        model.setUrgency(dto.getUrgency());
        model.setMessage(dto.getMessage());

        return model;
    }
}
