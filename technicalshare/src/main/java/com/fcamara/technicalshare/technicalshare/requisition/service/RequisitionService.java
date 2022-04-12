package com.fcamara.technicalshare.technicalshare.requisition.service;

import com.fcamara.technicalshare.technicalshare.profile.service.ProfileService;
import com.fcamara.technicalshare.technicalshare.requisition.dto.RequisitionDTO;
import com.fcamara.technicalshare.technicalshare.requisition.model.Requisition;
import com.fcamara.technicalshare.technicalshare.requisition.repository.RequisitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequisitionService {

    private final RequisitionRepository requisitionRepository;
    private final ProfileService profileService;

    public void registerRequisition(RequisitionDTO requisitionDTO) {
        Requisition newRequisition = new Requisition();




    }

}
