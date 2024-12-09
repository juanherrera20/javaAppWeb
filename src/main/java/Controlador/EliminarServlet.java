package Controlador;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "EliminarServlet", urlPatterns = "/eliminar")
public class EliminarServlet extends HttpServlet {
    private final EmpleadoDAO emDao = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        emDao.eliminarEmpleado(id);

        response.sendRedirect(request.getContextPath() + "/");
    }
}
