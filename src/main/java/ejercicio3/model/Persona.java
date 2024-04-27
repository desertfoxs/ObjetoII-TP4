package ejercicio3.model;

public class Persona {

    private String apellido;
    private String nombre;
    private String DNI;
    private String telefono;
    private String email;
    private int idConcurso;

    public Persona(String apellido, String nombre, String DNI, String telefono, String email, int idConcurso) throws RuntimeException{

        // Guarda en inscriptos.txt los datos de la persona y el concurso elegido
        validations(apellido, nombre, DNI, telefono, email, idConcurso);

        this.apellido = apellido;
        this.nombre = nombre;
        this.DNI = DNI;
        this.telefono = telefono;
        this.email = email;
        this.idConcurso = idConcurso;
    }


    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getIdConcurso() {
        return idConcurso;
    }


    private void validations(String apellido, String nombre, String DNI, String telefono, String email, int idConcurso) throws RuntimeException{
        if (nombre.isEmpty()) {
            throw new RuntimeException("Nombre no puede ser vacio");
        }
        if (apellido.isEmpty()) {
            throw new RuntimeException("apellido no puede ser vacio");
        }
        if (DNI.isEmpty()) {
            throw new RuntimeException("dni no puede ser vacio");
        }
        if (!checkEmail(email)) {
            throw new RuntimeException("email debe ser válido");
        }
        if (!checkPhone(telefono)) {
            throw new RuntimeException( "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (idConcurso <= 0) {
            throw new RuntimeException( "Debe elegir un Concurso");
        }
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }


}
