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
 * @param <Deparment>
 
 */
public interface DaoDeparment<Deparment> {
   void save(Deparment t);
   void update(Deparment t);
   List<Deparment> list();
}
