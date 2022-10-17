/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.formatters;

import com.dev.pojo.MedicalRegister;
import com.dev.pojo.Prescription;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Lenovo
 */
public class MedicalRegisterFormatter implements Formatter<MedicalRegister>{
    @Override
    public String print(MedicalRegister p, Locale locale) {
        return String.valueOf(p.getId());
    }

    @Override
    public MedicalRegister parse(String medicalRegisterId, Locale locale) throws ParseException {
        MedicalRegister p = new MedicalRegister();
        p.setId(Integer.parseInt(medicalRegisterId));
        return p;
    }
}
