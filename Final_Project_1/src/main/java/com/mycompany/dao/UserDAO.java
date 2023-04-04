package com.mycompany.dao;

import com.mycompany.hbernateapp.pojo.User;

public class UserDAO extends DAO {
    public void saveUser(User user) {
        try {
        begin(); //inherited from super class DAO
        getSession().save(user);
        commit();
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteUser(User user) {
        begin();
        getSession().delete(user);
        commit();
    }
    
    public void deleteUserById(int userid) {
        begin();
        getSession().delete(getSession().get(User.class, userid));
        commit();
    }
    
    public User getUser(int userid) {
        User user = getSession().get(User.class, userid);
        return user;
    }
}