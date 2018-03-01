/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demomaven.dao.impl;

import com.demo.demomaven.dao.DaoEmployee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class DaoEmployeeImpl<Employee> implements DaoEmployee<Employee> {
private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public DaoEmployeeImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Employee e) {
      this.getEntityManager().persist(e);
    }

    @Override
    public void update(Employee e) {
         this.getEntityManager().merge(e);
    }

    @Override
@SuppressWarnings("empty-statement")
    public List<Employee> list() {
    Query query = this.getEntityManager().createQuery("Select "
            + "o From Employee "
            + "o ORDER BY o.name");
        return query.getResultList();
    }
    
}
