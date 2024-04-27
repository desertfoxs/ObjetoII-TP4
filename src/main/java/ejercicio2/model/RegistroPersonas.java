package ejercicio2.model;

import java.util.List;

public interface RegistroPersonas {
    public void cargarPersonas(Empleado empleado);
    public List<Empleado> devolverTodos();
}
