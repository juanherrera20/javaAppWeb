package Controlador;

import Config.ConexionBD;
import Modelo.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    private final Connection conn;

    public EmpleadoDAO() {
        this.conn = ConexionBD.conectar();
    }

    // Listar todos los empleados
    public List<Empleado> obtenerDatos() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleados";

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("fecha_ingreso"),
                        rs.getDouble("sueldo")
                );
                empleados.add(empleado);
            }
        }

        return empleados;
    }

    // Obtener un empleado por ID
    public Empleado obtenerEmpleadoPorId(int id) throws SQLException {
        String query = "SELECT * FROM empleados WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Empleado(
                            rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("fecha_ingreso"),
                            rs.getDouble("sueldo")
                    );
                }
            }
        }
        return null;
    }

    // Crear un nuevo empleado
    public void crearEmpleado(Empleado empleado) throws SQLException {
        String query = "INSERT INTO empleados (nombres, apellidos, fecha_ingreso, sueldo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, empleado.getNombres());
            stmt.setString(2, empleado.getApellidos());
            stmt.setString(3, empleado.getFechaIngreso());
            stmt.setDouble(4, empleado.getSueldo());
            stmt.executeUpdate();
        }
    }

    // Actualizar un empleado
    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        String query = "UPDATE empleados SET nombres = ?, apellidos = ?, fecha_ingreso = ?, sueldo = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, empleado.getNombres());
            stmt.setString(2, empleado.getApellidos());
            stmt.setString(3, empleado.getFechaIngreso());
            stmt.setDouble(4, empleado.getSueldo());
            stmt.setInt(5, empleado.getId());
            stmt.executeUpdate();
        }
    }

    // Eliminar un empleado
    public void eliminarEmpleado(int id) throws SQLException {
        String query = "DELETE FROM empleados WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
