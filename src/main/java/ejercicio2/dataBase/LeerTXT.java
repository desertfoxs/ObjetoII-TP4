package ejercicio2.dataBase;

import ejercicio2.model.Empleado;
import ejercicio2.model.LeerPersonas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LeerTXT implements LeerPersonas {

    private String ruta;

    public LeerTXT(String ruta) {
        this.ruta = ruta;
    }

    public List<Empleado> leer(){
        List<Empleado> listaPersonasCargada = new ArrayList<>();
        try {
            List<String> listaPersonas = Files.readAllLines(Path.of(ruta));

            for(String persona: listaPersonas) {
                String[] parts = persona.split(",");
                String apellido = parts[0];
                String nombre = parts[1];
                String nacimiento = parts[2];
                String gmail = parts[3];
                listaPersonasCargada.add(new Empleado(apellido, nombre, nacimiento, gmail));
            }

            return listaPersonasCargada;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
