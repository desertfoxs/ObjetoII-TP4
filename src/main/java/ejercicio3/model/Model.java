package ejercicio3.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private Registrar registrador;

    public Model(Registrar registrador) {
        this.registrador = registrador;
    }

    public List<String> todosLosConcursos() throws IOException {
        // carga del archivo de texto concursos.txt los concursos
        List<String> concursos = new ArrayList<>();
        List<String> nombreConcurso = new ArrayList<>();

        concursos = registrador.leerConcursos();

        for(String concurso : concursos){
            String[] parts = concurso.split(",");
            String nombre = parts[1];
            nombreConcurso.add(nombre);
        }

        return nombreConcurso;
    }


    public void saveInscription(String apellido, String nombre, String DNI, String telefono, String email, int idConcurso) throws RuntimeException {
        try {
            // Guarda en inscriptos.txt los datos de la persona y el concurso elegido
            validations(apellido, nombre, DNI, telefono, email, idConcurso);

            String mensaje = apellido + "," + nombre + "," + DNI + "," + telefono + "," + email + "," + idConcurso;

            registrador.registrarPersona(mensaje);

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void validations(String apellido, String nombre, String DNI, String telefono, String email, int idConcurso) throws RuntimeException{
        if (nombre.isEmpty()) {
            throw new RuntimeException("Nombre no puede ser vacio");
        }
        if (apellido.isEmpty()) {
            throw new RuntimeException("apellido no puede ser vacio");
        }
        if (DNI.isEmpty()) {
            throw new RuntimeException("dni no puede ser vacio");
        }
        if (!checkEmail(email)) {
            throw new RuntimeException("email debe ser válido");
        }
        if (!checkPhone(telefono)) {
            throw new RuntimeException( "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (idConcurso <= 0) {
            throw new RuntimeException( "Debe elegir un Concurso");
        }
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }



}
