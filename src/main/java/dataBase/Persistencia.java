package dataBase;

import model.RegistroDeUsuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Persistencia implements RegistroDeUsuario {

    private final static String sqlCreate =
            "insert into participantes(nombre, telefono, region) values(?,?,?)";


    public void agregarNuevoParticipante(String nombre, String telefono, String region) {

        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3_poo", "root", "");
             PreparedStatement sent = conexion.prepareStatement(sqlCreate);) {
            sent.setString(1, nombre);
            sent.setString(2, telefono);
            sent.setString(3, region);

            sent.close();
        } catch (SQLException icve) {    //Exeption por si intenta cargar en la BD un dispositivo con el mismo nombre.
            // System.out.println("Se violo la integridad de la BD");
            throw new RuntimeException(icve);
        }
    }
}
