/*
 * OrderServlet.java
 * 
 * Created on Nov 4, 2007, 8:14:57 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author evansrb1
 */
public class OrderServlet extends HttpServlet {
    private OrderManager orderManager = null;
    
    @Override
    public void init() {
       orderManager = new OrderManager();
    }
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>OrderServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>OrderServlet</h1>");
            String item = request.getParameter("hike");
            if (item != null) {
                orderManager.putInCart(item, session);
            }
            out.println("<p>Your order Number is " + orderManager.getOrder(session).getOrderNumber() + "</p>");
            int numItems = orderManager.cartSize(session);
            out.println("<p>You have ordered " + numItems + " items</p>");            
            for (int i = 0; i < numItems; i++) {
               out.println("Item " + (i +1) + ": " + orderManager.getItem(i, session) + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
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
