/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eskerri1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eskerri1.Rates.*;

/**
 *
 * @author lizsk
 */
@WebServlet(name = "formServlet", urlPatterns = {"/formServlet"})
public class formServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Trip Planning</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Here are your trip details</h1>");
            //out.println("</body>");
            //out.println("</html>");
            
            String trail = null;
            trail = request.getParameter("trail");
            if (trail == null) {
                trail = "<none entered>";
            }
            out.println(trail + " Trail ");
            HIKE hike = HIKE.GARDINER;
            if (trail.equals("Gardiner"))
            {
                hike = HIKE.GARDINER;
            }
            if (trail.equals("Hellroaring"))
            {
                hike = HIKE.HELLROARING;
            }
            if (trail.equals("Beaten"))
            {
                hike = HIKE.BEATEN;
            }            
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String year = request.getParameter("year");
            String duration = request.getParameter("duration");
            int dur = Integer.parseInt(duration);
            int d = Integer.parseInt(day);
            int m = Integer.parseInt(month);
            int y = Integer.parseInt(year);
            
            out.println( "<br /> Starting date is " + month + "/" + day 
                    + "/" + year + " for " + duration + " day(s)");
            BookingDay startDay = new BookingDay(y, m, d);
            boolean isValidDay = startDay.isValidDate();
            
            Rates rate;
            if (isValidDay)
            {
                rate = new Rates(hike);
                rate.setBeginDate(startDay);
                rate.setDuration(dur);
                //isValidDay = rate.isValidDates(); already checks isValid in getCost()
                double result = rate.getCost();
                out.println("<br /> Details: " + rate.getDetails());
                
                if (isValidDay && result > 0)
                {
                    out.println("<br /> Resulting cost is " + result);
                }
                else 
                {
                    out.println("<br /> Something went wrong!");
                }
            }
            else
            {
                out.println("<br /> Something went wrong!");
            }
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
