<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h2>Ejemplo de JSP con datos</h2>
        <p><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a> </p>
        <p>Este es el ID del empleado: ${id}</p> <!-- presentamos la variable data -->
        <p>Nombres del primer dato: ${nombres}</p> <!-- presentamos la variable numero -->

    </body>
</html>