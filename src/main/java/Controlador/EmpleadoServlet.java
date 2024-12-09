package Controlador;

import Modelo.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpleadoServlet", urlPatterns = "")
public class EmpleadoServlet extends HttpServlet {
    private final EmpleadoDAO emDao = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Obtener la lista de empleados desde la base de datos
        List<Empleado> empleados = emDao.obtenerDatos();
        // Asegurarse de pasar correctamente la lista como atributo al JSP
        request.setAttribute("empleados", empleados);

        // Mensaje de prueba
        String hola = "Se listan los empleados existentes en la Base de Datos";
        request.setAttribute("hola", hola);

        // Redirigir al JSP de listado (index.jsp)
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
