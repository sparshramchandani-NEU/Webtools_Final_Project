/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.hbernateapp.pojo.Employee;




/**
 *
 * @author sparshramchandani
 */
public class EmployeeDAO extends DAO{
    public void saveEmployee(Employee employee){
        try {
        begin(); //inherited from super class DAO
        getSession().save(employee);
        commit();
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteEmployee(Employee employee) {
        begin();
        getSession().delete(employee);
        commit();
    }
    
    public void deleteEmployeeById(int employeeID) {
        begin();
        getSession().delete(getSession().get(Employee.class, employeeID));
        commit();
    }
    
    public Employee getUser(int employeeID) {
        Employee employee = getSession().get(Employee.class, employeeID);
        return employee;
    }
}
