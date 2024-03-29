/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

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
import javax.servlet.http.HttpSession;
import modelo.Curso;
import modelo.DAO;
import modelo.Profesion;
import modelo.Profesor;
import modelo.Error;

/**
 *
 * @author Fabian
 */
@WebServlet(name = "MenuServlet", urlPatterns = {"/menu.view"})
public class MenuServlet extends HttpServlet {

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
           DAO d=new DAO();
            HttpSession session = request.getSession();
            Profesor profe=(Profesor) session.getAttribute("profesor");
            if(profe == null){
                List<Error> errors = new ArrayList<Error>();
                errors.add(new Error(200, "Por favor,Inicie Sesion Primero"));
                session.setAttribute("errors", errors);
                request.getRequestDispatcher("error.view").forward(request, response);
            }
            List<Curso> cursoProfe=d.getCurso(profe.getRut());
            List<Profesion> profesiones=d.getProfesiones(profe.getRut());
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<link href='css/layout.css' rel='stylesheet' type='text/css'/>");
            out.println("<link href='css/menu.css' rel='stylesheet' type='text/css'/>");
            
            out.println("</head>");
            out.println("<body>");
            out.println("<ul id='nav'>");
                out.println("<li><a href='#'>"+profe.getNombre()+"</a>");
                    out.println("<ul>");
                    for(Profesion profesion:profesiones){
                        if("Ingenieria en informática".equals(profesion.getNombre())){
                            out.println("<li><a href='#'>I.E.I</a></li>");   
                        }else{
                            out.println("<li><a href='#'>"+profesion.getNombre()+"</a></li>");
                        }
                    }
                    out.println("</ul>");
                out.println("</li>");
                out.println("<li><a href=''>Asignaturas</a>");
                out.println("<ul>");
                for(Curso c:cursoProfe){
                    out.println("<li><a href='asistencia.view?id="+c.getId()+"&nombre="+c.getNombre()+"'>"+c.getNombre()+"</a></li>");
                }
                out.println("</ul>");
                out.println("</li>");
                out.println("<li><a href='cerrar.do'>Cerrar Sesion</a></li>");
            out.println("</ul>");
            out.println("<script src='js/script.js'></script>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
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
