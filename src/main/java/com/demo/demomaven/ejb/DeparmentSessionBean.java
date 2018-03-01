/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demomaven.ejb;

import com.demo.demomaven.dao.impl.DaoDeparmentImpl;
import com.demo.demomaven.model.Deparment;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author docente
 */
@Stateless(name = "deparmentEjb")
public class DeparmentSessionBean implements Serializable{
@PersistenceContext(unitName = "com.demo_demomaven_war_1.0-SNAPSHOTPU")
private EntityManager entityManager;
private DaoDeparmentImpl<Deparment> ddi;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public DaoDeparmentImpl<Deparment> getDdi() {
        return ddi;
    }

    public void setDdi(DaoDeparmentImpl<Deparment> ddi) {
        this.ddi = ddi;
    }

@PostConstruct
public void init(){
    ddi=new DaoDeparmentImpl<>(entityManager);
}

public void save(Deparment d){
  this.getDdi().save(d);
}
public void update(Deparment d){
  this.getDdi().update(d);
}
}
