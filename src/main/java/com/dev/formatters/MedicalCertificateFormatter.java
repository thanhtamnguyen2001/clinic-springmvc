/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.formatters;

import com.dev.pojo.MedicalCertificate;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Lenovo
 */
public class MedicalCertificateFormatter implements Formatter<MedicalCertificate> {

        @Override
        public String print(MedicalCertificate p, Locale locale) {
                return String.valueOf(p.getId());
        }

        @Override
        public MedicalCertificate parse(String prescriptionId, Locale locale) throws ParseException {
                MedicalCertificate p = new MedicalCertificate();
                p.setId(Integer.parseInt(prescriptionId));
                return p;
        }
}
