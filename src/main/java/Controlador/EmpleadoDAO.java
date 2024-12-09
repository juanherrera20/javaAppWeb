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
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("fecha_ingreso"),
                        rs.getDouble("sueldo")
                );
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




    //Metodo para agregar CRUD
    public boolean agregarLibro(String titulo, String autor, String genero, int anioPublicacion, boolean disponible) {
        String query = "INSERT INTO empleados (titulo, autor, genero, anio_publicacion, disponible) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = conexionBD.conectar();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);
            pstmt.setString(3, genero);
            pstmt.setInt(4, anioPublicacion);
            pstmt.setBoolean(5, disponible);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo para editar CRUD
    public boolean editarLibro(int idLibro, String titulo, String autor, String genero, int anioPublicacion, boolean disponible) {
        String query = "UPDATE empleados SET titulo = ?, autor = ?, genero = ?, anio_publicacion = ?, disponible = ? WHERE id_libro = ?";
        try (Connection conn = conexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);
            pstmt.setString(3, genero);
            pstmt.setInt(4, anioPublicacion);
            pstmt.setBoolean(5, disponible);
            pstmt.setInt(6, idLibro);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Metodo para el eliminar CRUD
    public boolean eliminarLibro(int idLibro) {
        String query = "DELETE FROM empleados WHERE id_libro = ?";
        try (Connection conn = conexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idLibro);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
