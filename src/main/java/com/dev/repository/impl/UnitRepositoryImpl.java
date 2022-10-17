    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.Unit;
import com.dev.repository.UnitRepository;
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
public class UnitRepositoryImpl implements UnitRepository {

        @Autowired
        private LocalSessionFactoryBean sessionFactory;

        @Override
        public Unit getUnitById(int unitID) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(Unit.class);
                Root root = query.from(Unit.class);

                query.where(builder.equal(root.get("id"), unitID));

                Query q = session.createQuery(query);

                return (Unit) q.getSingleResult();

        }

        @Override
        public List<Unit> getUnits() {
                Session session = this.sessionFactory.getObject().getCurrentSession();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery query = builder.createQuery(Unit.class);
                Root root = query.from(Unit.class);

                query.select(root);

                Query q = session.createQuery(query);

                return q.getResultList();
        }

    @Override
    public boolean deleteUnit(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Unit m = session.get(Unit.class, id);
            session.delete(m);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateUnit(Unit unit, int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Unit u = session.get(Unit.class, id);
            if (unit.getUnitName() != null) {
                u.setUnitName(unit.getUnitName());
            }

            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUnit(Unit u) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
