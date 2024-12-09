package Controlador;

import Modelo.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "CrearServlet", urlPatterns = "/formulario")
public class CrearServlet extends HttpServlet {
    private final EmpleadoDAO emDao = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Mostrar el formulario de creación
        request.getRequestDispatcher("/WEB-INF/formulario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Procesar el formulario de creación
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String fechaIngreso = request.getParameter("fechaIngreso");
        double sueldo = Double.parseDouble(request.getParameter("sueldo"));

        Empleado nuevoEmpleado = new Empleado(nombres, apellidos, fechaIngreso, sueldo);
        emDao.insertarEmpleado(nuevoEmpleado);

        // Redirigir al listado de empleados
        response.sendRedirect(request.getContextPath() + "/");
    }
}
