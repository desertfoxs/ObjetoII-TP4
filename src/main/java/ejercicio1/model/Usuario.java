package ejercicio1.model;

public class Usuario {

    private String nombre;
    private String telefono;
    private String region;


    public Usuario(String nombre, String telefono, String region) throws RuntimeException{
        validarUsuario(nombre, telefono, region);
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private void validarUsuario(String nombre, String telefono, String region) {
        if (nombre.isEmpty()) {
            throw new RuntimeException("Debe cargar un nombre");
        }
        if (telefono.isEmpty()) {
            throw new RuntimeException("Debe cargar un telefono");
        }
        if (!validarTelefono(telefono)) {
            throw new RuntimeException( "El telefono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        }
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRegion() {
        return region;
    }
}
