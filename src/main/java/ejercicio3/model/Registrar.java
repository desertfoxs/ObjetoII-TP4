package ejercicio3.model;

import java.io.IOException;
import java.util.List;

public interface Registrar {

    public void registrarPersona(Persona persona) throws IOException;
    public List<String> leerNombreConcursos() throws IOException;

}
