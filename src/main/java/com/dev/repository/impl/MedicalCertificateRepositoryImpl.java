/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.MedicalCertificate;
import com.dev.pojo.MedicalCertificate_;
import com.dev.pojo.MedicalRegister;
import com.dev.pojo.Medicine;
import com.dev.repository.MedicalCertificateRepository;
import com.dev.service.MedicalRegisterService;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dev.service.RegulationService;

/**
 *
 * @author Thanh_Tam
 */
@Repository
@Transactional
public class MedicalCertificateRepositoryImpl implements MedicalCertificateRepository {

        @Autowired
        private LocalSessionFactoryBean sessionFactory;
        @Autowired
        private MedicalRegisterService medicalRegisterService;
        @Autowired
        private RegulationService regulationService;

        @Override
        public MedicalCertificate addMedicalCertificate(MedicalCertificate m) {
                if (m != null) {
                        Session session = this.sessionFactory.getObject().getCurrentSession();
//                        m.setMedicalRegisterId(this.medicalRegisterService.getMedicalRegister(1));
                        m.setRegulationId(this.regulationService.getRegulation(1));
                        System.out.println("======certificate====" + m.getDateOfExamination()+ "  " + m.getRegulationId()+ "  " + m.getMedicalRegisterId());
                        session.save(m);

                        return m;
                }

                return null;
        }

        @Override
        public MedicalCertificate getMedicalCertificate(int certificateID) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(MedicalCertificate.class);
                Root root = query.from(MedicalCertificate.class);

//                query.select(root);
//                Predicate p = builder.equal(root.get("medicalRegisterId"), certificateID); what is this
                Predicate p = builder.equal(root.get("id"), certificateID);

                query.where(p);

                Query q = session.createQuery(query);

                return (MedicalCertificate) q.getSingleResult();
        }

        @Override
        public List<Object[]> getMedicalCertificates(String phone) {

                if (phone != null) {
                        int phoneNumber = Integer.parseInt(phone);

                        Session session = this.sessionFactory.getObject().getCurrentSession();
                        CriteriaBuilder builder = session.getCriteriaBuilder();
                        CriteriaQuery query = builder.createQuery(Object[].class);
                        Root root = query.from(MedicalCertificate.class);

                        Join<MedicalCertificate, MedicalRegister> joinTable = root.join(MedicalCertificate_.medicalRegisterId);
                        Join<MedicalCertificate, Medicine> jointCertificateMedicine = root.join(MedicalCertificate_.prescriptionSet);

                        query.multiselect(root, joinTable, jointCertificateMedicine).where(builder.equal(joinTable.get("phoneNumber"), phoneNumber));

                        Query q = session.createQuery(query);

                        return q.getResultList();
                }

                return null;
        }

        @Override
        public List<MedicalCertificate> getMedicalCertificates(MedicalRegister medicalRegister) {
                if (medicalRegister != null) {

                        Session session = this.sessionFactory.getObject().getCurrentSession();
                        CriteriaBuilder builder = session.getCriteriaBuilder();
                        CriteriaQuery query = builder.createQuery(MedicalCertificate.class);
                        Root root = query.from(MedicalCertificate.class);

                        query.where(builder.equal(root.get("medicalRegisterId"), medicalRegister));

                        Query q = session.createQuery(query);

                        return q.getResultList();
                }

                return null;
        }

        public List<MedicalCertificate> getMedicalCertificates() {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(MedicalCertificate.class);
                Root root = query.from(MedicalCertificate.class);

                query.select(root);
                Query q = session.createQuery(query);

                return q.getResultList();
        }

        @Override
        public boolean deleteMedicalCertificate(int id) {
                Session session = this.sessionFactory.getObject().getCurrentSession();

                try {
                        MedicalCertificate mc = session.get(MedicalCertificate.class, id);
                        session.delete(mc);
                        return true;
                } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                }
        }

        @Override
        public boolean addMC(MedicalCertificate mc) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                try {
                        session.save(mc);
                        return true;
                } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                }

        }

        @Override
        public void updateMedicalCertificate(MedicalCertificate medicalCertificate, int id) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                MedicalCertificate mc = session.get(MedicalCertificate.class, id);
                if (medicalCertificate.getDateOfExamination() != null) {
                        mc.setDateOfExamination(medicalCertificate.getDateOfExamination());
                }
                if (medicalCertificate.getSymptom() != null) {
                        mc.setSymptom(medicalCertificate.getSymptom());
                }
                if (medicalCertificate.getConclusion() != null) {
                        mc.setConclusion(medicalCertificate.getConclusion());
                }
                if (medicalCertificate.getMedicalRegisterId() != null) {
                        mc.setMedicalRegisterId(medicalCertificate.getMedicalRegisterId());
                }
                if (medicalCertificate.getRegulationId() != null) {
                        mc.setRegulationId(medicalCertificate.getRegulationId());
                }

                session.update(mc);
        }
}
