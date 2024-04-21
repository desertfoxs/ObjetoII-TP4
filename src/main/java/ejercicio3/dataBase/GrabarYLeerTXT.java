package ejercicio3.dataBase;

import ejercicio3.model.Registrar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class GrabarYLeerTXT implements Registrar {

    //"C:/Users/desertfoxs/Desktop/txt tp4 ejercicio 3/";
    private String ruta ;

    public GrabarYLeerTXT(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void registrarPersona(String mensaje) {
        try {
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
    public List<String> leerConcursos() throws IOException {
        try {
            return Files.readAllLines(Path.of(ruta + "concursos.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
