/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service;

import com.dev.pojo.Unit;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface UnitService {

        Unit getUnitById(int unitID);

        List<Unit> getUnits();
        
        boolean deleteUnit(int id);
        
        void updateUnit(Unit u, int id);
        
        void addUnit(Unit u);
}
