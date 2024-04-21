package ejercicio3.dataBase;

import ejercicio3.model.Registrar;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrabarLeerBD implements Registrar {
    private final static String sqlCreate =
            "insert into ejerc3_inscriptos(apellido, nombre, DNI, teléfono, email, idconcurso) values(?,?,?,?,?,?)";

    private final static String sqlFindAll =
            "SELECT * FROM `ejerc3_concursos`";

    @Override
    public void registrarPersona(String mensaje) throws IOException {
        String[] parts = mensaje.split(",");
        String apellido = parts[0];
        String nombre = parts[1];
        String DNI = parts[2];
        String telefono = parts[3];
        String email = parts[4];
        String idconcurso = parts[5];

        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3_poo", "root", "");
             PreparedStatement sent = conexion.prepareStatement(sqlCreate);) {
            sent.setString(1, apellido);
            sent.setString(2, nombre);
            sent.setString(3, DNI);
            sent.setString(4, telefono);
            sent.setString(5, email);
            sent.setInt(6, Integer.parseInt(idconcurso));

            int update = sent.executeUpdate();
            sent.close();
        } catch (SQLException icve) {    //Exeption por si intenta cargar en la BD un dispositivo con el mismo nombre.
            // System.out.println("Se violo la integridad de la BD");
            throw new RuntimeException(icve);
        }
    }

    @Override
    public List<String> leerConcursos() throws IOException {
        List<String> personas = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3_poo", "root", "");
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sqlFindAll);)
        {
            while (rs.next()) {
                personas.add(rs.getInt("ID") + "," + rs.getString("nombre") + "," +
                        rs.getString("fechaInicioInscripcion") + "," + rs.getString("fechaFinInscripcion"));
            }
        } catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return personas;
    }
}
