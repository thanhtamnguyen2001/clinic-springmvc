/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.service.MedicalRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thanh_Tam
 */
@RestController
public class ApiNurseController {
        
        @Autowired
        private MedicalRegisterService medicalRegisterService;
        
        @PostMapping("/verified-medical-register/{medicalRegisterId}")
        public ResponseEntity<Integer> verifiedMedicalRegister(@PathVariable(value = "medicalRegisterId") int medicalRegisterId) {
                int isVerified = this.medicalRegisterService.verifiedMedicalRegister(medicalRegisterId);

                return new ResponseEntity<>(isVerified, HttpStatus.OK);
        }
}
