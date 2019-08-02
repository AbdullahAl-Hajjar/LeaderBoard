/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Gyp
 */
//@WebServlet(urlPatterns = {"About"})
public class About extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet About</title>");     
            out.println("<style> h2{border-bottom: 1px solid #e5e4e4;\n" +
"	float:left;\n" +
"	width:100%;\n" +
"	padding:25px 0;\n" +
"	color:#606060;\n" +
"	text-align:center;\n" +
"         margin-top:0;\n" +
"         font-weight:100;}"
                    + "p{float:left;\n" +
"	width:100%;\n" +
"	padding:25px 0;\n" +
"	color:#606060;\n" +
"	text-align:center;\n" +
"         margin-top:0;\n" +
"         font-weight:100;}</style>");
            out.println("</head>");
            out.println("<body>");
            out.println(" <h2><font face = \"Century Gothic\" size=\"4\">About</font></h2> ");
             out.println(" <p><font face = \"Calibri\" >This Web Page was developed by Abdullah Al-Hajjar Student no: 040656012 <br /> "
                     + "with some bonus requirments included such as <br />"
                     + "Delete<br />"
                     + "Update<br />"
                     + "Email Varification<br />"
                     + "Web Page beautify <br />"
                     + "</font></p> ");
            out.println("</body>");
            out.println("</html>");
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
           //getServletContext().getRequestDispatcher("/index.html").forward(request,response);
        //processRequest(request, response);
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
