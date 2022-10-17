/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.MedicalRegister;
import com.dev.service.MedicalRegisterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Thanh_Tam
 */
@Controller
//@RequestMapping("")
public class NurseController {

        @Autowired
        private MedicalRegisterService medicalRegisterService;

        @GetMapping("/nurse")
        public String index() {
                return "nurse";

        }

        @GetMapping("/nurse/registration-list")
        public String registerList(Model model) {
                List<MedicalRegister> medicalRegisters = this.medicalRegisterService.getMedicalRegisters(3);

                model.addAttribute("medicalRegisters", medicalRegisters);

                return "registration-list";
        }

        
}
