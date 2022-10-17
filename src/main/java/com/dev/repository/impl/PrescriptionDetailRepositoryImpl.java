/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.PrescriptionDetail;
import com.dev.pojo.Prescription;
import com.dev.repository.PrescriptionDetailRepository;
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

/**
 *
 * @author Thanh_Tam
 */
@Repository
@Transactional
public class PrescriptionDetailRepositoryImpl implements PrescriptionDetailRepository {

        @Autowired
        LocalSessionFactoryBean sessionFactory;

        @Override
        public PrescriptionDetail getPrescriptionDetailById(int prescriptionDetailID) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(PrescriptionDetail.class);
                Root root = query.from(PrescriptionDetail.class);

                query.where(builder.equal(root.get("id").as(Integer.class), prescriptionDetailID));

                Query q = session.createQuery(query);

                return (PrescriptionDetail) q.getSingleResult();
        }

        @Override
        public PrescriptionDetail alterPrescriptionDetail(int prescriptionDetailID, String quantity) {
                Session session = this.sessionFactory.getObject().getCurrentSession();

                PrescriptionDetail prescriptionDetail = this.getPrescriptionDetailById(prescriptionDetailID);

                Query q = session.createQuery("UPDATE PrescriptionDetail Pd SET Pd.medicineQuantity =: quantity WHERE Pd.id =: id");
                q.setParameter("id", prescriptionDetailID);

                if (quantity == null) {
                        q.setParameter("quantity", prescriptionDetail.getMedicineQuantity() + 1);
                } else {
                        q.setParameter("quantity", Integer.parseInt(quantity));
                }

                q.executeUpdate();

                return prescriptionDetail;
        }

        @Override
        public List<PrescriptionDetail> getPrescriptionDetails(int prescriptionID) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(PrescriptionDetail.class);
                Root root = query.from(PrescriptionDetail.class);

                if (prescriptionID != 0) {
                        query.where(builder.equal(root.get("prescriptionId"), prescriptionID));

                        Query q = session.createQuery(query);

                        return q.getResultList();
                }
                query.select(root);
                Query q = session.createQuery(query);

                return q.getResultList();
        }

        @Override
        public boolean addPrescriptionDetail(PrescriptionDetail pd) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                try {
                        session.save(pd);
                        return true;
                } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                }
        }

        @Override
        public boolean deletePrescriptionDetail(int id) {
                Session session = this.sessionFactory.getObject().getCurrentSession();

                try {
                        PrescriptionDetail p = session.get(PrescriptionDetail.class, id);
                        session.delete(p);
                        return true;
                } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                }
        }

        @Override
        public void updatePrescriptionDetail(PrescriptionDetail pd, int prescriptionDetailId) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                try {
//            Medicine m = session.byId(Medicine.class).load(medicineId);
//            m.setMedicineName(medicine.getMedicineName());
//            m.setHowToUse(medicine.getHowToUse());
//            m.setMedicinePrice(medicine.getMedicinePrice());
//            m.setMedicineQuantity(medicine.getMedicineQuantity());
//            m.setUnitId(medicine.getUnitId());
//            m.setActive(medicine.getActive());
                        PrescriptionDetail p = session.get(PrescriptionDetail.class, prescriptionDetailId);
                        if (pd.getMedicineId() != null) {
                                p.setMedicineId(pd.getMedicineId());
                        }
                        if (pd.getPrescriptionId() != null) {
                                p.setPrescriptionId(pd.getPrescriptionId());
                        }
                        if (pd.getMedicineQuantity() != null) {
                                p.setMedicineQuantity(pd.getMedicineQuantity());
                        }

                        session.flush();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        @Override
        public List<Object[]> countMedicineByMonth(int month) {
                Session session = this.sessionFactory.getObject().getCurrentSession();

                Query query = session.createQuery("SELECT COUNT(D.medicineId) FROM PrescriptionDetail D JOIN Prescription P On D.prescriptionId = P.id WHERE month(P.createdDate)=: month");
                query.setParameter("month", month);

                return query.getResultList();
        }

        @Override
        public List<Object[]> countMedicineByQuarter(int quarter) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                
                Query query = session.createQuery("SELECT COUNT(D.medicineId) FROM PrescriptionDetail D JOIN Prescription P On D.prescriptionId = P.id WHERE quarter(P.createdDate)=: quarter");
                query.setParameter("quarter", quarter);

                return query.getResultList();
        }

        @Override
        public List<Object[]> countMedicineByYear(int year) {
                Session session = this.sessionFactory.getObject().getCurrentSession();

                Query query = session.createQuery("SELECT COUNT(D.medicineId) FROM PrescriptionDetail D JOIN Prescription P On D.prescriptionId = P.id WHERE year(P.createdDate)=: year");
                query.setParameter("year", year);

                return query.getResultList();
        }

}
