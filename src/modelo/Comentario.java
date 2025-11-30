package modelo;

import java.time.LocalDateTime;

public class Comentario {

    private String texto;
    private String usuario;
    private LocalDateTime fecha;

    public Comentario(String texto, String usuario) {
        this.texto = texto;
        this.usuario = usuario;
        this.fecha = LocalDateTime.now();
    }

    public String getTexto() {
        return texto;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
