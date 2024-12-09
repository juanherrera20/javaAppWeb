<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Actualizar Empleado</title>
</head>
<body>
    <h1>Actualizar Empleado</h1>
    <form action="EmpleadoControlador" method="post">
        <input type="hidden" name="action" value="guardar">
        <input type="hidden" name="id" value="<%= ((Modelo.Empleado) request.getAttribute("empleado")).getId() %>">
        Nombres: <input type="text" name="nombres" value="<%= ((Modelo.Empleado) request.getAttribute("empleado")).getNombres() %>"><br>
        Apellidos: <input type="text" name="apellidos" value="<%= ((Modelo.Empleado) request.getAttribute("empleado")).getApellidos() %>"><br>
        Fecha de Ingreso: <input type="date" name="fecha_ingreso" value="<%= ((Modelo.Empleado) request.getAttribute("empleado")).getFechaIngreso() %>"><br>
        Sueldo: <input type="number" step="0.01" name="sueldo" value="<%= ((Modelo.Empleado) request.getAttribute("empleado")).getSueldo() %>"><br>
        <input type="submit" value="Actualizar">
    </form>
</body>
</html>
