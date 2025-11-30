package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroHistorial {

    private String accion;
    private String usuario;
    private LocalDateTime fecha;

    public RegistroHistorial(String accion, String usuario) {
        this.accion = accion;
        this.usuario = usuario;
        this.fecha = LocalDateTime.now();
    }

    public String getAccion() {
        return accion;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        return fecha.format(formato) + " - " + accion;
    }
}
