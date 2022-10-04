package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author perez
 */
public class Conexion {

   public static Connection getConexion() {
        Connection cn = null;
        String DATA_BASE = "web_facturing";
        String USER = "root";
        String PASSWORD = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATA_BASE + "?serverTimezone=UTC", USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion");
            System.out.println("" + e);
        }
        return cn;
    }
}
