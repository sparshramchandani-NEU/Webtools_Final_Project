/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.mycompany.hbernateapp;

import com.mycompany.dao.AdminDAO;
import com.mycompany.dao.UserDAO;
import com.mycompany.hbernateapp.pojo.Address;
import com.mycompany.hbernateapp.pojo.Admin;
import com.mycompany.hbernateapp.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author YSF
 */
@Controller
public class UserController {

    @GetMapping("/user/delete/*.htm")
    public String handleDeleteGET(UserDAO userdao, HttpServletRequest request) {
        String uri = request.getRequestURI();
        int pos1 = uri.lastIndexOf("/");
        int pos2 = uri.lastIndexOf(".");
        int userid = Integer.parseInt(uri.substring(pos1 + 1, pos2));

        return "delete-confirm.jsp";
    }

    @GetMapping("/user/search/*.htm")
    public String handleSearchGET(UserDAO userdao, HttpServletRequest request) {
        String uri = request.getRequestURI();
        int pos1 = uri.lastIndexOf("/");
        int pos2 = uri.lastIndexOf(".");
        int userid = Integer.parseInt(uri.substring(pos1 + 1, pos2));

        User user = userdao.getUser(userid);

        return "result";
    }

    @GetMapping("/user/save.htm")
    protected ModelAndView handleSaveGET(UserDAO userdao, HttpServletRequest request) throws Exception {
        User user = new User();
        user.setFirst("Yusuf");
        user.setLast("Ozbek");
        user.setEmail("y.ozbek@northeastern.edu");
        Address addr = new Address();
        addr.setCity("Boston");
        addr.setState("MA");
        addr.setStreetName("Huntington Ave");
        addr.setStreetNum(360);
        addr.setZip("02115");
        user.setAddress(addr);

        userdao.saveUser(user);

        request.getSession().setAttribute("user", user);
        return new ModelAndView("user-view");
    }

    @GetMapping("home.htm")
    protected String handleHome(HttpServletRequest request) throws Exception {
        return "home";
    }
    
    @GetMapping("login.htm")
    protected String handleLoginPage(HttpServletRequest request) throws Exception{
        return "login";
    }
    
    
    @PostMapping("process_tracking_id.htm")
    protected String handleSearchResult(){
        return "packageStatus";
    }
    
    @PostMapping("process_login.htm")
    protected String handleLogin(HttpServletRequest req, AdminDAO admindao) throws Exception{
        String role = req.getParameter("role");
        String email= req.getParameter("username");
        String password = req.getParameter("password");
        String view = null;
        if(role.equals("admin")){
            Admin admin = admindao.getAdmin(1);
            if(admin.getEmail().equals(email) && admin.getPassword().equals(password)){
                view = "loginHomeAdmin"; 
            }else{
                view = "error";
            } 
        }
        if(role.equals("employee")){
            view = "loginHomeEmployee";
        }
        return view;
    }
    
    @GetMapping("changeAdminCredentials.htm")
    protected String ChangeAdminCredentials(){
        return "changeCredentials";
    }
    
    @PostMapping("process_changeAdminCredentials.htm")
    protected String ChangeAdminCredentialsSuccess(AdminDAO admindao, HttpServletRequest req, HttpServletResponse res){
        String email= req.getParameter("username");
        String password = req.getParameter("password");
        
        Admin admin = admindao.getAdmin(1);
        admin.setEmail(email);
        admin.setPassword(password);
        admindao.updateAdmin(admin);
        
        req.setAttribute("role", "admin");
        
        return "login";
        
    }
}
