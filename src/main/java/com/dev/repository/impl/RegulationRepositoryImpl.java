/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.Regulations;
import com.dev.repository.RegulationRepository;
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
public class RegulationRepositoryImpl implements RegulationRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Regulations getRegulation(int regurationID) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Regulations> query = builder.createQuery(Regulations.class);
        Root root = query.from(Regulations.class);

        query.where(builder.equal(root.get("id"), regurationID));

        Query q = session.createQuery(query);

        return (Regulations) q.getSingleResult();
    }

    @Override
    public List<Regulations> getRegulations(boolean isActive) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Regulations> query = builder.createQuery(Regulations.class);
        Root root = query.from(Regulations.class);
        if(isActive) {
            query.where(builder.equal(root.get("active"), isActive));
            Query q = session.createQuery(query);

        return q.getResultList();
        }

        query.select(root);
        Query q = session.createQuery(query);

        return q.getResultList();
    }
    
    @Override
    public boolean deleteRegulation(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Regulations p = session.get(Regulations.class, id);
            session.delete(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addRegulation(Regulations regulation) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(regulation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updatePatchRegulation(Regulations regulation, int regulationId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Regulations p = session.get(Regulations.class, regulationId);
        if (regulation.getPatientQuantity() != null) {
            p.setPatientQuantity(regulation.getPatientQuantity());
        }
        if (regulation.getExaminationPrice() != null) {
            p.setExaminationPrice(regulation.getExaminationPrice());
        }
        if (regulation.getActive() != null) {
            p.setActive(regulation.getActive());
        }

        session.update(p);
    }
}
