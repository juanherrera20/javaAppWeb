<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.Empleado" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Empleados</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #007bff;
            color: white;
            padding: 15px;
            text-align: center;
        }
        nav {
            margin: 15px;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
        }
        nav ul li {
            display: inline;
            margin-right: 10px;
        }
        nav ul li a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        nav ul li a:hover {
            text-decoration: underline;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: #fff;
        }
        table th, table td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        table th {
            background-color: #007bff;
            color: white;
        }
        .add-button {
            display: block;
            width: 200px;
            margin: 20px auto;
            text-align: center;
            padding: 10px 15px;
            background-color: #28a745;
            color: white;
            font-size: 16px;
            text-decoration: none;
            border-radius: 5px;
        }
        .add-button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<header>
    <h1>Gestión de Empleados</h1>
    <h3>${hola}</h3>
</header>

<section>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Fecha Ingreso</th>
                <th>Sueldo</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
        <%
            // Recuperar lista de empleados enviada desde el servlet
            List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
            if (empleados != null && !empleados.isEmpty()) {
                for (Empleado emp : empleados) {
        %>
                    <tr>
                        <td><%= emp.getId() %></td>
                        <td><%= emp.getNombres() %></td>
                        <td><%= emp.getApellidos() %></td>
                        <td><%= emp.getFechaIngreso() %></td>
                        <td><%= emp.getSueldo() %></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/actualizarEmpleado?id=<%= emp.getId() %>">Editar</a>
                            <a href="${pageContext.request.contextPath}/eliminar?id=<%= emp.getId() %>"
                               onclick="return confirm('¿Seguro que desea eliminar este empleado?')">Eliminar</a>
                        </td>
                    </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="6" style="text-align: center;">No hay empleados registrados.</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/formulario" class="add-button">Agregar Nuevo Empleado</a>
</section>

</body>
</html>
