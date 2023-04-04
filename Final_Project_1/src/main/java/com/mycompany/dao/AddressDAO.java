/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.hbernateapp.pojo.Address;

public class AddressDAO extends DAO {
    public void save(Address a) {
        begin();
        getSession().save(a);
        commit();
    }
    
    public void update(Address a) {
        try {
            begin();
            getSession().update(a);
            commit();
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public void delete(Address a) {
        begin();
        getSession().delete(a);
        commit();
    }
    
    public Address address(int aid) {
        Address address = getSession().get(Address.class, aid);
        return address;
    }
}