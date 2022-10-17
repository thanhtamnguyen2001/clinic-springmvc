/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.dev.pojo.MedicalCertificate;
import com.dev.pojo.MedicalRegister;
import com.dev.repository.MedicalCertificateRepository;
import com.dev.service.MedicalCertificateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thanh_Tam
 */
@Service
public class MedicalCertificateServiceImpl implements MedicalCertificateService {

    @Autowired
    MedicalCertificateRepository medicalCertificateRepository;

    @Override
    public MedicalCertificate addMedicalCertificate(MedicalCertificate m) {
        return this.medicalCertificateRepository.addMedicalCertificate(m);
    }

    @Override
    public MedicalCertificate getMedicalCertificate(int certificateID) {
        return this.medicalCertificateRepository.getMedicalCertificate(certificateID);
    }

    @Override
    public List<Object[]> getMedicalCertificates(String phone) {
        return this.medicalCertificateRepository.getMedicalCertificates(phone);
    }

    @Override
    public List<MedicalCertificate> getMedicalCertificates(MedicalRegister medicalRegister) {
        return this.medicalCertificateRepository.getMedicalCertificates(medicalRegister);
    }

    @Override
    public List<MedicalCertificate> getMedicalCertificates() {
        return this.medicalCertificateRepository.getMedicalCertificates();
    }

    @Override
    public boolean deleteMedicalCertificate(int id) {
        return this.medicalCertificateRepository.deleteMedicalCertificate(id);
    }

    @Override
    public boolean addMC(MedicalCertificate mc) {
        return this.medicalCertificateRepository.addMC(mc);
    }

    @Override
    public void updateMedicalCertificate(MedicalCertificate mc, int id) {
        this.medicalCertificateRepository.updateMedicalCertificate(mc, id);
    }
}
