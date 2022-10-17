/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service;

import com.dev.pojo.Prescription;
import com.dev.pojo.PrescriptionDetail;
import com.dev.pojo.User;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface PrescriptionService {

        List<Prescription> getCertificates(int id);
        
        Prescription getPrescriptionById(int prescriptionID);

        Prescription createPrescription(int certificateID, User currentUser);
        
        PrescriptionDetail addMedicine(int prescriptionID, int medicinID,  int quantity);
        
        List<Prescription> getPrescriptions(String name);
        
        boolean deletePrescription(int id);
        
        boolean addPrescription(Prescription p);
        
        void updatePatchPrescription(Prescription prescription, int prescriptionId);
}
