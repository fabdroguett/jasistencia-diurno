/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "CrearDocente", urlPatterns = {"/creardocente.do"})
public class CrearDocente extends HttpServlet {

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
            String rut,nombre, appat,apmat,pass,sx;
            int edad;
            boolean sexo;
            rut=request.getParameter("txtRunP");
            nombre=request.getParameter("txtNombreP");
            appat=request.getParameter("txtApePatP");
            apmat=request.getParameter("txtApeMatP");
            edad=Integer.parseInt(request.getParameter("txtEdadP"));
            sexo=Boolean.parseBoolean(request.getParameter("opSexo"));
            System.out.println(sexo);
            if(sexo==true){
                sx="m";
            }else{
                sx="f";
            }
            pass=request.getParameter("txtPassP");
            Profesor p=new Profesor(rut, nombre, apmat, apmat, edad, sx, pass);
            
            d.crearProfesor(p);
            request.getRequestDispatcher("docente.view").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CrearDocente.class.getName()).log(Level.SEVERE, null, ex);
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
