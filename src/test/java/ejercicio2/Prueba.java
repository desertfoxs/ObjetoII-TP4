package ejercicio2;

import ejercicio2.dataBase.LeerTXT;
import ejercicio2.dataBase.Persitencia;
import ejercicio2.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Prueba {

    @Test
    public void probandoIngresoPersona() {
        //RegistroPersonas registroPersonas = new Persitencia();
        //EnviarMensaje enviador = new EnviarGmail();
        LeerPersonas leerTXT = new LeerTXT("C:/Users/desertfoxs/Desktop/txt tp4/nombres.txt");

        var registroPersonasFake = new RegistroPersonasFake();
        var enviadorFake = new EnviarMensajeFake();
        FelicitarEmpleado felicitarEmpleado = new FelicitarEmpleado(registroPersonasFake, enviadorFake, leerTXT);

        felicitarEmpleado.cargaEmpleados();
        felicitarEmpleado.verificarCumpleaños();

        assertTrue(registroPersonasFake.fueInvocado());
    }

    @Test
    public void probandoCumpleaños() {
        RegistroPersonas registroPersonas = new Persitencia();
        //EnviarMensaje enviador = new EnviarGmail();
        LeerPersonas leerTXT = new LeerTXT("C:/Users/desertfoxs/Desktop/txt tp4/nombres.txt");

        //var registroPersonasFake = new RegistroPersonasFake();
        var enviadorFake = new EnviarMensajeFake();
        FelicitarEmpleado felicitarEmpleado = new FelicitarEmpleado(registroPersonas, enviadorFake, leerTXT);

        felicitarEmpleado.cargaEmpleados();
        felicitarEmpleado.verificarCumpleaños();

        assertTrue(enviadorFake.fueInvocado());

    }

    @Test
    public void probandoEnviarGmail() {
        RegistroPersonas registroPersonas = new Persitencia();
        EnviarMensaje enviador = new EnviarGmail();
        LeerPersonas leerTXT = new LeerTXT("C:/Users/desertfoxs/Desktop/txt tp4/nombres.txt");

        FelicitarEmpleado felicitarEmpleado = new FelicitarEmpleado(registroPersonas, enviador, leerTXT);

        felicitarEmpleado.cargaEmpleados();
        felicitarEmpleado.verificarCumpleaños();
    }

}
