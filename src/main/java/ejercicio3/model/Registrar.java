package ejercicio3.model;

import java.io.IOException;
import java.util.List;

public interface Registrar {


    public void registrarPersona(String mensaje) throws IOException;
    public List<String> leerConcursos() throws IOException;

}
