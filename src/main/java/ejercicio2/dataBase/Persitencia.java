package ejercicio2.dataBase;

import ejercicio2.model.RegistroPersonas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Persitencia implements RegistroPersonas {

    private final static String sqlCreate =
            "insert into ejercicio2(apellido, nombre, nacimiento, gmail) values(?,?,?,?)";

    private final static String sqlFindAll =
            "SELECT * FROM `ejercicio2`";

    @Override
    public void cargarPersonas(String apellido, String nombre, String nacimiento, String gmail) {
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3_poo", "root", "");
             PreparedStatement sent = conexion.prepareStatement(sqlCreate);) {
            sent.setString(1, apellido);
            sent.setString(2, nombre);
            sent.setString(3, nacimiento);
            sent.setString(4, gmail);

            int update = sent.executeUpdate();
            sent.close();
        } catch (SQLException icve) {    //Exeption por si intenta cargar en la BD un dispositivo con el mismo nombre.
            // System.out.println("Se violo la integridad de la BD");
            throw new RuntimeException(icve);
        }
    }

    @Override
    public List<String> devolverTodos() {
        List<String> personas = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3_poo", "root", "");
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sqlFindAll);)
        {
            while (rs.next()) {
                personas.add(rs.getString("apellido") + "," + rs.getString("nombre") + "," +
                        rs.getString("nacimiento") + ","+ rs.getString("gmail"));
            }
        } catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return personas;

    }
}
