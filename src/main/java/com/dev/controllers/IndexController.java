/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;
import com.dev.service.MedicalRegisterService;
import com.dev.service.PrescriptionDetailService;
import com.dev.service.RegulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Thanh_Tam
 */
@Controller
@Transactional
public class IndexController {
        
        @Autowired
        private RegulationService r;

        @GetMapping("/")
        public String index(Model model) {
                
                System.out.println("===============reguration==========" + this.r.getRegulation(1));
                
                return "index";
        }
}
