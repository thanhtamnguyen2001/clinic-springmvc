/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.dev.pojo.MedicalRegister;
import com.dev.pojo.User;
import com.dev.repository.MedicalRegisterRepository;
import com.dev.service.MedicalRegisterService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thanh_Tam
 */
@Service
public class MedicalRegisterServiceImpl implements MedicalRegisterService {

    @Autowired
    private MedicalRegisterRepository medicalRegisterRepository;

    @Override
    public boolean addMedicalRegister(MedicalRegister medicalRegister) {
        return this.medicalRegisterRepository.addMedicalRegister(medicalRegister);
    }

    @Override
    public List<MedicalRegister> getMedicalRegisters(int isVerified) {
        return this.medicalRegisterRepository.getMedicalRegisters(isVerified);
    }

    @Override
    public int verifiedMedicalRegister(int id) {
        return this.medicalRegisterRepository.verifiedMedicalRegister(id);
    }

    @Override
    public MedicalRegister getMedicalRegister(int medicalRegisterID) {
        return this.medicalRegisterRepository.getMedicalRegister(medicalRegisterID);
    }

    @Override
    public List<MedicalRegister> getMedicalRegistersByPhone(int phone) {
        return this.medicalRegisterRepository.getMedicalRegistersByPhone(phone);
    }

    @Override
    public Long countRegisterByDate(Date registerDate) {
        return this.medicalRegisterRepository.countRegisterByDate(registerDate);
    }

    @Override
    public List<MedicalRegister> getMedicalRegisterByUser(User user) {
        return this.medicalRegisterRepository.getMedicalRegisterByUser(user);
    }

    @Override
    public List<MedicalRegister> getMedicalRegisters() {
        return this.medicalRegisterRepository.getMedicalRegisters();
    }

        @Override
        public List<MedicalRegister> countMedicalRegistersByMonth(int month) {
                return this.medicalRegisterRepository.countMedicalRegistersByMonth(month);
        }

        @Override
        public List<MedicalRegister> countMedicalRegistersByQuarter(int quarter) {
                return this.medicalRegisterRepository.countMedicalRegistersByQuarter(quarter);
        }

        @Override
        public List<MedicalRegister> countMedicalRegistersByYear(int year) {
                return this.medicalRegisterRepository.countMedicalRegistersByYear(year);
        }

}
