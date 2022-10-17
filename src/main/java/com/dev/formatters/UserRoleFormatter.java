/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.formatters;

import com.dev.pojo.UserRole;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Lenovo
 */
public class UserRoleFormatter implements Formatter<UserRole>{

    @Override
    public String print(UserRole p, Locale locale) {
        return String.valueOf(p.getId());
    }

    @Override
    public UserRole parse(String userRoleId, Locale locale) throws ParseException {
        UserRole p = new UserRole();
        p.setId(Integer.parseInt(userRoleId));
        return p;
    }
    
}
