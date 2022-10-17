/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service;

import com.dev.pojo.UserRole;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface UserRoleService {

        UserRole getUserRole(int userRoleID);
        
        List<UserRole> getUserRoleNotRole(String roleName);
}
