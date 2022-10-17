/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Thanh_Tam
 */
@Controller
@ControllerAdvice
public class CommonController {

        @Autowired
        private UserService userService;

        @ModelAttribute
        public void addAttributes(Model model) {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (principal instanceof UserDetails) {
                        String username = ((UserDetails) principal).getUsername();
                        String avatar = this.userService.getUsers(username).get(0).getAvatar();
                        String user_role = this.userService.getUsers(username).get(0).getUserRoleId().getName();

                        model.addAttribute("username", username);
                        model.addAttribute("avatar", avatar);
                        model.addAttribute("user_role", user_role);
                } else {
                        String username = principal.toString();
                }
        }
}
