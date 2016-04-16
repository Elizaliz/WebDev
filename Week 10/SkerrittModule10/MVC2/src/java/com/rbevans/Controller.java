/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;

/**
 *
 * @author evansrb1
 */
public class Controller extends HttpServlet {
    public static final String LOGIN="login";
    public static final String PASSWORD = "password";
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ServletContext servletContext = getServletContext();
        Login login = (Login) session.getAttribute(LOGIN);
        if (login == null) {
            login = new Login();
            session.setAttribute(LOGIN, login);
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            String name = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);
            login.setName(name);
            login.setPassword(password);
            if (login.getSuccess()) {
                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/welcome.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            }
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
