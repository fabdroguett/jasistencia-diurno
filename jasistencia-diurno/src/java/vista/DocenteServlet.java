/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Soto
 */
@WebServlet(name = "DocenteServlet", urlPatterns = {"/docente.view"})
public class DocenteServlet extends HttpServlet {

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
            out.println("<title>Servlet DocenteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
              out.println("<form action='creardocente.do' method='post'>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<td>Rut Docente:</td>");
            out.println("<td><input type=\"text\" placeholder=\"Rut:\" name=\"txtrut\" required=\"required\"/></td>");
             out.println("</tr>");
             out.println("<tr>");
            out.println("<td>Nombre Docente:</td>");
            out.println("<td><input type=\"text\" placeholder=\"Nombre:\" name=\"txtnombre\" required=\"required\"/></td>");
            
            out.println("</tr>");
            
            out.println("<td>Apellido Paterno:</td>");
            out.println("<td><input type=\"text\" placeholder=\"Apellido P:\" name=\"txtappat\" required=\"required\"/></td>");
            
            out.println("</tr>");
            
            out.println("<td>Apellido Materno:</td>");
            out.println("<td><input type=\"text\" placeholder=\"Apellido M:\" name=\"txtapmat\" required=\"required\"/></td>");
            out.println("</tr>");
           
            
            out.println("<td>Edad Docente:</td>");
            out.println("<td><input type=\"text\" placeholder=\"Edad:\" name=\"txtedad\" required=\"required\"/></td>");
            out.println("</tr>");
               
            out.println("<td>Sexo :</td>");
            out.println("<td><input type=\"radio\" \n" +
"                   name=\"radioSex\" \n" +
"                   value=\"true\"\n" +
"                   />Masculino\n" +
"            <input type=\"radio\" \n" +
"                   name=\"radioSex\" \n" +
"                   value=\"false\"\n" +
"                   />Femenino</td>");
            out.println("</tr>");
            
             out.println("<td>Clave:</td>");
            out.println("<td><input type=\"text\" placeholder=\"Pass:\" name=\"txtpass\" required=\"required\"/></td>");
            out.println("</tr>");
               
            
            
            
            out.println("<td colspan='3'><input type='submit' value=Crear Docente''></td>");
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
