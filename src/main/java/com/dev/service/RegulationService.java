/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service;

import com.dev.pojo.Regulations;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface RegulationService {
        Regulations getRegulation(int regurationID);
        
        List<Regulations> getRegulations(boolean isActive);
        
        boolean deleteRegulation(int id);
        
        boolean addRegulation(Regulations p);
        
        public void updatePatchRegulation(Regulations regulation, int regulationId);
}
