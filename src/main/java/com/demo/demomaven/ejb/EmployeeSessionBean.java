/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demomaven.ejb;

import com.demo.demomaven.dao.impl.DaoDeparmentImpl;
import com.demo.demomaven.dao.impl.DaoEmployeeImpl;
import com.demo.demomaven.model.Deparment;
import com.demo.demomaven.model.Employee;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author docente
 */
@Stateless(name = "employeeEjb")
public class EmployeeSessionBean implements Serializable{
@PersistenceContext(unitName = "com.demo_demomaven_war_1.0-SNAPSHOTPU")
private EntityManager entityManager;
private DaoEmployeeImpl<Employee> ddi;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public DaoEmployeeImpl<Employee> getEdi() {
        return ddi;
    }

    public void setEdi(DaoEmployeeImpl<Employee> edi) {
        this.ddi = edi;
    }

@PostConstruct
public void init(){
    ddi=new DaoEmployeeImpl<>(entityManager);
}

public void save(Employee e){
  this.getEdi().save(e);
}
public void update(Employee e){
  this.getEdi().update(e);
}
}
