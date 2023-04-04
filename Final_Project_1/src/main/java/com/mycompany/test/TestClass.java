/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

import com.mycompany.dao.UserDAO;
import com.mycompany.hbernateapp.pojo.User;

/**
 *
 * @author YSF
 */
public class TestClass {
    public static void main(String[] args) {
        String uri = "/user/search/12345.htm";
        int pos1 = uri.lastIndexOf("/");
        int pos2 = uri.lastIndexOf(".");
        System.out.println("ID: " + uri.substring(pos1+1, pos2));
    }
}
