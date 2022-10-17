/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.formatters;

import com.dev.pojo.Regulations;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Lenovo
 */
public class RegulationFormatter implements Formatter<Regulations>{
    @Override
    public String print(Regulations p, Locale locale) {
        return String.valueOf(p.getId());
    }

    @Override
    public Regulations parse(String regulationId, Locale locale) throws ParseException {
        Regulations p = new Regulations();
        p.setId(Integer.parseInt(regulationId));
        return p;
    }
}
