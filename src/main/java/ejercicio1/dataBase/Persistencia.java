package ejercicio1.dataBase;

import ejercicio1.model.RegistroDeUsuario;
import ejercicio1.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Persistencia implements RegistroDeUsuario {

    private final static String sqlCreate =
            "insert into participantes(nombre, telefono, region) values(?,?,?)";


    public void agregarNuevoParticipante(Usuario usuario) {

        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3_poo", "root", "");
             PreparedStatement sent = conexion.prepareStatement(sqlCreate);) {
            sent.setString(1, usuario.getNombre());
            sent.setString(2, usuario.getTelefono());
            sent.setString(3, usuario.getRegion());
            sent.executeUpdate();
            sent.close();
        } catch (SQLException icve) {    //Exeption por si intenta cargar en la BD un dispositivo con el mismo nombre.
            // System.out.println("Se violo la integridad de la BD");
            throw new RuntimeException(icve);
        }
    }
}
