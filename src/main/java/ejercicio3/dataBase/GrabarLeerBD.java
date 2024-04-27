package ejercicio3.dataBase;

import ejercicio3.model.Persona;
import ejercicio3.model.Registrar;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrabarLeerBD implements Registrar {
    private final static String sqlCreate =
            "insert into ejerc3_inscriptos(apellido, nombre, DNI, teléfono, email, idconcurso) values(?,?,?,?,?,?)";

    private final static String sqlFindAll =
            "SELECT nombre FROM `ejerc3_concursos`";

    @Override
    public void registrarPersona(Persona persona) throws IOException {

        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3_poo", "root", "");
             PreparedStatement sent = conexion.prepareStatement(sqlCreate);) {
            sent.setString(1, persona.getApellido());
            sent.setString(2, persona.getNombre());
            sent.setString(3, persona.getDNI());
            sent.setString(4, persona.getTelefono());
            sent.setString(5, persona.getEmail());
            sent.setInt(6, persona.getIdConcurso());

            int update = sent.executeUpdate();
            sent.close();
        } catch (SQLException icve) {    //Exeption por si intenta cargar en la BD un dispositivo con el mismo nombre.
            // System.out.println("Se violo la integridad de la BD");
            throw new RuntimeException(icve);
        }
    }

    @Override
    public List<String> leerNombreConcursos() throws IOException {
        List<String> concurso = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3_poo", "root", "");
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sqlFindAll);)
        {
            while (rs.next()) {
                concurso.add( rs.getString("nombre"));
            }
        } catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return concurso;
    }
}
