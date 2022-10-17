/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.MedicalRegister;
import com.dev.pojo.User;
import com.dev.repository.impl.PrescriptionRepositoryImpl;
import com.dev.service.MedicalRegisterService;
import com.dev.service.RegulationService;
import com.dev.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Thanh_Tam
 */
@Controller
public class MedicalRegisterController {

        @Autowired
        private MedicalRegisterService medicalRegisterService;
        @Autowired
        private RegulationService regulationService;
        @Autowired
        private UserService userService;

        //Dang ky kham benh
        @GetMapping("/medical-registry")
        public String registryView(Model model) {
                model.addAttribute("medical-regiter", new MedicalRegister());
                return "medical-registry";
        }

        @PostMapping("/medical-registry")
        public String add(@ModelAttribute(value = "medical-regiter") MedicalRegister medicalRegister, Model model) {
                String limitMsg = null;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                Date parsed = null;
                try {
                        parsed = dateFormat.parse(medicalRegister.getDateString());
                } catch (ParseException ex) {
                        Logger.getLogger(PrescriptionRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

                int limitPatients = this.regulationService.getRegulation(1).getPatientQuantity();
                Long registeredQuanitty = this.medicalRegisterService.countRegisterByDate(parsed);

                if (registeredQuanitty > limitPatients) {
                        limitMsg = "Đã vượt qua số lượng khám, vui lòng chọn ngày hẹn khác";
                        model.addAttribute("limitMsg", limitMsg);
                        return "medical-registry";
                }

                medicalRegister.setDateOfExamination(parsed);
                
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (principal instanceof UserDetails) {
                        String username = ((UserDetails) principal).getUsername();
                        User user = this.userService.getUsers(username).get(0);
                        if (user != null) {
                                System.out.println("=========user===========" + user);
                                medicalRegister.setUserId(user);
                        }
                } else {
                        String username = principal.toString();
                }

                boolean isAddMedicalRegister = this.medicalRegisterService.addMedicalRegister(medicalRegister);
                
                model.addAttribute("isSuccess", isAddMedicalRegister);


                return "index";
        }
}
