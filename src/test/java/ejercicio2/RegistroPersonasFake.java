package ejercicio2;

import ejercicio2.model.RegistroPersonas;

import java.util.ArrayList;
import java.util.List;

public class RegistroPersonasFake implements RegistroPersonas {

    private boolean invocado = false;

    @Override
    public void cargarPersonas(String apellido, String nombre, String nacimiento, String gmail) {
        invocado = true;
    }

    @Override
    public List<String> devolverTodos() {
        List<String> list = new ArrayList<>();
        return list;
    }

    public boolean fueInvocado() {
        return invocado;
    }
}
