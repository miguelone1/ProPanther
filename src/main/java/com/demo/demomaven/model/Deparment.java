/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demomaven.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author docente
 */
@Entity
@Table(name = "deparment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deparment.findAll", query = "SELECT d FROM Deparment d")})
public class Deparment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddeparment")
    private Integer iddeparment;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "location")
    private String location;
    @OneToMany(mappedBy = "iddept")
    private Collection<Employee> employeeCollection;

    public Deparment() {
    }

    public Deparment(Integer iddeparment) {
        this.iddeparment = iddeparment;
    }

    public Integer getIddeparment() {
        return iddeparment;
    }

    public void setIddeparment(Integer iddeparment) {
        this.iddeparment = iddeparment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddeparment != null ? iddeparment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deparment)) {
            return false;
        }
        Deparment other = (Deparment) object;
        if ((this.iddeparment == null && other.iddeparment != null) || (this.iddeparment != null && !this.iddeparment.equals(other.iddeparment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.demomaven.model.Deparment[ iddeparment=" + iddeparment + " ]";
    }
    
}
