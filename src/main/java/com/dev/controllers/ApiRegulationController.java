/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.Prescription;
import com.dev.pojo.PrescriptionDetail;
import com.dev.pojo.Regulations;
import com.dev.service.RegulationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ApiRegulationController {
    @Autowired
    private RegulationService regulationService;
    
    @GetMapping(path = "/regulations", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Regulations>> getRegulations() {
        return new ResponseEntity<>(this.regulationService.getRegulations(false), HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/regulations/{regulationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void deleteRegulation(@PathVariable(value = "regulationId") int id) {
        this.regulationService.deleteRegulation(id);
    }
    
    @PostMapping(path = "/regulations", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Regulations> postRegulation(@RequestBody Regulations regulation) {
        try {
            this.regulationService.addRegulation(regulation);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PatchMapping(path = "/regulations/{regulationId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Regulations> updatePatchRegulation(@RequestBody Regulations regulation, @PathVariable("regulationId") int regulationId) {
        regulationService.updatePatchRegulation(regulation, regulationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
