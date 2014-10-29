<%-- 
    Document   : crearAsignatura
    Created on : 27-10-2014, 01:50:19 AM
    Author     : Diego Soto
--%>

<%@page import="modelo.Profesor"%>
<%@page import="modelo.Curso"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Alumno"%>
<%@page import="modelo.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="crearAsignatura.do" method="post">
            <table border="1">
                <th colspan="2">
                    Crear Asignatura
                </th>
                <tr>
                    <td>
                        Nombre:
                    </td>
                    <td>
                        <input type="text" name="txtNombreAsignatura" placeholder="Nombre Asignatura:" required="required"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Profesor:
                    </td>
                    <td>
                        <select name="cboProfesorA">
                    <%
                        DAO d=new DAO();
                        List<Profesor> profesor=d.cargarProfesor();
                        for(Profesor p:profesor){
                            out.println("<option value='"+p.getRut()+"'>"+p.getNombre()+" "+p.getApellidoPaterno()+" "+p.getApellidoMaterno()+"</option>");
                        }
                    %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Registrar"/>
                    </td>
                </tr>
            </table>
        </form>
        <form action="asignarcurso.do" method="post">
            <table border="2">
                <th>
                    Asignar Asignatura
                </th>
                <tr>
                    <td>
                        Alumno
                    </td>
                    <td>
                        <select name="cboAlumno">
                    <%
                        DAO a=new DAO();
                       List<Alumno> alumno=a.cargarAlumno();
                       for(Alumno al:alumno){
                            out.println("<option value='"+al.getRut()+"'>"+al.getNombre()+" "+al.getApellidoPaterno()+" "+al.getApellidoMaterno()+"</option>");
                        }
                    %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Profesion:</td>
                    <td>
                        <select name="cboCurso">
                            <%
                        
                        List<Curso> curso=a.cargarAsignatura();
                        for(Curso cu:curso){
                            out.println("<option value='"+cu.getId()+"'>"+cu.getNombre()+"</option>");
                            System.out.println(cu.getId());
                        }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Asignar"/>
                    </td>
                </tr>
            </table>
                
        </form>
                         <li><a href="menuadministrador.jsp">Volver</a>
    </body>
</html>
