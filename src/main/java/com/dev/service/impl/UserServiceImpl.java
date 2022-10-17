/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dev.pojo.User;
import com.dev.repository.UserRepository;
import com.dev.service.UserRoleService;
import com.dev.service.UserService;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thanh_Tam
 */
@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User getUser(int userID) {
        return this.userRepository.getUser(userID);
    }

    @Override
    public boolean addUser(User user) {
        String password = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(password)); //bam password ra

        user.setUserRoleId(this.userRoleService.getUserRole(4));

        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        System.out.println("=====users=====" + users);

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User does not exist!!");  //khi username k ton tai spring security se xuat ra giao dien nguoi dung
        }

        User user = users.get(0);
        System.out.println("===========user=======" + user.getUserRoleId().getName());

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRoleId().getName()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public String toString() {
        return "hello";
    }

    @Override
    public List<User> getUsersRoleDoctor(int userRoleID) {
        return this.userRepository.getUsersRoleDoctor(userRoleID);
    }

    @Override
    public boolean addUserForAdmin(User user) {
        String password = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(password)); //bam password ra

        return this.userRepository.addUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return this.userRepository.deleteUser(id);
    }

        @Override
        public void updateUser(User user, int id) {
                this.userRepository.updateUser(user, id);
        }

}
