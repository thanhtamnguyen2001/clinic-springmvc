/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.MedicalRegister;
import com.dev.pojo.User;
import com.dev.repository.MedicalRegisterRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thanh_Tam
 */
@Repository
@Transactional
public class MedicalRegisterRepositoryImpl implements MedicalRegisterRepository {

        @Autowired
        private LocalSessionFactoryBean sessionFactory;

        @Override
        public boolean addMedicalRegister(MedicalRegister medicalRegister) {
                Session session = this.sessionFactory.getObject().getCurrentSession();

                if (medicalRegister != null) {
                        MedicalRegister m = new MedicalRegister();
                        m.setPatientName(medicalRegister.getPatientName());
                        m.setEmail(medicalRegister.getEmail());
                        m.setPhoneNumber(medicalRegister.getPhoneNumber());
                        m.setHealthIssues(medicalRegister.getHealthIssues());
                        m.setDateOfExamination(medicalRegister.getDateOfExamination());
                        m.setIsVerified(Boolean.FALSE);

                        if (medicalRegister.getUserId() != null) {
                                m.setUserId(medicalRegister.getUserId());
                        }
                        session.save(m);
                        return true;
                }

                return false;
        }

        @Override
        public List<MedicalRegister> getMedicalRegisters(int isVerified) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(MedicalRegister.class);
                Root root = query.from(MedicalRegister.class);

                query.select(root);
                System.out.println("===========" + isVerified);
                if (isVerified == 1) {
                        Predicate p = builder.equal(root.get("isVerified").as(Boolean.class), true);

                        query.where(p);
                }
                if (isVerified == 0) {
                        Predicate p = builder.equal(root.get("isVerified").as(Boolean.class), false);
                        query.where(p);
                }

                Query q = session.createQuery(query);

                return q.getResultList();
        }

        @Override
        public int verifiedMedicalRegister(int id) {
                Session session = this.sessionFactory.getObject().getCurrentSession();

                boolean isVerified = session.get(MedicalRegister.class, id).getIsVerified();

                Query q = session.createQuery("UPDATE MedicalRegister  m SET m.isVerified =: isVerified WHERE id =: id");
                q.setParameter("isVerified", !isVerified);
                q.setParameter("id", id);

                return q.executeUpdate();
        }

        @Override
        public MedicalRegister getMedicalRegister(int medicalRegisterID) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(MedicalRegister.class);
                Root root = query.from(MedicalRegister.class);

                Predicate p = builder.equal(root.get("id").as(Integer.class), medicalRegisterID);

                query.where(p);

                Query q = session.createQuery(query);

//                System.out.println("=======certificate=====" + ((MedicalRegister) q.getSingleResult()).getMedicalCertificateSet());
                return (MedicalRegister) q.getSingleResult();
        }

        @Override
        public List<MedicalRegister> getMedicalRegistersByPhone(int phone) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(MedicalRegister.class);
                Root root = query.from(MedicalRegister.class);

                Predicate p = builder.equal(root.get("phoneNumber"), phone);

                query.where(p);

                Query q = session.createQuery(query);

                return q.getResultList();
        }

        @Override
        public Long countRegisterByDate(Date registerDate) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(MedicalRegister.class);
                Root root = query.from(MedicalRegister.class);

                Predicate p = builder.equal(root.get("dateOfExamination"), registerDate);
                query.select(builder.count(root.get("id")));
                query.where(p);

                Query q = session.createQuery(query);

                return (Long) q.getSingleResult();

        }

        @Override
        public List<MedicalRegister> getMedicalRegisterByUser(User user) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(MedicalRegister.class);
                Root root = query.from(MedicalRegister.class);

                Predicate p = builder.equal(root.get("userId"), user);
                query.where(p);

                Query q = session.createQuery(query);

                return q.getResultList();
        }

        @Override
        public List<MedicalRegister> getMedicalRegisters() {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(MedicalRegister.class);
                Root root = query.from(MedicalRegister.class);
                Query q = session.createQuery(query);

                return q.getResultList();

        }

        @Override
        public List<MedicalRegister> countMedicalRegistersByMonth(int month) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                System.out.println("===============year repository" + month);

                Query query = session.createQuery("SELECT COUNT(*) FROM MedicalRegister m WHERE month(m.dateOfExamination)=: month");
                query.setParameter("month", month);

                return query.getResultList();
        }

        @Override
        public List<MedicalRegister> countMedicalRegistersByQuarter(int quarter) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                System.out.println("===============year repository" + quarter);

                Query query = session.createQuery("SELECT COUNT(*) FROM MedicalRegister m WHERE quarter(m.dateOfExamination)=: quarter");
                query.setParameter("quarter", quarter);

                return   query.getResultList();
        }

        @Override
        public List<MedicalRegister> countMedicalRegistersByYear(int year) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                System.out.println("===============year repository" + year);

                Query query = session.createQuery("SELECT COUNT(*) FROM MedicalRegister m WHERE year(m.dateOfExamination)=: year");
                query.setParameter("year", year);

                return query.getResultList();
        }

}
