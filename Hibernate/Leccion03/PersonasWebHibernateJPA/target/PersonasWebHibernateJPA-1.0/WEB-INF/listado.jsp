<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de personas</title>
    </head>
    <body>
        <table border="1">
            <caption>Listado de Personas</caption>
            <tr>
                <th>Id Persona</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Telefono</th>
            </tr>
            <c:forEach var="persona" items="${personas}">
                <tr>
                    <td>${persona.idPersona}</td>
                    <td>${persona.nombre}</td>
                    <td>${persona.apellido}</td>
                    <td>${persona.email}</td>
                    <td>${persona.telefono}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
