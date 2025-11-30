package sistema;

import modelo.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaTicketing {

    private List<Incidencia> incidencias;
    private List<Tecnico> tecnicos;
    private List<Equipo> equipos;

    private int contadorIncidencias = 1;

    public SistemaTicketing() {
        incidencias = new ArrayList<>();
        tecnicos = new ArrayList<>();
        equipos = new ArrayList<>();
    }

    public void registrarEquipo(Equipo e) {
        equipos.add(e);
    }

    public void registrarTecnico(Tecnico t) {
        tecnicos.add(t);
    }

    public Incidencia registrarIncidencia(String descripcion, int idEquipo, Usuario u) {
        Equipo equipo = buscarEquipo(idEquipo);

        if (equipo == null) {
            System.out.println("Equipo no encontrado.");
            return null;
        }

        Incidencia inc = new Incidencia(contadorIncidencias++, descripcion, equipo, u);
        incidencias.add(inc);
        return inc;
    }

    public Equipo buscarEquipo(int id) {
        return equipos.stream()
                .filter(e -> e.getNumEquipo() == id)
                .findFirst()
                .orElse(null);
    }

    public Tecnico buscarTecnico(int id) {
        return tecnicos.stream()
                .filter(t -> t.getNumUsuario() == id)
                .findFirst()
                .orElse(null);
    }

    public Incidencia buscarIncidencia(int id) {
        return incidencias.stream()
                .filter(i -> i.getNumIncidencia() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Incidencia> getIncidencias() {
        return incidencias;
    }
}
