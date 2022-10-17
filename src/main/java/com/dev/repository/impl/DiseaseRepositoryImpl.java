/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.Disease;
import com.dev.repository.DiseaseRepository;
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
 * @author Lenovo
 */
@Repository
@Transactional
public class DiseaseRepositoryImpl implements DiseaseRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Disease getDisease(int diseaseID) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Disease> query = builder.createQuery(Disease.class);
        Root root = query.from(Disease.class);

        query.where(builder.equal(root.get("id"), diseaseID));

        Query q = session.createQuery(query);

        return (Disease) q.getSingleResult();
    }

    @Override
    public List<Disease> getDiseases() {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Disease> query = builder.createQuery(Disease.class);
        Root root = query.from(Disease.class);

        query.select(root);
        Query q = session.createQuery(query);

        return q.getResultList();
        
    }

    @Override
    public boolean deleteDisease(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Disease p = session.get(Disease.class, id);
            session.delete(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addDisease(Disease disease) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(disease);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

    @Override
    public void updateDisease(Disease disease, int diseaseId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Disease p = session.get(Disease.class, diseaseId);
        if (disease.getDiseaseName() != null) {
            p.setDiseaseName(disease.getDiseaseName());
        }

        session.update(p);
    }
    
}
