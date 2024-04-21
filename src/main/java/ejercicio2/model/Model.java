package ejercicio2.model;

import java.time.LocalDateTime;
import java.util.List;

public class Model {

    private RegistroPersonas registroPersonas;
    private LeerPersonas leerPersonas;
    private EnviarMensaje enviarMensaje;
    private String mensaje = "Feliz cumpleaños atte: compania generica";

    public Model(RegistroPersonas registroPersonas, EnviarMensaje enviarMensaje, LeerPersonas leerPersonas) {
        this.registroPersonas = registroPersonas;
        this.leerPersonas = leerPersonas;
        this.enviarMensaje = enviarMensaje;
    }

    public void cargaEmpleados(){

        List<String> listaPersonas = leerPersonas.leer();

        for(String persona: listaPersonas) {
            String[] parts = persona.split(",");
            String apellido = parts[0];
            String nombre = parts[1];
            String nacimiento = parts[2];
            String gmail = parts[3];

            registroPersonas.cargarPersonas(apellido, nombre, nacimiento, gmail);

        }
    }

    public void verificarCumpleaños(){

        FormatterDayTime formater = new FormatterDayTime();
        List<String> listaPersonas = registroPersonas.devolverTodos();

        for(String persona: listaPersonas) {
            String[] parts = persona.split(",");
            String nacimiento = parts[2];
            String gmail = parts[3];

            String[] partsFecha = nacimiento.split("/");
            String cumple = partsFecha[1] + "/" + partsFecha[2];

            if(cumple.equals(formater.toString(LocalDateTime.now()))){
                enviarMensaje.enviar(gmail, mensaje);
            }
        }
    }




}
