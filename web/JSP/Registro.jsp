<%-- 
    Document   : Registro
    Created on : 8/10/2018, 08:14:22 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="POST" action="../RegistroServlet">
            
            <label for="NOMBRE">Ingresa tu nombre:</label>
            <input type="text" name="NOMBRE" id="nombre"><BR /><BR />
            
            <label for="APELLIDO">Ingresa tu apellido: </label>
            <input type="text" name="APELLIDO" id="apellido"><BR /><BR />
            
            <input type="submit" name="enviar" id="nombre"><BR />

        </form>
    </body>
</html>
