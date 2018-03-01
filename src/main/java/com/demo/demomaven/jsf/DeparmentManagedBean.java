/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demomaven.jsf;

import com.demo.demomaven.ejb.DeparmentSessionBean;
import com.demo.demomaven.model.Deparment;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author docente
 */
@Named(value = "deparmentManagedBean")
@ViewScoped
public class DeparmentManagedBean implements Serializable{
    @EJB(name = "deparmentEjb")
    private DeparmentSessionBean sessionBean;
    private Deparment deparment=new Deparment();

    public DeparmentSessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(DeparmentSessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Deparment getDeparment() {
        return deparment;
    }

    public void setDeparment(Deparment deparment) {
        this.deparment = deparment;
    }
    
    public DeparmentManagedBean() {
    }
    public void save(){
        FacesContext context = FacesContext.getCurrentInstance();
      this.getSessionBean().save(deparment);
      context.addMessage(null, new FacesMessage("Registro OK"));
    }
}
