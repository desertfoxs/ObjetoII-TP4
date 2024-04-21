package ejercicio2.dataBase;

import ejercicio2.model.LeerPersonas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class LeerTXT implements LeerPersonas {

    private String ruta;

    public LeerTXT(String ruta) {
        this.ruta = ruta;
    }

    public List<String> leer(){
        try {
            return Files.readAllLines(Path.of(ruta));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
