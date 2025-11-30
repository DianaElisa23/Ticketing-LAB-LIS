package modelo;

public abstract class Usuario {
    protected int numUsuario;
    protected String nombre;

    public Usuario(int numUsuario, String nombre) {
        this.numUsuario = numUsuario;
        this.nombre = nombre;
    }

    public int getNumUsuario() {
        return numUsuario;
    }

    public String getNombre() {
        return nombre;
    }
}
