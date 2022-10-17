/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.dev.pojo.Unit;
import com.dev.repository.UnitRepository;
import com.dev.service.UnitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thanh_Tam
 */
@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public Unit getUnitById(int unitID) {
        return this.unitRepository.getUnitById(unitID);
    }

    @Override
    public List<Unit> getUnits() {
        return this.unitRepository.getUnits();
    }

    @Override
    public boolean deleteUnit(int id) {
        return this.unitRepository.deleteUnit(id);
    }

    @Override
    public void updateUnit(Unit u, int id) {
        this.unitRepository.updateUnit(u, id);
    }

    @Override
    public void addUnit(Unit u) {
        this.unitRepository.addUnit(u); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
