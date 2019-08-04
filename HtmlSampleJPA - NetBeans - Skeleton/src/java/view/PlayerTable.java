/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Player;
import entity.Username;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PlayerLogic;
import logic.UsernameLogic;
import org.eclipse.jdt.core.compiler.InvalidInputException;


public class PlayerTable extends HttpServlet {

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
            out.println("<title>PlayerTable</title>");
            //https://www.w3schools.com/css/css_table.asp
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
            out.println("var idCell = document.getElementById(++id);");
            out.println("var nameCell = document.getElementById(++id);");
            out.println("var lastnameCell = document.getElementById(++id);");
            out.println("var emailCell = document.getElementById(++id);");
            out.println("var dateCell= document.getElementById(++id);");
            out.printf("var idInput = createTextInput(idCell.innerText, \"%s\");", PlayerLogic.ID);
            out.println("idInput.readOnly = true;");
            out.printf("var nameInput = createTextInput(nameCell.innerText, \"%s\");", PlayerLogic.FIRST_NAME);
            out.printf("var lastnameInput = createTextInput(lastnameCell.innerText, \"%s\");", PlayerLogic.LAST_NAME);
            out.printf("var emailInput = createTextInput(emailCell.innerText, \"%s\");", PlayerLogic.EMAIL);
             out.printf("var dateInput = createTextInput(dateCell.innerText, \"%s\");", PlayerLogic.JOINED);
             out.println("dateInput.readOnly = true;");
            out.println("idCell.innerText = null;");
            out.println("nameCell.innerText = null;");
            out.println("lastnameCell.innerText = null;");
            out.println("emailCell.innerText = null;");
              out.println("dateCell.innerText = null;");
            out.println("idCell.appendChild(idInput);");
            out.println("nameCell.appendChild(nameInput);");
           out.println("lastnameCell.appendChild(lastnameInput);");
            out.println("emailCell.appendChild(emailInput);");
            out.println("dateCell.appendChild(dateInput);");
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
            out.println("<th>Player ID</th>");
            out.println("<th>First Name</th>");
            out.println("<th>Last Name</th>");
             out.println("<th>Email</th>");
              out.println("<th>Date Joined</th>");
            out.println("</tr>");
            PlayerLogic logic = new PlayerLogic();
            List<Player> entities = logic.getAllPlayers();
            long counter = 0;
            for (Player entity : entities) {
                out.println("<tr>");
                out.println("<td class=\"delete\">");
                out.printf("<input type=\"checkbox\" name=\"deleteMark\" value=\"%d\" />", entity.getId());
                out.println("</td>");
                out.printf("<td class=\"edit\" id=\"%d\" ><input class=\"update\" type=\"button\" name=\"edit\" value=\"Edit\" /></td>", counter++);
                out.printf("<td class=\"code\" id=\"%d\" >%d</td>", counter++, entity.getId());
                out.printf("<td class=\"name\" id=\"%d\" >%s</td>", counter++, entity.getFirstName());
                out.printf("<td class=\"name\" id=\"%d\" >%s</td>", counter++, entity.getLastName());
                out.printf("<td class=\"name\" id=\"%d\" >%s</td>", counter++, entity.getEmail());
                 out.printf("<td class=\"name\" id=\"%d\" >%s</td>", counter++, entity.getJoined());
                out.println("</tr>");
            }
            out.println("<tr>");
            out.println("<th><input type=\"submit\" name=\"delete\" value=\"Delete\" /></th>");
            out.println("<th>Edit</th>");
            out.println("<th>Player ID</th>");
            out.println("<th>First Name</th>");
            out.println("<th>Last Name</th>");
             out.println("<th>Email</th>");
             out.println("<th>Date Joined</th>");
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
        PlayerLogic logic = new PlayerLogic();
        String[] values = request.getParameterValues("deleteMark");
        if(values!=null && values.length>=1)
            logic.deleteCourses( values);
        else
        {
            try
            {
                Player player = logic.createEntity(request.getParameterMap());
                logic.update(player);
            }catch(NullPointerException n)
            {
                PrintWriter out = response.getWriter();
                out.println("<script>alert(\"*Must Enter Letters & Cannot exeed 45 Charecters*\");</script>");
            }catch(IllegalArgumentException i)
            {
                PrintWriter out = response.getWriter();
                out.println("<script>alert(\"*Must Enter correct email format X@X.XX  & Cannot exeed 60 Charecters*\");</script>");
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
