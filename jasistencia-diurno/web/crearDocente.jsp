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
        <div id="logo">
            
        </div>
        <form action="creardocente.do" method="post" class="dark-matter">
            <h1>Registro de Profesor
                <span>Ingrese sus datos Por Favor</span>
            </h1>
            <label>
                <span>Run:</span>
                <input type="text" name="txtRunP" placeholder="Su Run:"/>
            </label>
            <label>
                <span>Nombre:</span>
                <input type="text" name="txtNombreP" placeholder="Su Nombre:"/>
            </label>
            <label>
                <span>Apellido Paterno:</span>
                <input type="text" name="txtApePatP" placeholder="Su Apellido Paterno:"/>
            </label>
            <label>
                <span>Apellido Materno:</span>
                <input type="text" name="txtApeMatP" placeholder="Su Apellido Materno:"/>
            </label>
            <label>
                <span>Edad:</span>
                <input type="number" name="txtEdadP" placeholder="Su Edad:"/>
            </label>
            <label>
                <span>Pass:</span>
                <input type="password" name="txtPassP" placeholder="Su Pass:"/>
            </label>
            <label>
                <span>Sexo:</span>
                Masculino:<input type="radio" name="opSexoP" value="true"/>
                Femenino:<input type="radio" name="opSexoP" value="false"/>
            </label>    
            <label align="center">
                <input type="submit" value="Registrar" />
            </label>
            <label>
                <a href="menuadministrador.jsp">Volver</a>
            </label>
        </form>
         <script src="js/script.js"></script>
    </body>
</html>
