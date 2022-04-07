package com.fcamara.technicalshare.technicalshare.links.dto;

import com.fcamara.technicalshare.technicalshare.links.model.Links;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseLinksDTO {

    private String domain;
    private String link;
    private Boolean disponibility;

    public static ResponseLinksDTO convertToDTO (Links links) {
        ResponseLinksDTO dto = new ResponseLinksDTO();
        dto.setDomain(links.getDomain());
        dto.setLink(links.getLink());
        dto.setDisponibility(links.getDisponibility());
        return dto;
    }


}
