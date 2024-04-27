package ejercicio1.model;

public class SistemaRegistracion {

    private RegistroDeUsuario registroDeUsuario;

    public SistemaRegistracion(RegistroDeUsuario registroDeUsuario) {
        this.registroDeUsuario = registroDeUsuario;
    }

    public void agregarUsuario(String nombre, String telefono, String region) throws RuntimeException {
        try{
            Usuario usuario = new Usuario(nombre, telefono, region);
            registroDeUsuario.agregarNuevoParticipante(usuario);
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
