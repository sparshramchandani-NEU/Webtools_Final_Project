/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.hbernateapp.pojo.Packages;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author sparshramchandani
 */
public class PackageDAO extends DAO {
    
     public void savePackage(Packages packages){
        try {
        begin(); //inherited from super class DAO
        getSession().save(packages);
        commit();
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
     
     public void updatePackageStatus(int packageID){
         try{
             begin();
             Packages packages = getSession().get(Packages.class, packageID);
             if(packages.getStatus().equals("Not Delivered")){
                 packages.setStatus("Delivered");
             }else{
                 packages.setStatus("Not Delivered");
             }
             
             commit();
         }catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
     }
     
     public Packages findPackageByID(int packageID){
         Packages packages = null;
         try{
             begin();
              packages = getSession().get(Packages.class, packageID);
             commit();
             
         }catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
         return packages;
     }
     
     public Packages findPackageByName(String nameOfThePerson){
         Packages packages = null;
         try{
             begin();
              packages = getSession().get(Packages.class, nameOfThePerson);
             commit();
             
         }catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
         return packages;
     }
     
     public List<Packages> gatPackagesByEmployeeName(String employeeName){
         String hql = "select p from Package p join p.employee e where e.name like :employeeName";
            List<Packages> packages = getSession().createQuery(hql, Packages.class)
                .setParameter("employeeName", "%" + employeeName + "%")
                .getResultList();
            return packages;
     }
     
     
}
