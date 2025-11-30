import sistema.SistemaTicketing;
import modelo.*;
import enums.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaTicketing sistema = new SistemaTicketing();

        // Equipos 
        sistema.registrarEquipo(new Equipo(1, "Lab Lis", "PC 01"));
        sistema.registrarEquipo(new Equipo(2, "Lab Lis", "PC 02"));

        // Técnicos 
        sistema.registrarTecnico(new Tecnico(1, "Carlos", "Hardware"));
        sistema.registrarTecnico(new Tecnico(2, "Enrique", "Software"));
        sistema.registrarTecnico(new Tecnico(3, "Emilio", "Redes"));

        int opcion;

        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Registrar incidencia");
            System.out.println("2. Clasificar incidencia");
            System.out.println("3. Asignar técnico");
            System.out.println("4. Cambiar estado");
            System.out.println("5. Ver historial");
            System.out.println("6. Salir");
            System.out.print("Escriba una de las opciones del menu: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {
                    System.out.print("Numero de Equipo: ");
                    int idEq = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();

                    UsuarioLaboratorio user = new UsuarioLaboratorio(40, "Usuario");

                    Incidencia nueva = sistema.registrarIncidencia(desc, idEq, user);

                    if (nueva != null)
                        System.out.println("Incidencia creada con numero: " + nueva.getNumIncidencia());
                }

                case 2 -> {
                    System.out.print("Numero de incidencia: ");
                    int idInc = sc.nextInt();

                    Incidencia inc = sistema.buscarIncidencia(idInc);

                    if (inc != null) {
                        System.out.println("Tipo (1.Hardware 2.Software 3.Red): ");
                        int t = sc.nextInt();
                        inc.setTipo(TipoIncidencia.values()[t - 1]);

                        System.out.println("Prioridad (1.Baja 2.Media 3.Alta 4.Crítica):");
                        int p = sc.nextInt();
                        inc.setPrioridad(Prioridad.values()[p - 1]);
                    }
                }

                case 3 -> {
                    System.out.print("Numero de Incidencia: ");
                    int idInc3 = sc.nextInt();

                    Incidencia inc3 = sistema.buscarIncidencia(idInc3);

                    if (inc3 != null) {
                        System.out.print("Numero de técnico: ");
                        int idTec = sc.nextInt();

                        Tecnico tec = sistema.buscarTecnico(idTec);

                        if (tec != null) {
                            inc3.asignarTecnico(tec);
                            System.out.println("Técnico asignado.");
                        }
                    }
                }

                case 4 -> {
                    System.out.print("Numero de Incidencia: ");
                    int idInc4 = sc.nextInt();

                    Incidencia inc4 = sistema.buscarIncidencia(idInc4);

                    if (inc4 != null) {
                        System.out.println("Estado (1.Pendiente 2.En progreso 3.Terminada):");
                        int e = sc.nextInt();

                        inc4.cambiarEstado(EstadoIncidencia.values()[e - 1], "Técnico");
                    }
                }

                case 5 -> {
                    System.out.print("Numero de incidencia: ");
                    int id5 = sc.nextInt();

                    Incidencia inc5 = sistema.buscarIncidencia(id5);

                    if (inc5 != null) {
                        inc5.getHistorial()
                                .forEach(h -> System.out.println(h.getFecha() + " - " + h.getAccion()));
                    }
                }

                case 6 -> System.out.println("Hasta pronto :)");

            }

        } while (opcion != 0);

        sc.close();
    }
}
