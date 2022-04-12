package com.fcamara.technicalshare.technicalshare.requisition.controller;

import com.fcamara.technicalshare.technicalshare.requisition.dto.RequisitionDTO;
import com.fcamara.technicalshare.technicalshare.requisition.service.RequisitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requisitions")
@RequiredArgsConstructor
public class RequisitionController {

    private final RequisitionService requisitionService;

    @PostMapping
    public void registerRequisition(@RequestBody RequisitionDTO requisitionDTO) {
        requisitionService.registerRequisition(requisitionDTO);
    }
}
