/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.service.impl;

import com.dev.pojo.MedicalRegister;
import com.dev.repository.StatsRepository;
import com.dev.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author Thanh_Tam
 */
@Service
public class StatsServiceImpl implements StatsService {

        @Autowired
        private StatsRepository statsRepository;

        @Override
        public List<MedicalRegister> registerStats(Date fromDate, Date toDate) {
                return this.statsRepository.registerStats(fromDate, toDate);
        }

}
