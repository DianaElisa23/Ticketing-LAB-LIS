package modelo;

import enums.*;
import java.util.ArrayList;
import java.util.List;

public class Incidencia {

    private int numIncidencia;
    private String descripcion;
    private TipoIncidencia tipo;
    private Prioridad prioridad;
    private EstadoIncidencia estado;
    private Equipo equipo;
    private Tecnico tecnicoAsignado;

    private List<Comentario> comentarios;
    private List<RegistroHistorial> historial;

    public Incidencia(int numIncidencia, String descripcion, Equipo equipo, Usuario usuario) {
        this.numIncidencia = numIncidencia;
        this.descripcion = descripcion;
        this.equipo = equipo;
        this.estado = EstadoIncidencia.PENDIENTE;

        this.comentarios = new ArrayList<>();
        this.historial = new ArrayList<>();

        registrarHistorial("Incidencia creada por " + usuario.getNombre());
    }

    public int getNumIncidencia() { return numIncidencia; }
    public String getDescripcion() { return descripcion; }
    public TipoIncidencia getTipo() { return tipo; }
    public Prioridad getPrioridad() { return prioridad; }
    public EstadoIncidencia getEstado() { return estado; }
    public Equipo getEquipo() { return equipo; }
    public Tecnico getTecnicoAsignado() { return tecnicoAsignado; }
    public List<Comentario> getComentarios() { return comentarios; }
    public List<RegistroHistorial> getHistorial() { return historial; }

    public void setTipo(TipoIncidencia tipo) {
        this.tipo = tipo;
        registrarHistorial("Tipo asignado: " + tipo);
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
        registrarHistorial("Prioridad asignada: " + prioridad);
    }

    public void asignarTecnico(Tecnico t) {
        this.tecnicoAsignado = t;
        registrarHistorial("Técnico asignado: " + t.getNombre());
    }

    public void cambiarEstado(EstadoIncidencia nuevo, String usuario) {
        this.estado = nuevo;
        registrarHistorial("Estado cambiado a " + nuevo + " por " + usuario);
    }

    public void agregarComentario(Comentario c) {
        comentarios.add(c);
        registrarHistorial("Comentario agregado por " + c.getUsuario());
    }

    private void registrarHistorial(String accion) {
        historial.add(new RegistroHistorial(accion, "Sistema"));
    }
}
