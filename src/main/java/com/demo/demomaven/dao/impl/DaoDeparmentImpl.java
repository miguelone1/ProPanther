/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demomaven.dao.impl;

import com.demo.demomaven.dao.DaoDeparment;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class DaoDeparmentImpl<Deparment> implements DaoDeparment<Deparment> {
private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public DaoDeparmentImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Deparment t) {
      this.getEntityManager().persist(t);
    }

    @Override
    public void update(Deparment t) {
         this.getEntityManager().merge(t);
    }

    @Override
@SuppressWarnings("empty-statement")
    public List<Deparment> list() {
    Query query = this.getEntityManager().createQuery("Select "
            + "o From Deparment "
            + "o ORDER BY o.name");
        return query.getResultList();
    }
    
}
