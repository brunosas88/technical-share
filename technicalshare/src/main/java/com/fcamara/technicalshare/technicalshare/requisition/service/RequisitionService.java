package com.fcamara.technicalshare.technicalshare.requisition.service;

import com.fcamara.technicalshare.technicalshare.contact.model.Contact;
import com.fcamara.technicalshare.technicalshare.contact.service.ContactService;
import com.fcamara.technicalshare.technicalshare.profile.model.Profile;
import com.fcamara.technicalshare.technicalshare.profile.service.ProfileService;
import com.fcamara.technicalshare.technicalshare.requisition.dto.RequisitionDTO;
import com.fcamara.technicalshare.technicalshare.requisition.model.Requisition;
import com.fcamara.technicalshare.technicalshare.requisition.repository.RequisitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequisitionService {

    private final RequisitionRepository requisitionRepository;
    private final ProfileService profileService;
    private final ContactService contactService;

    public void registerRequisition(RequisitionDTO requisitionDTO) {
        Requisition newRequisition = requisitionRepository.save(RequisitionDTO.convertToNewModel(requisitionDTO));
        newRequisition.getContactList().addAll(registerRequisitionContacts(requisitionDTO, newRequisition)
        );
        profileService.registerRequisitionLearner(newRequisition, newRequisition.getUserEmail());
        profileService.registerRequisitionMentor(newRequisition, newRequisition.getRequiredUserEmail());
    }

    private List<Contact> registerRequisitionContacts(RequisitionDTO requisitionDTO, Requisition newRequisition) {
        return requisitionDTO.getContactList()
                .stream()
                .map(contactDTO -> contactService.registerContact(contactDTO, newRequisition))
                .collect(Collectors.toList());
    }

    public void deleteRequisition(UUID uuidRequisition, String profileEmail) {
        Requisition toBeRemovedRequisition = requisitionRepository.findRequisitionByUuidRequisition(uuidRequisition);
        if (Objects.equals(profileEmail, toBeRemovedRequisition.getUserEmail())) {
            profileService.deleteRequisitionFromLearner(toBeRemovedRequisition, profileEmail);
        }else if (Objects.equals(profileEmail, toBeRemovedRequisition.getRequiredUserEmail())) {
            profileService.deleteRequisitionFromMentor(toBeRemovedRequisition, profileEmail);
        } else {
            throw new NullPointerException();
        }
    }
}
