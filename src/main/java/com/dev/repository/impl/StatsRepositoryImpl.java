/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.MedicalRegister;
import com.dev.repository.StatsRepository;
import java.util.ArrayList;
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
public class StatsRepositoryImpl implements StatsRepository {

        @Autowired
        LocalSessionFactoryBean sessionFactory;

        @Override
        public List<MedicalRegister> registerStats(Date fromDate, Date toDate) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(MedicalRegister.class);
                Root root = query.from(MedicalRegister.class);

                List<Predicate> predicates = new ArrayList<>();

                if (fromDate != null) {
                        predicates.add(builder.greaterThanOrEqualTo(root.get("dateOfExamination"), fromDate));

                }
                if (toDate != null) {
                        predicates.add(builder.lessThanOrEqualTo(root.get("dateOfExamination"), toDate));
                }

                query.where(predicates.toArray(new Predicate[]{}));

                Query q = session.createQuery(query);

                return q.getResultList();
        }

}
