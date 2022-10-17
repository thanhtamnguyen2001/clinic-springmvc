
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.formatters;
import com.dev.pojo.Medicine;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Lenovo
 */
public class MedicineFormatter implements Formatter<Medicine>{
    @Override
    public String print(Medicine m, Locale locale) {
        return String.valueOf(m.getId());
    }

    @Override
    public Medicine parse(String medicineId, Locale locale) throws ParseException {
        Medicine m = new Medicine();
        m.setId(Integer.parseInt(medicineId));
        return m;
    }
}
