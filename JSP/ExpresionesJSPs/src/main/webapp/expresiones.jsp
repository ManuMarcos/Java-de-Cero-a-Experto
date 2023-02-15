<%-- 
    Document   : expresiones
    Created on : 5 ene 2023, 14:49:38
    Author     : manue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Expresiones</title>
    </head>
    <body>
        <h1>JSP con Expresiones</h1>
        Concatenacion: <%= "Saludos" + " " + "JSP" %>
        <br>
        Operacion Matematica: <%= 2 * 3 / 2 %>
        <br>
        Session id: <%= session.getId() %>
        <br>
        <br>
        <a href="index.html"> Regresar al inicio </a>
        
    </body>
</html>
