package ejercicio2;

import ejercicio2.model.EnviarMensaje;

public class EnviarMensajeFake implements EnviarMensaje {

    private boolean invocado = false;
    @Override
    public void enviar(String gmail, String mensaje) {
        invocado = true;
    }

    public boolean fueInvocado() {
        return invocado;
    }
}
