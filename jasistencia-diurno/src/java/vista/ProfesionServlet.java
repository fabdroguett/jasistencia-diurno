package vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO;
import modelo.Profesor;

/**
 *
 * @author Diego Soto
 */
@WebServlet(urlPatterns = {"/profesion.view"})
public class ProfesionServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            DAO d=new DAO();
            List<Profesor> prof=new ArrayList();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfesionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
             out.println("<form action='crearprofesion.do' method='post'>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<td>nombre profesion:</td>");
            out.println("<td><input type=\"text\" placeholder=\"Profesion:\" name=\"txtProfesion\" required=\"required\"/></td>");
       
            
            out.println("<td colspan='3'><input type='submit' value=Crear Profesion''></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            
            out.println("<form action='asignarprofesion.do' method='post'>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<td>Docente:</td>");
            
          for(Profesor p:prof){
            out.println("<td><select name=\"item\">\n" +
"    <option value=\"\">1</option>\n" +
"    <option value=\"2\">2</option>\n" +
"    <option value=\"3\">3</option>\n" +
"  </select></td>");
          }
            
            out.println("<td colspan='3'><input type='submit' value=Crear Profesion''></td>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProfesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
