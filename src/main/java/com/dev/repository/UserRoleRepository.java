/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository;

import com.dev.pojo.UserRole;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface UserRoleRepository {
        
        UserRole getUserRole(int userRoleID);
        
        List<UserRole> getUserRoleNotRole(String roleName);
}
