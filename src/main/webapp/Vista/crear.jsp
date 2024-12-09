<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Crear Empleado</title>
</head>
<body>
    <h1>Crear Empleado</h1>
    <form action="EmpleadoControlador" method="post">
        <input type="hidden" name="action" value="guardar">
        Nombres: <input type="text" name="nombres" required><br>
        Apellidos: <input type="text" name="apellidos" required><br>
        Fecha de Ingreso: <input type="date" name="fecha_ingreso" required><br>
        Sueldo: <input type="number" step="0.01" name="sueldo" required><br>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>
