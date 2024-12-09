package Controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Config.ConexionBD;
import Modelo.Empleado;


public class EmpleadoDAO {

    private ConexionBD conexionBD = new ConexionBD(); // Instanciar la clase

    //Listar los libros de la biblioteca
    public List<Empleado> obtenerDatos() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleados";
        try (Connection conn = conexionBD.conectar(); // Llamada al método no estático
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Empleado empleado = new Empleado(
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("fecha_ingreso"),
                    rs.getDouble("sueldo")
                );
                empleado.setId(rs.getInt("id")) ;
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    // Obtener un empleado por ID
    public Empleado obtenerEmpleadoPorId(int id) {
        String query = "SELECT * FROM empleados WHERE id = ?";
        System.out.println("Iniciando búsqueda para el empleado con ID: " + id);
        try (Connection conn = conexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            System.out.println("Ejecutando la consulta...");
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Empleado encontrado en la base de datos.");
                    return new Empleado(
                            rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("fecha_ingreso"),
                            rs.getDouble("sueldo")
                    );
                } else {
                    System.out.println("Empleado no encontrado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertarEmpleado(Empleado empleado) {
        String query = "INSERT INTO empleados (nombres, apellidos, fecha_ingreso, sueldo) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexionBD.conectar();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, empleado.getNombres());
            pstmt.setString(2, empleado.getApellidos());
            pstmt.setString(3, empleado.getFechaIngreso());
            pstmt.setDouble(4, empleado.getSueldo());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void actualizarEmpleado(Empleado empleado) {
        try (Connection conn = conexionBD.conectar()) {
            String sql = "UPDATE empleados SET nombres = ?, apellidos = ?, fecha_ingreso = ?, sueldo = ? WHERE id = ?";
            System.out.println("Esto recibi en DAO" + empleado.getId());
            System.out.println("el nombres" + empleado.getNombres());
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, empleado.getNombres());
                stmt.setString(2, empleado.getApellidos());
                stmt.setString(3, empleado.getFechaIngreso());
                stmt.setDouble(4, empleado.getSueldo());
                stmt.setInt(5, empleado.getId());

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean eliminarEmpleado(int id) {
        String query = "DELETE FROM empleados WHERE id = ?";
        try (Connection conn = conexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
