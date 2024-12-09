package Controlador;

import Modelo.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ActualizarServlet", urlPatterns = "/actualizarEmpleado")
public class ActualizarServlet extends HttpServlet {

    private final EmpleadoDAO emDao = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Empleado empleado = emDao.obtenerEmpleadoPorId(id);

        if (empleado != null) {
            request.setAttribute("empleado", empleado);
            request.getRequestDispatcher("/WEB-INF/actualizar.jsp").forward(request, response);
        } else {
            response.sendRedirect("/index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String fechaIngreso = request.getParameter("fechaIngreso");
            double sueldo = Double.parseDouble(request.getParameter("sueldo"));

            Empleado empleado = new Empleado(id, nombres, apellidos, fechaIngreso, sueldo);
            System.out.println("Este es el ID" + empleado.getId());
            emDao.actualizarEmpleado(empleado);

            response.sendRedirect(request.getContextPath() + "/");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
