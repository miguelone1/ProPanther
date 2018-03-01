/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demomaven.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author docente
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idemployee")
    private Integer idemployee;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "last_name")
    private String lastName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private Double salary;
    @JoinColumn(name = "idemp", referencedColumnName = "idemp")
    @ManyToOne
    private Employee idemp;

    public Employee() {
    }

    public Employee(Integer idemployee) {
        this.idemployee = idemployee;
    }

    public Integer getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(Integer idemployee) {
        this.idemployee = idemployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee getIdemp() {
        return idemp;
    }

    public void setIdemp(Employee idemp) {
        this.idemp = idemp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemployee != null ? idemployee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.idemployee == null && other.idemployee != null) || (this.idemployee != null && !this.idemployee.equals(other.idemployee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.demomaven.model.Employee[ idemployee=" + idemployee + " ]";
    }
    
}
