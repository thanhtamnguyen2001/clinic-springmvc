/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.Disease;
import com.dev.pojo.MedicalCertificate;
import com.dev.service.DiseaseService;
import com.dev.service.MedicalCertificateService;
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
public class ApiMedicalCertificateController {
    @Autowired
    private MedicalCertificateService medicalCertificateService;
    
    @GetMapping(path = "/medical-certificates", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<MedicalCertificate>> getMedicalCertificates() {
        return new ResponseEntity<>(this.medicalCertificateService.getMedicalCertificates(), HttpStatus.OK);
    }
    
    @PostMapping(path = "/medical-certificates", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<MedicalCertificate> postMedicalCertificate(@RequestBody MedicalCertificate mc) {
        try {
            this.medicalCertificateService.addMC(mc);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping(path = "/medical-certificates/{medicalCertificateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void deleteMedicalCertificate(@PathVariable(value = "medicalCertificateId") int id) {
        this.medicalCertificateService.deleteMedicalCertificate(id);
    }
    
    @PutMapping(path = "/medical-certificates/{medicalCertificateId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<MedicalCertificate> updateMedicalCertificate(@RequestBody MedicalCertificate mc, @PathVariable("medicalCertificateId") int id) {
        medicalCertificateService.updateMedicalCertificate(mc, id);
        return new ResponseEntity<>(mc, HttpStatus.OK);
    }
}
