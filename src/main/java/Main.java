import Config.ConexionBD;
import Modelo.Empleado;
import Controlador.EmpleadoDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmpleadoDAO dao = new EmpleadoDAO();
        List<Empleado> empleados = dao.obtenerDatos();

        if (empleados != null && !empleados.isEmpty()) {
            empleados.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron empleados.");
        }
    }
}
