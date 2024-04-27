package ejercicio2.model;

public class Empleado {

    private String apellido;
    private String nombre;
    private String nacimiento;
    private String gmail;

    public Empleado(String apellido, String nombre, String nacimiento, String gmail) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.gmail = gmail;
    }


    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getGmail() {
        return gmail;
    }

}
