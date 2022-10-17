/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dev.pojo.User;
import com.dev.service.UserService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {

        @Autowired
        private UserService userDetailsService;
        @Autowired(required = false)
        private Cloudinary cloudinary;

        @GetMapping("/login")  
        public String login() {
                return "login";
        }

        @GetMapping("/register")
        public String registerView(Model model) {  
                model.addAttribute("user", new User());

                return "register";
        }

        @PostMapping("/register")
        public String register(@ModelAttribute(value = "user") User user, Model model) { 
                String errMsg = "";
                if (user.getPassword().equals(user.getConfirmPassword())) {
                        try {
                                Map resolve;
                                resolve = this.cloudinary.uploader().upload(user.getImage().getBytes(),
                                        ObjectUtils.asMap("resource_type", "auto"));
                                String img = (String) resolve.get("secure_url");
                                user.setAvatar(img);
                        } catch (IOException ex) { //Empty se loi -> tim cach xu ly di  
                                System.out.println(ex.getMessage());
                        }
                        if (this.userDetailsService.addUser(user) == true) {

                                return "redirect:/login";
                        } else {
                                errMsg = "Da co loi xay ra";
                        }
                } else {
                        errMsg = "Mat khau khong dung";
                }

                model.addAttribute("errMsg", errMsg);

                return "register";

        }
}
