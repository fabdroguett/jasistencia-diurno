<%-- 
    Document   : crearDocente
    Created on : Oct 28, 2014, 6:27:13 PM
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/registro.css"/>
    </head>
    <body background="images/bg.gif">
        <form action="crearalumno.do" method="post" class="dark-matter">
            <h1>Registro de Alumno
                <span>Ingrese sus datos Por Favor</span>
            </h1>
            <label>
                <span>Run:</span>
                <input type="text" name="txtRunA" placeholder="Su Run:"/>
            </label>
            <label>
                <span>Nombre:</span>
                <input type="text" name="txtNombreA" placeholder="Su Nombre:"/>
            </label>
            <label>
                <span>Apellido Paterno:</span>
                <input type="text" name="txtApePatA" placeholder="Su Apellido Paterno:"/>
            </label>
            <label>
                <span>Apellido Materno:</span>
                <input type="text" name="txtApeMatA" placeholder="Su Apellido Materno:"/>
            </label>
            <label>
                <span>Edad:</span>
                <input type="number" name="txtEdadA" placeholder="Su Edad:"/>
            </label>
            <label>
                <span>Sexo:</span>
                Masculino:<input type="radio" name="opSexoA" value="true">
                Femenino<input type="radio" name="opSexoA" value="false">
            </label>
            
            <label>
                
                <input type="submit" value="Registrar
                       "/>
            </label>
        </form>
         <li><a href="menuadministrador.jsp">Volver</a>
    </body>
</html>
