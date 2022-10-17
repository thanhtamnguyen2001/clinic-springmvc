/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.dev.pojo.Prescription;
import com.dev.pojo.PrescriptionDetail;
import com.dev.pojo.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.service.PrescriptionService;
import com.dev.repository.PrescriptionRepository;
import com.dev.service.UserService;

/**
 *
 * @author Thanh_Tam
 */
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<Prescription> getCertificates(int id) {
        return this.prescriptionRepository.getCertificates(id);
    }

    @Override
    public Prescription createPrescription(int certificateID, User currentUser) {

        return this.prescriptionRepository.createPrescription(certificateID, currentUser);
    }

    @Override
    public Prescription getPrescriptionById(int prescriptionID) {
        return this.prescriptionRepository.getPrescriptionById(prescriptionID);
    }

    @Override
    public PrescriptionDetail addMedicine(int prescriptionID, int medicinID, int quantity) {
        return this.prescriptionRepository.addMedicine(prescriptionID, medicinID, quantity);
    }

    @Override
    public List<Prescription> getPrescriptions(String name) {
        return this.prescriptionRepository.getPrescriptions(name);
    }

    @Override
    public boolean deletePrescription(int id) {
        return this.prescriptionRepository.deletePrescription(id);
    }

    @Override
    public boolean addPrescription(Prescription p) {
        return this.prescriptionRepository.addPrescription(p);
    }

    @Override
    public void updatePatchPrescription(Prescription prescription, int prescriptionId) {
        this.prescriptionRepository.updatePatchPrescription(prescription, prescriptionId);
    }
        

}
