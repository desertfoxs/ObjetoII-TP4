package ejercicio2;

import ejercicio2.dataBase.Persitencia;
import ejercicio2.model.EnviarGmail;
import ejercicio2.model.EnviarMensaje;
import ejercicio2.model.Model;
import ejercicio2.model.RegistroPersonas;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class Prueba {

    @Test
    public void probandoIngresoPersona() {
        //RegistroPersonas registroPersonas = new Persitencia();
        //EnviarMensaje enviador = new EnviarGmail();

        var registroPersonasFake = new RegistroPersonasFake();
        var enviadorFake = new EnviarMensajeFake();
        Model model = new Model(registroPersonasFake, enviadorFake);

        model.cargaEmpleados();
        model.verificarCumpleaños();

        assertTrue(registroPersonasFake.fueInvocado());
    }

    @Test
    public void probandoCumpleaños() {
        RegistroPersonas registroPersonas = new Persitencia();
        //EnviarMensaje enviador = new EnviarGmail();

        //var registroPersonasFake = new RegistroPersonasFake();
        var enviadorFake = new EnviarMensajeFake();
        Model model = new Model(registroPersonas, enviadorFake);

        model.cargaEmpleados();
        model.verificarCumpleaños();

        assertTrue(enviadorFake.fueInvocado());

    }

    @Test
    public void probandoEnviarGmail() {
        RegistroPersonas registroPersonas = new Persitencia();
        EnviarMensaje enviador = new EnviarGmail();

        Model model = new Model(registroPersonas, enviador);

        model.cargaEmpleados();
        model.verificarCumpleaños();
    }

}
