/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.dev.pojo.UserRole;
import com.dev.repository.UserRoleRepository;
import com.dev.service.UserRoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thanh_Tam
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

        @Autowired
        private UserRoleRepository userRoleRepository;

        @Override
        public UserRole getUserRole(int userRoleID) {
                return this.userRoleRepository.getUserRole(userRoleID);
        }

    @Override
    public List<UserRole> getUserRoleNotRole(String roleName) {
        return this.userRoleRepository.getUserRoleNotRole(roleName);
    }

}
