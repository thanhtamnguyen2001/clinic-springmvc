/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository;

import com.dev.pojo.Prescription;
import com.dev.pojo.PrescriptionDetail;
import com.dev.pojo.User;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface PrescriptionRepository {

        List<Prescription> getCertificates(int id);

        Prescription createPrescription(int certificateID, User currentUser);
        
        Prescription getPrescriptionById(int prescriptionID);
        
        PrescriptionDetail addMedicine(int prescriptionID, int medicinID,  int quantity);
        
        List<Prescription> getPrescriptions(String name);
        
        boolean deletePrescription(int id);
        
        boolean addPrescription(Prescription p);
        
        public void updatePatchPrescription(Prescription prescription, int prescriptionId);
}
