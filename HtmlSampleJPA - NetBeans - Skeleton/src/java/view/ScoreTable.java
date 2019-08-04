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


public class ScoreTable extends HttpServlet {

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
            out.println("<title>ScoreTable</title>");
            https://www.w3schools.com/css/css_table.asp
            out.println("<style>");
            out.println("table {border-collapse: collapse;width: auto;}");
            out.println("th, td {text-align: left;padding: 8px;}");
            out.println("tr:nth-child(even) {background-color: #f2f2f2;}");
            out.println("td.edit{width:65px;}");
            out.println("td.name{width:350px;}");
            out.println("td.code{width:150px;}");
            out.println("td.delete{text-align: center;}");
            out.println("input.editor{width: 100%;}");
            out.println("input.update{width: 100%;}");
            out.println("</style>");
            out.println("<script>");
            out.println("var isEditActive = false;");
            out.println("var activeEditID = -1;");
            out.println("function createTextInput(text, name) {");
            out.println("var node = document.createElement(\"input\");");
            out.println("node.name = name;");
            out.println("node.className = \"editor\";");
            out.println("node.type = \"text\";");
            out.println("node.value = text;");
            out.println("return node;");
            out.println("}");
            out.println("window.onload = function () {");
            out.println("var elements = document.getElementsByClassName(\"edit\");");
            out.println("for (let i = 0; i < elements.length; i++) {");
            out.println("elements[i].childNodes[0].onclick = function () {");
            out.println("var id = elements[i].id;");
            out.println("if (isEditActive) {");
            out.println("if (activeEditID === id) {");
            out.println("this.type = \"submit\";");
            out.println("}");
            out.println("return;");
            out.println("}");
            out.println("isEditActive = true;");
            out.println("activeEditID = id;");
            out.println("this.value = \"Update\";"); 
            out.println("var ID = document.getElementById(++id);"); 
            out.println("var idCell = document.getElementById(++id);");
            out.println("var nameCell = document.getElementById(++id);");
           
            out.printf("var dataIdinput = createTextInput(ID.innerText, \"%s\");", ScoreLogic.ID);
             out.println("dataIdinput .readOnly = true;");
            out.printf("var idInput = createTextInput(idCell.innerText, \"%s\");", ScoreLogic.PLAYER_ID);
            out.println("idInput.readOnly = true;");
           
            out.printf("var nameInput = createTextInput(nameCell.innerText, \"%s\");", ScoreLogic.SCORE);
           
            out.println("ID.innerText = null;"); 
            out.println("idCell.innerText = null;");
          out.println("nameCell.innerText = null;");
          
             out.println("ID.appendChild(dataIdinput);");  
             out.println("idCell.appendChild(idInput);");
            out.println("nameCell.appendChild(nameInput);");
            out.println("};");
            out.println("}");
            out.println("};");
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            //https://www.w3schools.com/css/css_table.asp
            out.println("<form method=\"post\">");

            out.println("<table align=\"center\">");
            out.println("<tr>");
            out.println("<td><input type=\"text\" name=\"searchText\" /></td>");
            out.println("<td><input type=\"submit\" name=\"search\" value=\"Search\" /></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<table align=\"center\" border=\"1\">");
            out.println("<tr>");
            out.println("<th><input type=\"submit\" name=\"delete\" value=\"Delete\" /></th>");
            out.println("<th>Edit</th>");
            out.println("<th>ID</th>");
            out.println("<th>Player ID</th>");
            out.println("<th>Score</th>");
            out.println("<th>Date of Submission</th>");
            out.println("</tr>");
            ScoreLogic scoreLogic = new ScoreLogic();
            List<Score> test = scoreLogic.getAll();
            long counter = 0;
                for(Score sc : test){
                out.println("<tr>");
                out.println("<td class=\"delete\">");
                out.printf("<input type=\"checkbox\" name=\"deleteMark\" value=\"%d\" />",sc.getPlayerid().getId());
                out.println("</td>");
                out.printf("<td class=\"edit\" id=\"%d\" ><input class=\"update\" type=\"button\" name=\"edit\" value=\"Edit\" /></td>", counter++);
                out.printf("<td class=\"code\" id=\"%d\" >%d</td>", counter++, sc.getId());
                out.printf("<td class=\"code\" id=\"%d\" >%d</td>", counter++, sc.getPlayerid().getId());
                out.printf("<td class=\"name\" id=\"%d\" >%s</td>", counter++, sc.getScore());
                out.printf("<td class=\"name\" id=\"%d\" >%s</td>", counter++, sc.getSubmission());
                out.println("</tr>");
            }
            out.println("<tr>");
            out.println("<th><input type=\"submit\" name=\"delete\" value=\"Delete\" /></th>");
            out.println("<th>Edit</th>");
               out.println("<th>ID</th>");
            out.println("<th>Player ID</th>");
            out.println("<th>Score</th>");
            out.println("<th>Date of Submission</th>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
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
        
        ScoreLogic logic = new ScoreLogic();
        String[] values = request.getParameterValues("deleteMark");
        if(values!=null && values.length>=1)
            logic.deleteCourses( values);
        else
        {
            try{
         PlayerLogic playerlogic = new PlayerLogic(); 
         Player player = playerlogic.getPlayerWithId(Integer.valueOf(request.getParameter(PlayerLogic.ID)));
         Score   score= logic.createEntity(request.getParameterMap());
         score.setPlayerid(player);
         logic.update(score);
            }catch(NullPointerException| IllegalArgumentException ni)
          {
                PrintWriter out = response.getWriter();
                out.println("<script>alert(\"Must Enter Digits & Cannot Exeed 9 Charecters\");</script>");
            }
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
