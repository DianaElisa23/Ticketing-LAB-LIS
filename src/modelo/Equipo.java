package modelo;

public class Equipo {

    private int numEquipo;
    private String ubicacion;
    private String descripcion;

    public Equipo(int numEquipo, String ubicacion, String descripcion) {
        this.numEquipo = numEquipo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public int getNumEquipo() {
        return numEquipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
