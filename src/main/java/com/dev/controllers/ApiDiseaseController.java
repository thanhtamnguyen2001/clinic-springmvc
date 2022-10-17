/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.Disease;
import com.dev.service.DiseaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("/api")
public class ApiDiseaseController {
    @Autowired
    private DiseaseService diseaseService;
    
    @GetMapping(path = "/diseases", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Disease>> getDiseases() {
        return new ResponseEntity<>(this.diseaseService.getDiseases(), HttpStatus.OK);
    }
    
    @PostMapping(path = "/diseases", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Disease> postDisease(@RequestBody Disease pd) {
        try {
            this.diseaseService.addDisease(pd);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @DeleteMapping(path = "/diseases/{diseaseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void deleteDisease(@PathVariable(value = "diseaseId") int id) {
        this.diseaseService.deleteDisease(id);
    }
    
    @PutMapping(path = "/diseases/{diseaseId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Disease> updateDisease(@RequestBody Disease disease, @PathVariable("diseaseId") int diseaseId) {
        diseaseService.updateDisease(disease, diseaseId);
        return new ResponseEntity<>(disease, HttpStatus.OK);
    }
}
