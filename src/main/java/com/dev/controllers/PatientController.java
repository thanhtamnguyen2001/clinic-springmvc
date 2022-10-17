/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Thanh_Tam
 */
@Controller
public class PatientController {
        
        @GetMapping("/medical-history")
        public String medicalHistory() {
                return "medical-history";
        }
}
