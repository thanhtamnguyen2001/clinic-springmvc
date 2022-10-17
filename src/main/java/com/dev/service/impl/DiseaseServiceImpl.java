/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.dev.pojo.Disease;
import com.dev.repository.DiseaseRepository;
import com.dev.service.DiseaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class DiseaseServiceImpl implements DiseaseService{
    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public Disease getDisease(int diseaseID) {
        return this.diseaseRepository.getDisease(diseaseID);
    }

    @Override
    public List<Disease> getDiseases() {
        return this.diseaseRepository.getDiseases();
    }

    @Override
    public boolean deleteDisease(int id) {
        return this.diseaseRepository.deleteDisease(id);
    }

    @Override
    public boolean addDisease(Disease disease) {
        return this.diseaseRepository.addDisease(disease);
    }

    @Override
    public void updateDisease(Disease disease, int diseaseId) {
        this.diseaseRepository.updateDisease(disease, diseaseId);
    }
    
}
