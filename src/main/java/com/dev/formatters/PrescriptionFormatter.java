/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.formatters;

import com.dev.pojo.PrescriptionDetail;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Lenovo
 */
public class PrescriptionFormatter implements Formatter<PrescriptionDetail>{
    @Override
    public String print(PrescriptionDetail pd, Locale locale) {
        return String.valueOf(pd.getId());
    }

    @Override
    public PrescriptionDetail parse(String prescriptionDetailId, Locale locale) throws ParseException {
        PrescriptionDetail p = new PrescriptionDetail();
        p.setId(Integer.parseInt(prescriptionDetailId));
        return p;
    }
    
}
