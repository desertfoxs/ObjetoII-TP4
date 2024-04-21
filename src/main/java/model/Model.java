package model;

import javax.swing.*;
import java.sql.SQLException;

public class Model {

    private RegistroDeUsuario registroDeUsuario;

    public Model(RegistroDeUsuario registroDeUsuario) {
        this.registroDeUsuario = registroDeUsuario;
    }

    public void agregarUsuario(String nombre, String telefono, String region) throws RuntimeException {
        try{
            validarUsuario(nombre, telefono, region);
            registroDeUsuario.agregarNuevoParticipante(nombre, telefono, region);
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }


    private void validarUsuario(String nombre, String telefono, String region) {
        if (nombre.isEmpty()) {
            throw new RuntimeException("Debe cargar un nombre");
        }
        if (telefono.isEmpty()) {
            throw new RuntimeException("Debe cargar un telefono");
        }
        if (!validarTelefono(telefono)) {
            throw new RuntimeException( "El telefono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        }
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

}
