<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Empleados</title>
</head>
<body>
    <h1>Lista de Empleados</h1>
    <a href="EmpleadoControlador?action=crear">Crear Empleado</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="empleado" items="${empleados}">
                <tr>
                    <td>${empleado.id}</td>
                    <td>${empleado.nombres}</td>
                    <td>${empleado.apellidos}</td>
                    <td>
                        <a href="EmpleadoControlador?action=update&id=${empleado.id}">Actualizar</a>
                        <a href="EmpleadoControlador?action=eliminar&id=${empleado.id}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
