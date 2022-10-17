/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.Medicine;
import com.dev.repository.MedicineRepository;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import static jdk.javadoc.internal.doclets.toolkit.util.DocFile.list;
import static org.eclipse.persistence.jpa.jpql.utility.CollectionTools.list;
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
public class MedicineRepositoryImpl implements MedicineRepository {

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Medicine> getMedicines(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Medicine.class);
        Root root = query.from(Medicine.class);

        if (name != null) {
            String nameString = String.format("%%%s%%", name);
            Predicate p = builder.like(root.get("medicineName").as(String.class), nameString);
            query.where(p);

            Query q = session.createQuery(query);

            return q.getResultList();
        }
        Query q = session.createQuery(query);

        return q.getResultList();

    }

    @Override
    public Medicine getMedicineById(int medicineID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Medicine.class);
        Root root = query.from(Medicine.class);

        query.where(builder.equal(root.get("id"), medicineID));

        Query q = session.createQuery(query);

        return (Medicine) q.getSingleResult();
    }

    @Override
    public boolean deleteMedicine(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Medicine m = session.get(Medicine.class, id);
            session.delete(m);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addMedicine(Medicine medicine) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(medicine);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateMedicine(Medicine medicine, int medicineId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
//            Medicine m = session.byId(Medicine.class).load(medicineId);
//            m.setMedicineName(medicine.getMedicineName());
//            m.setHowToUse(medicine.getHowToUse());
//            m.setMedicinePrice(medicine.getMedicinePrice());
//            m.setMedicineQuantity(medicine.getMedicineQuantity());
//            m.setUnitId(medicine.getUnitId());
//            m.setActive(medicine.getActive());
            Medicine m = session.get(Medicine.class, medicineId);
            if (medicine.getMedicineName() != null) {
                m.setMedicineName(medicine.getMedicineName());
            }
            if (medicine.getHowToUse() != null) {
                m.setHowToUse(medicine.getHowToUse());
            }
            if (medicine.getMedicinePrice() != null) {
                m.setMedicinePrice(medicine.getMedicinePrice());
            }
            if (medicine.getMedicineQuantity() != null) {
                m.setMedicineQuantity(medicine.getMedicineQuantity());
            }
            if (medicine.getUnitId() != null) {
                m.setUnitId(medicine.getUnitId());
            }
            if (medicine.getActive() != null) {
                m.setActive(medicine.getActive());
            }

            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePatchMedicine(Medicine medicine, int medicineId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Medicine m = session.get(Medicine.class, medicineId);
        if (medicine.getMedicineName() != null) {
            m.setMedicineName(medicine.getMedicineName());
        }
        if (medicine.getHowToUse() != null) {
            m.setHowToUse(medicine.getHowToUse());
        }
        if (medicine.getMedicinePrice() != null) {
            m.setMedicinePrice(medicine.getMedicinePrice());
        }
        if (medicine.getMedicineQuantity() != null) {
            m.setMedicineQuantity(medicine.getMedicineQuantity());
        }
        if (medicine.getUnitId() != null) {
            m.setUnitId(medicine.getUnitId());
        }
        if (medicine.getActive() != null) {
            m.setActive(medicine.getActive());
        }

        session.update(m);
    }

}
