/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository;

import com.dev.pojo.PrescriptionDetail;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface PrescriptionDetailRepository {

        PrescriptionDetail getPrescriptionDetailById(int prescriptionDetailID);

        PrescriptionDetail alterPrescriptionDetail(int prescriptionDetailID, String quantity);

        List<PrescriptionDetail> getPrescriptionDetails(int prescriptionID);

        boolean addPrescriptionDetail(PrescriptionDetail pd);

        boolean deletePrescriptionDetail(int id);

        void updatePrescriptionDetail(PrescriptionDetail pd, int prescriptionDetailId);

        List<Object[]> countMedicineByMonth(int month);

        List<Object[]> countMedicineByQuarter(int quarter);

        List<Object[]> countMedicineByYear(int year);

}
