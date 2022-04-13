package com.fcamara.technicalshare.technicalshare.requisition.controller;

import com.fcamara.technicalshare.technicalshare.requisition.dto.RequisitionDTO;
import com.fcamara.technicalshare.technicalshare.requisition.service.RequisitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requisitions")
@RequiredArgsConstructor
public class RequisitionController {

    private final RequisitionService requisitionService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void registerRequisition(@RequestBody RequisitionDTO requisitionDTO) {
        requisitionService.registerRequisition(requisitionDTO);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping
    public void deleteRequisition(@RequestParam Integer idRequisition,@RequestParam String emailRemoveRequest) {
        requisitionService.deleteRequisition(idRequisition, emailRemoveRequest);
    }
}
