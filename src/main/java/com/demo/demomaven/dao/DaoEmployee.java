/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demomaven.dao;

import java.util.List;

/**
 *
 * @author docente
 * @param <Employee>
 
 */
public interface DaoEmployee<Employee> {
   void save(Employee e);
   void update(Employee e);
   List<Employee> list();
}
