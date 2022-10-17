/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.dev.pojo.MedicalCertificate;
import com.dev.pojo.MedicalRegister;
import com.dev.pojo.Medicine;
import com.dev.pojo.Prescription;
import com.dev.pojo.PrescriptionDetail;
import com.dev.pojo.User;
import com.dev.service.MedicalCertificateService;
import com.dev.service.MedicalRegisterService;
import com.dev.service.MedicineService;
import com.dev.service.PrescriptionDetailService;
import com.dev.service.PrescriptionService;
import com.dev.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thanh_Tam
 */
@RestController
public class ApiDoctorController {

        @Autowired
        private PrescriptionService prescriptionService;
        @Autowired
        private MedicalCertificateService medicalCertificateService;
        @Autowired
        private MedicalRegisterService medicalRegisterService;
        @Autowired
        private PrescriptionDetailService prescriptionDetailService;
        @Autowired
        private MedicineService medicineService;
        @Autowired
        private UserService userService;

        @GetMapping(path = "/doctor/get-certificate/{certificateID}", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<MedicalCertificate> getCertificateById(@PathVariable(value = "certificateID") int certificateID) {

                MedicalCertificate medicalCertificate = this.medicalCertificateService.getMedicalCertificate(certificateID);

                return new ResponseEntity<>(medicalCertificate, HttpStatus.OK);
        }

        @GetMapping(path = "/doctor/get-certificates", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<List<Object[]>> getCertificatesByPhone(@RequestParam(value = "phone", required = false) String phone) {
                if (phone != null) {
                        List<Object[]> medicalCertificates = this.medicalCertificateService.getMedicalCertificates(phone);

                        return new ResponseEntity<>(medicalCertificates, HttpStatus.OK);
                }

                return null;
        }

        @PostMapping(path = "/doctor/create-certificate/{registerID}", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<MedicalCertificate> createCertificate(@RequestBody MedicalCertificate medicalCertificate,
                @PathVariable(value = "registerID") int registerID) {
                MedicalRegister medicalRegister = this.medicalRegisterService.getMedicalRegister(registerID);

                medicalCertificate.setMedicalRegisterId(medicalRegister);

                return new ResponseEntity<>(this.medicalCertificateService.addMedicalCertificate(medicalCertificate), HttpStatus.CREATED);
        }

        //==================PRESCRIPTION=================
        @PostMapping(path = "/doctor/create-prescription/{certificateID}", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<Prescription> createPrescription(@PathVariable(value = "certificateID") int certificateID, @RequestBody Map<String, String> params) {
                String username = params.get("username");
                User currentUser = this.userService.getUsers(username).get(0);
                Prescription p = this.prescriptionService.createPrescription(certificateID, currentUser);

                return new ResponseEntity<>(p, HttpStatus.CREATED);
        }

        @PostMapping(path = "/doctor/add-medicine/{prescriptionID}", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<PrescriptionDetail> addMedicineIntoPresciption(@PathVariable(value = "prescriptionID") int prescriptionID,
                @RequestBody Map<String, String> params) {
                int medicineId = Integer.parseInt(params.get("medicineId"));
                int quantity = Integer.parseInt(params.get("quantity"));

                PrescriptionDetail pd = this.prescriptionService.addMedicine(prescriptionID, medicineId, quantity);
                PrescriptionDetail prescriptionDetail = this.prescriptionDetailService.getPrescriptionDetailById(pd.getId());

                return new ResponseEntity<>(prescriptionDetail, HttpStatus.CREATED);
        }

        @PostMapping(path = "/doctor/alter-medicine/{prescriptionDetailID}", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<PrescriptionDetail> alterMedicineInPrescription(@PathVariable(value = "prescriptionDetailID") int prescriptionDetailID,
                @RequestBody Map<String, String> params) {

                String quantity = params.get("quantity");
                System.out.println("=====================quanitity====" + quantity);

                PrescriptionDetail pd;
                if (quantity != null) {
                        pd = this.prescriptionDetailService.alterPrescriptionDetail(prescriptionDetailID, quantity);
                } else {
                        pd = this.prescriptionDetailService.alterPrescriptionDetail(prescriptionDetailID, null);
                }

                return new ResponseEntity<>(pd, HttpStatus.OK);
        }

        @GetMapping(path = "doctor/get-medicines", produces = {
                MediaType.APPLICATION_JSON_VALUE
        })
        public ResponseEntity<List<Medicine>> getMedicines(@RequestParam(value = "name", required = false) String name) {
                List<Medicine> medicines = this.medicineService.getMedicines(name);
                System.out.println("==========" + name);

                return new ResponseEntity<>(medicines, HttpStatus.OK);
        }

//        @PostMapping(path = "/doctor/certificate/")
//        public ResponseEntity<
}
