package Controlador;

import Modelo.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        name = "JspServlet",
        urlPatterns = "/jsp"
)
public class JspServlet extends HttpServlet {
    private final EmpleadoDAO emDao = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("Iniciando servlet para mostrar datos del empleado.");
        // Intentar obtener el empleado con ID 1
        System.out.println("Intentando obtener empleado...");
        Empleado objEmpleado = emDao.obtenerEmpleadoPorId(1);

        if (objEmpleado != null) {
            // Si el empleado existe, pasamos sus datos al JSP
            System.out.println("Empleado encontrado: " + objEmpleado.getNombres());
            request.setAttribute("id", objEmpleado.getId());
            request.setAttribute("nombres", objEmpleado.getNombres());
        } else {
            // Si el empleado no se encuentra
            System.out.println("Empleado no encontrado.");
            request.setAttribute("error", "Empleado no encontrado");
        }

        // Redirigir al JSP
        request.getRequestDispatcher("/WEB-INF/page.jsp").forward(request, response);

    }
}
