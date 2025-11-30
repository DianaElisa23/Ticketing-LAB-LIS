package modelo;

public class Tecnico extends Usuario {

    private String especialidad;

    public Tecnico(int numUsuario, String nombre, String especialidad) {
        super(numUsuario, nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
