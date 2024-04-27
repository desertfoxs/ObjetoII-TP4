package ejercicio2;

import ejercicio2.model.Empleado;
import ejercicio2.model.RegistroPersonas;

import java.util.ArrayList;
import java.util.List;

public class RegistroPersonasFake implements RegistroPersonas {

    private boolean invocado = false;

    @Override
    public void cargarPersonas(Empleado empleado) {
        invocado = true;
    }

    @Override
    public List<Empleado> devolverTodos() {
        List<Empleado> list = new ArrayList<>();
        return list;
    }

    public boolean fueInvocado() {
        return invocado;
    }
}
