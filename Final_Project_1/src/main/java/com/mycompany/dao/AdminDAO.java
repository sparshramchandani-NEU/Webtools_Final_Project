/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.hbernateapp.pojo.Admin;

/**
 *
 * @author sparshramchandani
 */
public class AdminDAO extends DAO {
    
    public Admin getAdmin(int adminID){      
        Admin admin = getSession().get(Admin.class,adminID);
        return admin;
    }
    
    public void updateAdmin(Admin admin){
        try{
            begin();
            getSession().update(admin);
            commit();
        }catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
