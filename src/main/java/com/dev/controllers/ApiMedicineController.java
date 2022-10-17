/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.Medicine;
import com.dev.service.MedicineService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("/api")
public class ApiMedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping(path = "/medicines", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Medicine>> getMedicines() {
        return new ResponseEntity<>(this.medicineService.getMedicines(null), HttpStatus.OK);
    }
    
    @GetMapping(path = "/medicines/{medicineId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Medicine> getMedicinesById(@PathVariable(value="medicineId") int id) {
        Medicine m = this.medicineService.getMedicineById(id);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @DeleteMapping(path = "/medicines/{medicineId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void deleteMedicine(@PathVariable(value = "medicineId") int id) {
        this.medicineService.deleteMedicine(id);
    }
    
    @PutMapping(path = "/medicines/{medicineId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Medicine> updateMedicine(@RequestBody Medicine m, @PathVariable("medicineId") int medicineId) {
        medicineService.updateMedicine(m, medicineId);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }
    
    @PatchMapping(path = "/medicines/{medicineId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Medicine> updatePatchMedicine(@RequestBody Medicine m, @PathVariable("medicineId") int medicineId) {
        medicineService.updatePatchMedicine(m, medicineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
