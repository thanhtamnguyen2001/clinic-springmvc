/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository;

import com.dev.pojo.User;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface UserRepository {

        User getUser(int userID);

        boolean addUser(User user);

        List<User> getUsers(String username);

        List<User> getUsersRoleDoctor(int userRoleID);

        boolean deleteUser(int id);

        void updateUser(User user, int id);
}
