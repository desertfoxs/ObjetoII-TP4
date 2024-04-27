package ejercicio2.dataBase;

import ejercicio2.model.Empleado;
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
    public void cargarPersonas(Empleado empleado) {
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3_poo", "root", "");
             PreparedStatement sent = conexion.prepareStatement(sqlCreate);) {
            sent.setString(1, empleado.getApellido());
            sent.setString(2, empleado.getNombre());
            sent.setString(3, empleado.getNacimiento());
            sent.setString(4, empleado.getGmail());

            int update = sent.executeUpdate();
            sent.close();
        } catch (SQLException icve) {    //Exeption por si intenta cargar en la BD un dispositivo con el mismo nombre.
            // System.out.println("Se violo la integridad de la BD");
            throw new RuntimeException(icve);
        }
    }

    @Override
    public List<Empleado> devolverTodos() {
        List<Empleado> personas = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3_poo", "root", "");
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sqlFindAll);)
        {
            while (rs.next()) {
                personas.add(new Empleado(rs.getString("apellido"), rs.getString("nombre"),
                        rs.getString("nacimiento") , rs.getString("gmail")));
            }
        } catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return personas;

    }
}
