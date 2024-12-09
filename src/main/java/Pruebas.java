import Modelo.Empleado;
import Controlador.EmpleadoDAO;

import java.sql.SQLException;
import java.util.List;

public class Pruebas {
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
