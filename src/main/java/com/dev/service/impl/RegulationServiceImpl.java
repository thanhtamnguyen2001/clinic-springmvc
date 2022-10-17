/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.dev.pojo.Regulations;
import com.dev.repository.RegulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.service.RegulationService;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
@Service
public class RegulationServiceImpl implements RegulationService {

    @Autowired
    RegulationRepository regulationRepository;

    @Override
    public Regulations getRegulation(int regurationID) {
        return this.regulationRepository.getRegulation(regurationID);
    }

    @Override
    public List<Regulations> getRegulations(boolean isActive) {
        return this.regulationRepository.getRegulations(isActive);
    }
    
    @Override
    public boolean deleteRegulation(int id) {
        return this.regulationRepository.deleteRegulation(id);
    }

    @Override
    public boolean addRegulation(Regulations r) {
        return this.regulationRepository.addRegulation(r);
    }

    @Override
    public void updatePatchRegulation(Regulations regulation, int regulationId) {
        this.regulationRepository.updatePatchRegulation(regulation, regulationId);
    }

}
