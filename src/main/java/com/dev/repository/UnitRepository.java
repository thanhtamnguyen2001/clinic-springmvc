/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository;

import com.dev.pojo.Unit;
import java.util.List;

/**
 *
 * @author Thanh_Tam
 */
public interface UnitRepository {
        
        Unit getUnitById(int unitID);
        
        List<Unit> getUnits();
        
        boolean deleteUnit(int id);
        
        void updateUnit(Unit unit, int id);
        
        void addUnit(Unit u);
}
