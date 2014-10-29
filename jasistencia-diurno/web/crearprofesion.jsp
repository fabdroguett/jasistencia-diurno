<%-- 
    Document   : crearprofesion
    Created on : Oct 26, 2014, 6:11:50 PM
    Author     : Fabian
--%>

<%@page import="modelo.Profesion"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Profesor"%>
<%@page import="modelo.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel='stylesheet' type='text/css' href='css/style.css'/>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <form action="crearProfesion.do" method="post">
            <table border="1" align="center">
                <th colspan="2">
                    Crear Profesion
                </th>
                <tr>
                    <td>
                        Nombre:
                    </td>
                    <td>
                        <input type="text" name="txtNombreProfesion" placeholder="Nombre Profesion:" required="required"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Registrar"/>
                    </td>
                </tr>
            </table>
        </form>
        <form action="asignarprofesion.do" method="post">
            <table border="2" align="center">
                <th>
                    Asignar Profesion
                </th>
                <tr>
                    <td>
                        Profesor
                    </td>
                    <td>
                        <select name="cboProfesor">
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
                    <td>Profesion:</td>
                    <td>
                        <select name="cboProfesion">
                            <%
                        
                        List<Profesion> profesion=d.cargarProfesion();
                        for(Profesion pro:profesion){
                            out.println("<option value='"+pro.getId()+"'>"+pro.getNombre()+"</option>");
                            System.out.println(pro.getId());
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
             <li><a href="menuadministrador.jsp">Volver</a>    
        </form>
                        <script src="js/script.js"></script>
    </body> 
   
</html>
