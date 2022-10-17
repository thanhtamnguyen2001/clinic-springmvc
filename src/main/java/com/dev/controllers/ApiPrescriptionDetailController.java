/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.PrescriptionDetail;
import com.dev.service.PrescriptionDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("/api")
public class ApiPrescriptionDetailController {
    @Autowired
    private PrescriptionDetailService prescriptionDetailService;
    
    @GetMapping(path = "/prescriptiondetails", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<PrescriptionDetail>> getPrescriptionDetails() {
        return new ResponseEntity<>(this.prescriptionDetailService.getPrescriptionDetails(0), HttpStatus.OK);
    }
    
    @PostMapping(path = "/prescriptiondetails", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<PrescriptionDetail> postPrescriptionDetail(@RequestBody PrescriptionDetail pd) {
        try {
            this.prescriptionDetailService.addPrescriptionDetail(pd);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping(path = "/prescriptiondetails/{prescriptionDetailId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void deletePrescriptionDetail(@PathVariable(value = "prescriptionDetailId") int id) {
        this.prescriptionDetailService.deletePrescriptionDetail(id);
    }
    
    @PutMapping(path = "/prescriptiondetails/{prescriptionDetailId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<PrescriptionDetail> updatePrescriptionDetail(@RequestBody PrescriptionDetail pd, @PathVariable("prescriptionDetailId") int prescriptionDetailId) {
        prescriptionDetailService.updatePrescriptionDetail(pd, prescriptionDetailId);
        return new ResponseEntity<>(pd, HttpStatus.OK);
    }
}
