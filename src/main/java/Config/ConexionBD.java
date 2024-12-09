package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    private static Connection conn = null;

    private static final String DATABASE = "empleados_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1004528186";
    private static final String URL = "jdbc:mysql://localhost:3307/" + DATABASE;

    public static Connection conectar() {
        try {
            // Intenta la conexión
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException ex) {
            // Muestra información del error
            System.err.println("Error al conectar a la base de datos.!!!");
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return conn;
    }
}
