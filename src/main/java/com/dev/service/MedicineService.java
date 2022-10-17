/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service;

import com.dev.pojo.Medicine;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface MedicineService {

        List<Medicine> getMedicines(String name);

        Medicine getMedicineById(int medicineID);
        
        boolean deleteMedicine(int id);
        
        boolean addMedicine(Medicine medicine);
        
        void updateMedicine(Medicine medicine, int medicineId);
        
        void updatePatchMedicine(Medicine medicine, int medicineId);
}
