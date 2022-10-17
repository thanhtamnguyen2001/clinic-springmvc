/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.Medicine;
import com.dev.pojo.Prescription;
import com.dev.pojo.Unit;
import com.dev.service.PrescriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ApiPrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;
    
    @GetMapping(path = "/prescriptions", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Prescription>> getPrescriptions() {
        return new ResponseEntity<>(this.prescriptionService.getPrescriptions(null), HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/prescriptions/{prescriptionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void deletePrescription(@PathVariable(value = "prescriptionId") int id) {
        this.prescriptionService.deletePrescription(id);
    }
    
    @PostMapping(path = "/prescriptions", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Prescription> postPrescription(@RequestBody Prescription p) {
        try {
            this.prescriptionService.addPrescription(p);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PatchMapping(path = "/prescriptions/{prescriptionId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Prescription> updatePatchPrescription(@RequestBody Prescription p, @PathVariable("prescriptionId") int prescriptionId) {
        prescriptionService.updatePatchPrescription(p, prescriptionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
