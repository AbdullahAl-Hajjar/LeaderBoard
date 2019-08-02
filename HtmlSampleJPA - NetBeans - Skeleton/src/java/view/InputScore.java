/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Player;
import entity.Score;
import entity.Username;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PlayerLogic;
import logic.ScoreLogic;
import logic.UsernameLogic;

/**
 *
 * @author Gyp
 */
public class InputScore extends HttpServlet {

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
            out.println("<title>InputScore</title>");        
                        out.println("<style>");
            out.println("body {color: black;}");
            out.println("</style>");         
            out.println("</head>");
            out.println("<body>");
             out.println("<div style=\"text-align: center;\">");
            out.println("<div style=\"display: inline-block; text-align: left;\">");
            out.println("<form action=\"InputScore\" method=\"post\">");
            out.println("Player ID:<br>");
            out.println("<input type=\"text\" name=\"id\" ><br>");
            out.println("Score:<br>");
            out.println("<input type=\"text\" name=\"score\" ><br>");

            out.println("<input type=\"submit\" value=\"Submit\">");
            out.println("</form>");
                        out.println("<pre>");

            out.println("</pre>");
            out.println("</div>");
            out.println("</div>");
            out.println("</html>");
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
        
        try{
        
           ScoreLogic scoreLogic = new ScoreLogic();
         Score score = scoreLogic.createEntity(request.getParameterMap());
         
         PlayerLogic playerLogic = new PlayerLogic();
         Player player = playerLogic.getPlayerWithId(Integer.valueOf(request.getParameter(PlayerLogic.ID)));
         
         score.setPlayerid(player);
         player.getScoreList().add(score);
         playerLogic.update(player);
         
         response.sendRedirect("ScoreTable");
        }catch(NullPointerException| IllegalArgumentException ni)
          {
                PrintWriter out = response.getWriter();
                out.println("<script>alert(\"Must Enter Digits & Cannot Exeed 9 Charecters\");</script>");
            }
        
         
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
