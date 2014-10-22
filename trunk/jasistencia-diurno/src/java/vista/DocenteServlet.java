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
            out.println("<table border='2'>");
            out.println("<th colspan='2'>Registro de Profesores</th>");
            out.println("<tr>");
            out.println("<td>Run:</td>");
            out.println("<td>");
            out.println("<input type='text' name='txtRunP' placeholder='Run de Profesor:' required='required'/>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Nombre:</td>");
            out.println("<td>");
            out.println("<input type='text' name='txtNombreP' placeholder='Nombre de Profesor:' required='required'/>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Apellido Paterno:</td>");
            out.println("<td>");
            out.println("<input type='text' name='txtApePatP' placeholder='Apellido Paterno:' required='required'/>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Apellido Materno:</td>");
            out.println("<td>");
            out.println("<input type='text' name='txtApeMatP' placeholder='Apellido Materno:' required='required'/>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Edad:</td>");
            out.println("<td>");
            out.println("<input type='number' name='txtEdadP' placeholder='Edad de Profesor:' required='required'/>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Clave:</td>");
            out.println("<td>");
            out.println("<input type='password' name='txtPassP' placeholder='Pass:' required='required'/>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Sexo:</td>");
            out.println("<td>");
            out.println("Masculino<input type='radio' value='true' name='opSexoP'/>");
            out.println("Femenino<input type='radio' value='false' name='opSexoP'/>");
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td colspan='2'>");
            out.println("<input type='submit' value='Registrar'/>");
            out.println("</td>");
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
