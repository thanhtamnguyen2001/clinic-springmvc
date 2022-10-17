/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository;

import com.dev.pojo.MedicalRegister;
import com.dev.pojo.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface MedicalRegisterRepository {

        boolean addMedicalRegister(MedicalRegister medicalRegister);

        List<MedicalRegister> getMedicalRegisters(int isverified);

        MedicalRegister getMedicalRegister(int medicalRegisterID);

        int verifiedMedicalRegister(int idMedicalRegister);

        List<MedicalRegister> getMedicalRegistersByPhone(int phone);

        Long countRegisterByDate(Date registerDate);

        List<MedicalRegister> getMedicalRegisterByUser(User user);

        List<MedicalRegister> getMedicalRegisters();

        //Stats
        List<MedicalRegister> countMedicalRegistersByMonth(int month);

        List<MedicalRegister> countMedicalRegistersByQuarter(int quarter);

        List<MedicalRegister> countMedicalRegistersByYear(int year);

}
