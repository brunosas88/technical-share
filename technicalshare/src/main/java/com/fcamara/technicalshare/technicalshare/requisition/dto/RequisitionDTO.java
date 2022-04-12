package com.fcamara.technicalshare.technicalshare.requisition.dto;

import com.fcamara.technicalshare.technicalshare.requisition.model.Requisition;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequisitionDTO {

    private String userName;
    private String requiredUserName;
    private String subject;
    private String keyWords;
    private Boolean urgency;
    private String message;

    private static RequisitionDTO convertToDTO(Requisition requisition) {
        RequisitionDTO dto = new RequisitionDTO();
        dto.setUserName(requisition.getUserName());
        dto.setRequiredUserName(requisition.getRequiredUserName());
        dto.setSubject(requisition.getSubject());
        dto.setKeyWords(requisition.getKeyWords());
        dto.setUrgency(requisition.getUrgency());
        dto.setMessage(requisition.getMessage());
        return dto;
    }
}
