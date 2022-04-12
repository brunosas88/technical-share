package com.fcamara.technicalshare.technicalshare.requisition.service;

import com.fcamara.technicalshare.technicalshare.contact.service.ContactService;
import com.fcamara.technicalshare.technicalshare.profile.service.ProfileService;
import com.fcamara.technicalshare.technicalshare.requisition.dto.RequisitionDTO;
import com.fcamara.technicalshare.technicalshare.requisition.model.Requisition;
import com.fcamara.technicalshare.technicalshare.requisition.repository.RequisitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequisitionService {

    private final RequisitionRepository requisitionRepository;
    private final ProfileService profileService;
    private final ContactService contactService;

    public void registerRequisition(RequisitionDTO requisitionDTO) {
        Requisition newRequisition = requisitionRepository.save(RequisitionDTO.convertToModel(requisitionDTO));

        newRequisition.getContactList().addAll(requisitionDTO.getContactList()
                .stream()
                .map(contactDTO -> contactService.registerContact(contactDTO, newRequisition))
                .collect(Collectors.toList())
        );
        profileService.registerRequisitionProfile(newRequisition);
    }

}
