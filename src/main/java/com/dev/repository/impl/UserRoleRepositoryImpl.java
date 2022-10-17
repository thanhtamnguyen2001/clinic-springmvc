/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.User;
import com.dev.pojo.UserRole;
import com.dev.repository.UserRoleRepository;
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
public class UserRoleRepositoryImpl implements UserRoleRepository {

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Override
    public UserRole getUserRole(int userRoleID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(UserRole.class);
        Root root = query.from(UserRole.class);

        query.where(builder.equal(root.get("id").as(Integer.class), userRoleID));

        Query q = session.createQuery(query);

        return (UserRole) q.getSingleResult();
    }

    @Override
    public List<UserRole> getUserRoleNotRole(String roleName) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(UserRole.class);
        Root root = query.from(UserRole.class);
        
        
        query.where(builder.notLike(root.get("name").as(String.class), roleName));

        Query q = session.createQuery(query);

        return q.getResultList();
    }

}
