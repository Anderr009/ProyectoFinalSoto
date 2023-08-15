
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
    // ... otros métodos y atributos ...

    public void eliminarRegistro(int recordId) {
        try (Connection con = connectDB()) {
            if (con != null) {
                String deleteQuery = "DELETE FROM tabla WHERE id = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, recordId);
                    int rowsDeleted = preparedStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Registro eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró el registro a eliminar.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el registro: " + e.getMessage());
        }
    }

    public void actualizarRegistro(int recordId, String newFieldData) {
        try (Connection con = connectDB()) {
            if (con != null) {
                String updateQuery = "UPDATE tabla SET campo = ? WHERE id = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, newFieldData);
                    preparedStatement.setInt(2, recordId);
                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Registro actualizado correctamente.");
                    } else {
                        System.out.println("No se encontró el registro a actualizar.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el registro: " + e.getMessage());
        }
    }

    public void buscarRegistroById(int recordId) {
        try (Connection con = connectDB()) {
            if (con != null) {
                String searchQuery = "SELECT * FROM tabla WHERE id = "+ recordId + "";
                try (PreparedStatement preparedStatement = con.prepareStatement(searchQuery)) {
                    preparedStatement.setInt(1, recordId);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            System.out.println("Registro encontrado:");
                            System.out.println("ID: " + resultSet.getInt("id"));
                            // Imprimir otros campos necesarios aquí...
                        } else {
                            System.out.println("Registro no encontrado.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el registro: " + e.getMessage());
        }
    }

    // ... otros métodos y atributos ...
}
