package ejercicio3.model;

public class Concurso {

    private int idconcurso;
    private String nombre;
    private String fechaInicioInscripcion;
    private String fechaFinInscripcion;

    public Concurso(int idconcurso, String nombre, String fechaInicioInscripcion, String fechaFinInscripcion) {
        this.idconcurso = idconcurso;
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public int getIdconcurso() {
        return idconcurso;
    }
    public String getNombre() {
        return nombre;
    }
    public String getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }
    public String getFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

}
