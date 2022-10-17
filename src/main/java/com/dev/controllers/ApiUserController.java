/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.User;
import com.dev.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {

        @Autowired
        private UserService userService;

        @GetMapping(path = "/users", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<List<User>> getUsers() {
                return new ResponseEntity<>(this.userService.getUsers(null), HttpStatus.OK);
        }

        @DeleteMapping(path = "/users/{userId}")
        @ResponseStatus(HttpStatus.NO_CONTENT) //204
        public ResponseEntity<Integer> deleteUser(@PathVariable(value = "userId") int id) {
                User u = this.userService.getUser(id);
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (principal instanceof UserDetails) {
                        String username = ((UserDetails) principal).getUsername();
                        User user = this.userService.getUsers(username).get(0);

                        if (user != null) {
                                if (u.getUserRoleId().getId() != user.getUserRoleId().getId() && u.getUserRoleId().getId() != 5) {
                                        this.userService.deleteUser(id);
                                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                }
                                return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);

                        }
                }
                return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
}
