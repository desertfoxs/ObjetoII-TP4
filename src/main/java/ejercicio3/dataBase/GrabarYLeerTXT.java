package ejercicio3.dataBase;

import ejercicio3.model.Persona;
import ejercicio3.model.Registrar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class GrabarYLeerTXT implements Registrar {

    private String ruta ;

    public GrabarYLeerTXT(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void registrarPersona(Persona persona) {
        try {

            String mensaje = persona.getApellido() + "," + persona.getNombre() + "," + persona.getDNI() + "," + persona.getTelefono() + "," + persona.getEmail() + "," + persona.getIdConcurso();

            if (Files.notExists(Path.of(ruta + "inscriptos.txt"))) {
                Files.writeString(Paths.get(ruta+ "inscriptos.txt"), "\n"+ mensaje + "\n", StandardOpenOption.CREATE);
            } else {
                Files.writeString(Paths.get(ruta+ "inscriptos.txt"), mensaje, StandardOpenOption.APPEND);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public List<String> leerNombreConcursos() throws IOException {
        try {
            List<String> concursos = Files.readAllLines(Path.of(ruta + "concursos.txt"));
            List<String> nombreConcursos = new ArrayList<>();

            for(String concurso : concursos){
                String[] parts = concurso.split(",");
                String nombre = parts[1];
                nombreConcursos.add(nombre);
            }

            return nombreConcursos;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
