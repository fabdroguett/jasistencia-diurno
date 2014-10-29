/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Alumno;
import modelo.Curso;
import modelo.DAO;

/**
 *
 * @author Fabian
 */
@WebServlet(name = "AsistenciaServlet", urlPatterns = {"/asistencia.view"})
public class AsistenciaServlet extends HttpServlet {

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
            String idc =request.getParameter("id");
            String nombre=request.getParameter("nombre");
            HttpSession session = request.getSession();
            Boolean paso=false;
            if (idc == null) {
                Curso c=(Curso) session.getAttribute("curso");
                idc=c.getId();
                nombre=c.getNombre();
                paso=Boolean.parseBoolean(request.getParameter("paso"));
            }
            DAO d=new DAO();
            List<Alumno> alums=d.getAlumnos(idc);
            
//            contador(c, alums);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AsistenciaServlet</title>"); 
            out.println("<meta charset=\"utf-8\">");
            out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+nombre+"</h1>");
            out.println("<h3> "+alums.size()+" Alumnos</h3>");
            out.println("<form action='pasar.do' method='post'>");
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<td>Run:</td>");
            out.println("<td>Nombre Completo:</td>");
            out.println("<td>Asistio:</td>");
            out.println("</tr>");
            
            for(Alumno a: alums){
                out.println("<tr>");
                out.println("<td>"+a.getRut()+"</td>");
                out.println("<td>"+a.getNombre()+" "+a.getApellidoPaterno()+" "+a.getApellidoMaterno()+"</td>");
                if (paso == false) {
                    out.println("<td><input type='checkbox' name='"+a.getId()+"' value='"+a.getId()+"'></td>");
                }else{
                    out.println("<td></td>");
                }
                
                out.println("</tr>");
                
            }
            out.println("<tr>");
            
            out.println("<td colspan='3'><input type='submit' value='Pasar Asistencia'></td>");
            out.println("</tr>");
            out.println("</table>");
            session.setAttribute("curso", new Curso(idc, nombre));
            out.println("</form>");
            out.println("<a href='menu.view'>Volver</a>");
            out.println("<script src=\"js/script.js\"></script>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(AsistenciaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public int contador(int contador, List<Alumno> alums){
//        for(contador = 1; contador <= alums.size(); contador++){
//                  return contador;
//            }
//        return contador;
//    }
//    
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
