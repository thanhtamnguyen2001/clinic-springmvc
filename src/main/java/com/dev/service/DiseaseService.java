/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service;

import com.dev.pojo.Disease;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface DiseaseService {
    Disease getDisease(int diseaseID);

    List<Disease> getDiseases();

    boolean deleteDisease(int id);

    boolean addDisease(Disease disease);

    void updateDisease(Disease disease, int diseaseId);
}
