/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dev.pojo.Disease;
import com.dev.pojo.MedicalCertificate;
import com.dev.pojo.MedicalRegister;
import com.dev.pojo.Medicine;
import com.dev.pojo.Regulations;
import com.dev.pojo.Unit;
import com.dev.pojo.User;
import com.dev.repository.impl.PrescriptionRepositoryImpl;
import com.dev.service.DiseaseService;
import com.dev.service.MedicalCertificateService;
import com.dev.service.MedicalRegisterService;
import com.dev.service.MedicineService;
import com.dev.service.PrescriptionDetailService;
import com.dev.service.PrescriptionService;
import com.dev.service.RegulationService;
import com.dev.service.StatsService;
import com.dev.service.UnitService;
import com.dev.service.UserRoleService;
import com.dev.service.UserService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Thanh_Tam
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

        @Autowired(required = false)
        private Cloudinary cloudinary;

        @Autowired
        private UnitService unitService;

        @Autowired
        private MedicineService medicineService;

        @Autowired
        private PrescriptionService prescriptionService;

        @Autowired
        private UserService userDetailsService;

        @Autowired
        private MedicalCertificateService medicalCertificateService;

        @Autowired
        private PrescriptionDetailService prescriptionDetailService;

        @Autowired
        private RegulationService regulationService;

        @Autowired
        private DiseaseService diseaseService;

        @Autowired
        private MedicalRegisterService medicalRegisterService;

        @Autowired
        private UserRoleService userRoleService;

        @Autowired
        private StatsService statsService;

        @GetMapping("/admin")
        public String manage() {
                return "admin";
        }

        @GetMapping("/stats")
        public String stats() {
                return "stats";
        }

        @GetMapping("/register-stats")
        public String registerStats(Model model) {
                model.addAttribute("registerStats", this.statsService.registerStats(null, null));

                return "register-stats";
        }

        @GetMapping("/medicines")
        public String medicine(Model model) {
                model.addAttribute("medicine", new Medicine());
                model.addAttribute("units", this.unitService.getUnits());
                return "medicines";
        }

        @GetMapping("/medicines/{medicineId}")
        public String medicineDetail(Model model, @PathVariable(value = "medicineId") int medicineId) {
                model.addAttribute("medicine", this.medicineService.getMedicineById(medicineId));
                model.addAttribute("units", this.unitService.getUnits());
                return "medicine-detail";
        }

        //BindingResult là tham số chứa lỗi
        @PostMapping("/medicines")
        public String addMedicine(@ModelAttribute(value = "medicine") @Valid Medicine m, BindingResult rs) {
                if (rs.hasErrors()) {
                        return "medicines";
                }
                if (this.medicineService.addMedicine(m) == true) {
                        return "redirect:/";
                }
                return "medicines";
        }

        @GetMapping("/units")
        public String unit(Model model) {
                model.addAttribute("unit", new Unit());
                return "units";
        }

        @GetMapping("/units/{unitId}")
        public String unitDetail(Model model, @PathVariable(value = "unitId") int id) {
                model.addAttribute("unit", this.unitService.getUnitById(id));
                return "unit-detail";
        }

        @GetMapping("/prescriptions")
        public String getPrescriptions(Model model) {
//        model.addAttribute("prescription", new Prescription());
                model.addAttribute("users", this.userDetailsService.getUsersRoleDoctor(2));
                model.addAttribute("medicalCertificates", this.medicalCertificateService.getMedicalCertificates());
                return "prescriptions";
        }

        @GetMapping("/prescriptions/{prescriptionId}")
        public String prescriptionEdit(Model model, @PathVariable(value = "prescriptionId") int prescriptionId) {
                model.addAttribute("prescription", this.prescriptionService.getPrescriptionById(prescriptionId));
                model.addAttribute("users", this.userDetailsService.getUsersRoleDoctor(2));
                model.addAttribute("medicalCertificates", this.medicalCertificateService.getMedicalCertificates());
                return "prescription-edit";
        }

        @GetMapping("/prescription-detail")
        public String getPrescriptionDetails(Model model) {
                model.addAttribute("prescriptions", this.prescriptionService.getPrescriptions(null));
                model.addAttribute("medicines", this.medicineService.getMedicines(null));
                return "prescription-detail";
        }

        @GetMapping("/prescription-detail/{prescriptionDetailId}")
        public String getPrescriptionDetail(Model model, @PathVariable(value = "prescriptionDetailId") int id) {
                model.addAttribute("prescriptionDetail", this.prescriptionDetailService.getPrescriptionDetailById(id));
                model.addAttribute("prescriptions", this.prescriptionService.getPrescriptions(null));
                model.addAttribute("medicines", this.medicineService.getMedicines(null));
                return "prescription-detail-edit";
        }

        @GetMapping("/regulations")
        public String getRegulations(Model model) {
                model.addAttribute("regulation", new Regulations());
                return "regulations";
        }

        @PostMapping("/regulations")
        public String addRegulation(@ModelAttribute(value = "regulation") @Valid Regulations r, BindingResult rs) {
                if (rs.hasErrors()) {
                        return "regulations";
                }
                if (this.regulationService.addRegulation(r) == true) {
                        return "redirect:/";
                }
                return "regulations";
        }

        @GetMapping("/regulations/{regulationId}")
        public String getRegulationDetail(Model model, @PathVariable(value = "regulationId") int id) {
                model.addAttribute("regulation", this.regulationService.getRegulation(id));
                return "regulation-detail";
        }

        @GetMapping("/diseases")
        public String getDiseases(Model model) {
                model.addAttribute("disease", new Disease());
                return "diseases";
        }

        @PostMapping("/diseases")
        public String addDisease(@ModelAttribute(value = "disease") @Valid Disease d, BindingResult rs) {
                if (rs.hasErrors()) {
                        return "diseases";
                }
                if (this.diseaseService.addDisease(d) == true) {
                        return "redirect:/";
                }
                return "diseases";
        }

        @GetMapping("/diseases/{diseaseId}")
        public String getDiseaseDetail(Model model, @PathVariable(value = "diseaseId") int id) {
                model.addAttribute("disease", this.diseaseService.getDisease(id));
                return "disease-detail";
        }

        @GetMapping("/medical-certificates")
        public String getMedicalCertificates(Model model) {
                model.addAttribute("medicalCertificate", new MedicalCertificate());
                model.addAttribute("medicalRegisters", this.medicalRegisterService.getMedicalRegisters());
                model.addAttribute("regulations", this.regulationService.getRegulations(true));
                return "medical-certificates";
        }

        @PostMapping("/medical-certificates")
        public String addMedicalCertificate(@ModelAttribute(value = "medicalCertificate") @Valid MedicalCertificate mc, BindingResult rs) {
                if (rs.hasErrors()) {
                        return "medical-certificates";
                }
                if (this.medicalCertificateService.addMC(mc) == true) {
                        return "redirect:/";
                }
                return "medical-certificates";
        }

        @GetMapping("/medical-certificates/{medicalCertificateId}")
        public String getMedicalCertificateDetail(Model model, @PathVariable(value = "medicalCertificateId") int id) {
                model.addAttribute("medicalCertificate", this.medicalCertificateService.getMedicalCertificate(id));
                model.addAttribute("medicalRegisters", this.medicalRegisterService.getMedicalRegisters());
                model.addAttribute("regulations", this.regulationService.getRegulations(true));
                return "medical-certificate-detail";
        }

        @GetMapping("/users")
        public String getUsers(Model model) {
                model.addAttribute("user", new User());
                model.addAttribute("roles", this.userRoleService.getUserRoleNotRole("ROLE_SUPERADMIN"));
                return "users";
        }

        @PostMapping("/users")
        public String addUser(Model model, @ModelAttribute(value = "user") @Valid User user, BindingResult rs) throws ParseException {
                if (rs.hasErrors()) {
                        return "users";
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                Date parsed = null;
                parsed = dateFormat.parse(user.getDateString());
                user.setDateOfBirth(parsed);
                String errMsg = "";
                if (user.getPassword().equals(user.getConfirmPassword())) {
                        try {
                                Map resolve;
                                resolve = this.cloudinary.uploader().upload(user.getImage().getBytes(),
                                        ObjectUtils.asMap("resource_type", "auto"));
                                String img = (String) resolve.get("secure_url");
                                user.setAvatar(img);
                        } catch (IOException ex) { //Empty se loi -> tim cach xu ly di  
                                System.out.println(ex.getMessage());
                        }
                        if (this.userDetailsService.addUserForAdmin(user) == true) {

                                return "redirect:/";
                        } else {
                                errMsg = "Da co loi xay ra";
                        }
                } else {
                        errMsg = "Mat khau khong dung";
                }

                model.addAttribute("errMsg", errMsg);

                return "users";

        }

        @GetMapping("/users/{userId}")
        public String getUserDetail(Model model, @PathVariable(value = "userId") int id) {
                model.addAttribute("user", this.userDetailsService.getUser(id));
                model.addAttribute("roles", this.userRoleService.getUserRoleNotRole("ROLE_SUPERADMIN"));
                return "user-detail";
        }

}
