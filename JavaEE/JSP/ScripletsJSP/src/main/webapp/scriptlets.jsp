<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br>
        <%-- Scriptlet para enviar informacion al navegador --%>
        <%
            out.print("Saludos desde un Scriptlet");
        %>
        <%-- Scriptlet para manipular los objetos implicitos --%>
        <%
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la aplicacion" + nombreAplicacion);
        %>
        <br>
        <%-- Scriplet con codigo condicionado --%>
        <%
            if(session != null && session.isNew()){
        %>
        la sesion SI es nueva
        <%
            }else if(session != null){
        %>
        la sesion NO es nueva
        <% } %>
        <a href="index.html">Regreso al inicio</a>
    </body>
</html>
