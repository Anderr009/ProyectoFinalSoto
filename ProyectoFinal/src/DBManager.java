
/**
 *
 * @author Anderson
 */
import java.sql.*;

public class DBManager {

    private Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println("No cargo el driver");
        }
        String url = "jdbc:mysql://localhost/prueba";
        String user = "root";
        String password = "";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println("Error al conectar la BD");
            return null; 
        }
    }

}
