<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Modelo.Empleado" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Actualizar Empleado</title>
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
        section {
            margin: 20px;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        form input[type="text"],
        form input[type="date"],
        form input[type="number"] {
            width: 100%;
            padding: 8px;
            margin: 10px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<header>
    <h1>Actualizar Empleado</h1>
</header>

<section>
    <form action="${pageContext.request.contextPath}/actualizarEmpleado" method="post">
        <input type="hidden" name="id" value="<%= ((Empleado) request.getAttribute("empleado")).getId() %>">

        <label for="nombres">Nombres:</label>
        <input type="text" id="nombres" name="nombres" value="<%= ((Empleado) request.getAttribute("empleado")).getNombres() %>" required>

        <label for="apellidos">Apellidos:</label>
        <input type="text" id="apellidos" name="apellidos" value="<%= ((Empleado) request.getAttribute("empleado")).getApellidos() %>" required>

        <label for="fechaIngreso">Fecha de Ingreso:</label>
        <input type="date" id="fechaIngreso" name="fechaIngreso" value="<%= ((Empleado) request.getAttribute("empleado")).getFechaIngreso() %>" required>

        <label for="sueldo">Sueldo:</label>
        <input type="number" id="sueldo" name="sueldo" step="0.01" value="<%= ((Empleado) request.getAttribute("empleado")).getSueldo() %>" required>

        <button type="submit">Actualizar</button>
    </form>
</section>
</body>
</html>
