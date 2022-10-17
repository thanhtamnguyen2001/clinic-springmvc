/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.MedicalCertificate;
import com.dev.pojo.MedicalRegister;
import com.dev.pojo.Prescription;
import com.dev.service.MedicalCertificateService;
import com.dev.service.MedicalRegisterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.dev.service.PrescriptionService;
import org.springframework.web.bind.annotation.PathVariable;
import com.dev.service.RegulationService;

/**
 *
 * @author Thanh_Tam
 */
@Controller
public class DoctorController {

        @Autowired
        private MedicalRegisterService medicalRegisterService;
        @Autowired
        private PrescriptionService prescriptionService;
        @Autowired
        private MedicalCertificateService medicalCertificateService;
        @Autowired 
        private RegulationService regurationService;

        @GetMapping("/doctor")
        public String index(Model model) {
                List<MedicalRegister> medicalRegisters = this.medicalRegisterService.getMedicalRegisters(1);

                model.addAttribute("medicalRegisters", medicalRegisters);
                

                return "doctor";
        }

        @GetMapping("/doctor/examine/{medicalRegisterID}")
        public String createPrescription(Model model, @PathVariable(value = "medicalRegisterID") String medicalRegisterID) {
                MedicalRegister medicalRegister = this.medicalRegisterService.getMedicalRegister(Integer.parseInt(medicalRegisterID));
                model.addAttribute("medicalRegister", medicalRegister);

                return "certificate";
        }

}
