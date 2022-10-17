/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.formatters;

import com.dev.pojo.Unit;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Lenovo
 */
public class UnitFormatter implements Formatter<Unit>{

    @Override
    public String print(Unit u, Locale locale) {
        return String.valueOf(u.getId());
    }

    @Override
    public Unit parse(String unitId, Locale locale) throws ParseException {
        Unit u = new Unit();
        u.setId(Integer.parseInt(unitId));
        return u;
    }
    
}
