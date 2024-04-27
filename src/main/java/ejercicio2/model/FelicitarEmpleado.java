package ejercicio2.model;

import java.time.LocalDateTime;
import java.util.List;

public class FelicitarEmpleado {

    private RegistroPersonas registroPersonas;
    private LeerPersonas leerPersonas;
    private EnviarMensaje enviarMensaje;
    private String mensaje = "Feliz cumpleaños atte: compania generica";

    public FelicitarEmpleado(RegistroPersonas registroPersonas, EnviarMensaje enviarMensaje, LeerPersonas leerPersonas) {
        this.registroPersonas = registroPersonas;
        this.leerPersonas = leerPersonas;
        this.enviarMensaje = enviarMensaje;
    }

    public void cargaEmpleados(){

        List<Empleado> listaPersonas = leerPersonas.leer();

        for(Empleado persona: listaPersonas) {
            registroPersonas.cargarPersonas(persona);
        }
    }

    public void verificarCumpleaños(){

        FormatterDayTime formater = new FormatterDayTime();
        List<Empleado> listaPersonas = registroPersonas.devolverTodos();

        for(Empleado persona: listaPersonas) {

            String[] partsFecha = persona.getNacimiento().split("/");
            String cumple = partsFecha[1] + "/" + partsFecha[2];

            if(cumple.equals(formater.toString(LocalDateTime.now()))){
                enviarMensaje.enviar(persona.getGmail(), mensaje);
            }
        }
    }




}
