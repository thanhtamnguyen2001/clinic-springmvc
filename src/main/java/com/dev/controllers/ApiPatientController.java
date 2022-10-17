/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.MedicalCertificate;
import com.dev.pojo.MedicalRegister;
import com.dev.pojo.Prescription;
import com.dev.pojo.PrescriptionDetail;
import com.dev.pojo.User;
import com.dev.service.MedicalCertificateService;
import com.dev.service.MedicalRegisterService;
import com.dev.service.PrescriptionDetailService;
import com.dev.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thanh_Tam
 */
@RestController
public class ApiPatientController {

        @Autowired
        private UserService userService;
        @Autowired
        private MedicalRegisterService medicalRegiterService;
        @Autowired
        private MedicalCertificateService medicalCertificateService;
        @Autowired
        private PrescriptionDetailService prescriptionDetailService;
        

        @GetMapping(path = "/patient/medical-history", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<List<List<MedicalCertificate>>> getMedicalRegisterByUser() {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                List<MedicalRegister> medicalRegisters = null;
                List<List<MedicalCertificate>> medicalCertificates = new ArrayList<>();

                if (principal instanceof UserDetails) {
                        String username = ((UserDetails) principal).getUsername();
                        User user = this.userService.getUsers(username).get(0);

                        if (user != null) {
                                medicalRegisters = this.medicalRegiterService.getMedicalRegisterByUser(user);
                                medicalRegisters.forEach(m -> medicalCertificates.add(this.medicalCertificateService.getMedicalCertificates(m)));

                                return new ResponseEntity<>(medicalCertificates, HttpStatus.OK);
                        }
                }

                return null;
        }
        
        @GetMapping(path = "/get-prescription/{certificateID}", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<Set<Prescription>> getPrescription(@PathVariable(value = "certificateID") int certificateID) {
                Set<Prescription> prescriptions =  this.medicalCertificateService.getMedicalCertificate(certificateID).getPrescriptionSet();
                
                
                return new ResponseEntity<>(prescriptions, HttpStatus.OK);
        }
        
        @GetMapping(path = "/get-prescriptionDetail/{prescriptionID}", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<List<PrescriptionDetail>> getprescriptionDetail(@PathVariable(value = "prescriptionID") int prescriptionID) {
                List<PrescriptionDetail> prescriptionDetails =  this.prescriptionDetailService.getPrescriptionDetails(prescriptionID);
                
                
                return new ResponseEntity<>(prescriptionDetails, HttpStatus.OK);
        }
}
