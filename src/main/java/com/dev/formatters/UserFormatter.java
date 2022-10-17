/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.formatters;
import com.dev.pojo.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
/**
 *
 * @author Lenovo
 */
public class UserFormatter implements Formatter<User>{
    @Override
    public String print(User p, Locale locale) {
        return String.valueOf(p.getId());
    }

    @Override
    public User parse(String userId, Locale locale) throws ParseException {
        User p = new User();
        p.setId(Integer.parseInt(userId));
        return p;
    }
}
