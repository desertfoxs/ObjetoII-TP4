package ejercicio2.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class LeerTXT {

    public List<String> leer(){
        try {
            return Files.readAllLines(Path.of("C:/Users/desertfoxs/Desktop/txt tp4/nombres.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
