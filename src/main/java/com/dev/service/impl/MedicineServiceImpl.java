/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.dev.pojo.Medicine;
import com.dev.repository.MedicineRepository;
import com.dev.service.MedicineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thanh_Tam
 */
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getMedicines(String name) {
        return this.medicineRepository.getMedicines(name);
    }

    @Override
    public Medicine getMedicineById(int medicineID) {
        return this.medicineRepository.getMedicineById(medicineID);
    }

    @Override
    public boolean deleteMedicine(int id) {
        return this.medicineRepository.deleteMedicine(id);
    }

    @Override
    public boolean addMedicine(Medicine medicine) {
        return this.medicineRepository.addMedicine(medicine);
    }

    @Override
    public void updateMedicine(Medicine medicine, int medicineId) {
        this.medicineRepository.updateMedicine(medicine, medicineId);
    }

    @Override
    public void updatePatchMedicine(Medicine medicine, int medicineId) {
        this.medicineRepository.updatePatchMedicine(medicine, medicineId);
    }

}
