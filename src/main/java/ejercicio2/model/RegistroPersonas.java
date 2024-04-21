package ejercicio2.model;

import java.util.List;

public interface RegistroPersonas {

    public void cargarPersonas(String apellido, String nombre, String nacimiento, String gmail);
    public List<String> devolverTodos();
}
