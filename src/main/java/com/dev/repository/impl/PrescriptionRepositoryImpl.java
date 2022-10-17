/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.MedicalCertificate;
import com.dev.pojo.Medicine;
import com.dev.pojo.Prescription;
import com.dev.pojo.PrescriptionDetail;
import com.dev.pojo.User;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dev.repository.PrescriptionRepository;
import com.dev.service.MedicalCertificateService;
import com.dev.service.MedicineService;
import com.dev.service.PrescriptionService;
import com.dev.service.UserService;
import java.util.Date;
import javax.persistence.criteria.Predicate;

/**
 *
 * @author Thanh_Tam
 */
@Repository
@Transactional
public class PrescriptionRepositoryImpl implements PrescriptionRepository {

        @Autowired
        private LocalSessionFactoryBean sessionFactory;
        @Autowired
        private MedicalCertificateService medicalCertificateService;
        @Autowired
        private UserService userService;
        @Autowired
        private MedicineService medicineService;
//        @Autowired
//        private PrescriptionService prescriptionService;

        @Override
        public List<Prescription> getCertificates(int id) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(Object[].class);
                Root pRoot = query.from(Prescription.class);
                Root dRoot = query.from(PrescriptionDetail.class);

                query.where(builder.equal(pRoot.get("id").as(Integer.class), dRoot.get("prescriptionId")));
                query.multiselect(pRoot.get("id").as(Integer.class), dRoot.get("medicineId"));

                Query q = session.createQuery(query);

                return q.getResultList();
        }

        @Override
        public Prescription createPrescription(int certificateID, User currentUser) {
                Session session = this.sessionFactory.getObject().getCurrentSession();

                Prescription prescription = new Prescription();
                MedicalCertificate mc = this.medicalCertificateService.getMedicalCertificate(certificateID);
                Date rightNow = new Date();
                

                prescription.setMedicalCertificateId(mc);
                prescription.setUserId(currentUser);
                prescription.setCreatedDate(rightNow);

                session.save(prescription);

                return prescription;
        }

        @Override
        public PrescriptionDetail addMedicine(int prescriptionID, int medicinID, int quantity) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                
                PrescriptionDetail pd = new PrescriptionDetail();
                Medicine m = this.medicineService.getMedicineById(medicinID);
                Prescription p = this.getPrescriptionById(prescriptionID);
                
                pd.setMedicineId(m);
                pd.setPrescriptionId(p);
                pd.setMedicineQuantity(quantity);
                
                session.save(pd);
                
                return pd;
        }

        @Override
        public Prescription getPrescriptionById(int prescriptionID) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(Prescription.class);
                Root root = query.from(Prescription.class);
                
                query.where(builder.equal(root.get("id").as(Integer.class), prescriptionID));
                
                Query q  = session.createQuery(query);
                
                return (Prescription) q.getSingleResult();
        }
        
        @Override
        public List<Prescription> getPrescriptions(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Prescription.class);
        Root root = query.from(Prescription.class);

        if (name != null) {
            String nameString = String.format("%%%s%%", name);
            Predicate p = builder.like(root.get("prescriptionName").as(String.class), nameString);
            query.where(p);

            Query q = session.createQuery(query);

            return q.getResultList();
        }
        Query q = session.createQuery(query);

        return q.getResultList();

    }

    @Override
    public boolean deletePrescription(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Prescription p = session.get(Prescription.class, id);
            session.delete(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addPrescription(Prescription p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updatePatchPrescription(Prescription prescription, int prescriptionId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Prescription p = session.get(Prescription.class, prescriptionId);
        if (prescription.getMedicalCertificateId() != null) {
            p.setMedicalCertificateId(prescription.getMedicalCertificateId());
        }
        if (prescription.getUserId() != null) {
            p.setUserId(prescription.getUserId());
        }

        session.update(p);
    }

}
