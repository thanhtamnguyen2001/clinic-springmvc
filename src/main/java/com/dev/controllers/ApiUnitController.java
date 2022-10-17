/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.Medicine;
import com.dev.pojo.Unit;
import com.dev.repository.UnitRepository;
import com.dev.service.UnitService;
import java.util.List;
import javax.validation.Valid;
import jdk.internal.org.jline.keymap.BindingReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
public class ApiUnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping(path = "/units", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Unit>> getUnits() {
        return new ResponseEntity<>(this.unitService.getUnits(), HttpStatus.OK);
    }

    @PostMapping(path = "/units", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Unit> postUnit(@RequestBody Unit u) {
        try {
            this.unitService.addUnit(u);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "/units/{unitId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void deleteUnit(@PathVariable(value = "unitId") int id) {
        this.unitService.deleteUnit(id);
    }

    @PutMapping(path = "/units/{unitId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Unit> updateUnit(@RequestBody Unit u, @PathVariable("unitId") int id) {
        try {
            unitService.updateUnit(u, id);
            return new ResponseEntity<>(u, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
