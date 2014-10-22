<%-- 
    Document   : index
    Created on : 15-10-2014, 11:43:51
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Iniciar Sesion</h1>
        <form action="iniciar.do" method="post">
            <table border="2" align="center">
            <thead>
                <tr>
                    <th colspan="2">Iniciar Sesion</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Run:</td>
                    <td>
                        <input type="text" placeholder="Rut:" name="txtRun" required="required"/> 
                    </td>
                </tr>
                <tr>
                    <td>Pass:</td>
                    <td>
                        <input type="password" placeholder="Pass:" name="txtPass" required="required"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Iniciar Sesion"/>
                    </td>
                </tr>
            </tbody>
        </table>
        </form>
        <a href="menuadministrador.jsp">Acceder como Administrador</a>
    </body>
</html>
