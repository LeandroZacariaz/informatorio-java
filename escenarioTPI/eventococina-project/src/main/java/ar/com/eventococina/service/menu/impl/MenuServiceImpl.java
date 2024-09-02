package ar.com.eventococina.service.menu.impl;

import ar.com.eventococina.domain.EventoGastronomico;
import ar.com.eventococina.domain.Participante;
import ar.com.eventococina.service.archivos.ArchivosEventosService;
import ar.com.eventococina.service.chef.ChefService;
import ar.com.eventococina.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventococina.service.menu.MenuService;
import ar.com.eventococina.service.participante.ParticipanteService;
import ar.com.eventococina.service.resenia.ReseniaService;

import java.util.Scanner;
import java.util.UUID;

public class MenuServiceImpl implements MenuService{
    
    private final EventoGastronomicoService eventoGastronomicoService;
    private final ChefService chefService;
    private final ParticipanteService participanteService;
    private final ReseniaService reseniaService;
    private final ArchivosEventosService archivosEventosService;

    public MenuServiceImpl(EventoGastronomicoService eventoGastronomicoService, ChefService chefService,
            ParticipanteService participanteService, ReseniaService reseniaService, ArchivosEventosService archivosEventosService) {
        this.eventoGastronomicoService = eventoGastronomicoService;
        this.chefService = chefService;
        this.participanteService = participanteService;
        this.reseniaService = reseniaService;
        this.archivosEventosService = archivosEventosService;
    }

    @Override
    public void mostrarMenu(Scanner scanner) {
        int rol;

        do {
            System.out.println("\n");
            System.out.println("╔══════════════════════════════════════════════════════╗");
            System.out.println("║       Gestión de Eventos de Cocina y Gastronomía     ║");
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Ingresar a la sección de Eventos y Chefs          ║");
            System.out.println("║ 2. Ingresar a la sección de participantes            ║");
            System.out.println("║ 3. Salir                                             ║");
            System.out.println("╚══════════════════════════════════════════════════════╝");
            rol = scanner.nextInt();
            scanner.nextLine();

            switch (rol){
                case 1:
                    mostrarMenuEventos(scanner);
                    break;
                case 2:
                    mostrarMenuParticipante(scanner);
                    break;
                case 3:
                    System.out.println("\n Aplicacion finalizada");
                    break;
                default:
                    break;
            }

        }while (rol != 3);
    }

    @Override
    public void mostrarMenuEventos(Scanner scanner) {
        boolean volver = false;
        int opcion;
        do {
            System.out.println("╔═══════════════════════════════════════════════════════╗");
            System.out.println("║                   Eventos ║ Chefs                     ║");
            System.out.println("╠═══════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Crear Evento                                       ║");
            System.out.println("║ 2. Crear Chef                                         ║");
            System.out.println("║ 3. Listar Eventos disponibles a partir de una fecha   ║");
            System.out.println("║ 4. Exportar Eventos llenos                            ║");
            System.out.println("║ 5. Volver                                             ║");
            System.out.println("╚═══════════════════════════════════════════════════════╝");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    eventoGastronomicoService.crearEvento(chefService.getChefs());
                    break;
                case 2:
                    chefService.crearChef();
                    break;
                case 3:
                    eventoGastronomicoService.listarEventosFecha();
                    break;
                case 4:
                    archivosEventosService.exportarCursosCsv(eventoGastronomicoService.getEventos());
                    break;
                case 5:
                    System.out.println("\n Volviendo al menú anterior.");
                    volver = true;
                    break;
                default:
                    break;
            }

        }while (!volver);
        
    }
     
    @Override
    public void mostrarMenuParticipante(Scanner scanner) {
        boolean volver = false;
        int opcion;
        do {
            System.out.println("╔═══════════════════════════════════════════════════════╗");
            System.out.println("║                   Participantes                       ║");
            System.out.println("╠═══════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Registrar Participante                             ║");
            System.out.println("║ 2. Inscribir participante a evento                    ║");
            System.out.println("║ 3. Dejar reseña del participante                      ║");
            System.out.println("║ 4. Volver                                             ║");
            System.out.println("╚═══════════════════════════════════════════════════════╝");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    participanteService.registrarParticipante();
                    break;
                case 2:
                    //agarro el id del participante
                    System.out.println("Seleccionar Participante (Ingrese el ID): ");
                    for (Participante participante : participanteService.getParticipantes()) {
                        System.out.println("\nID: " + participante.getId_participante() + " -- Nombre y Apellido: " + participante.getNombre() + "," + participante.getApellido());
                    }
                    String idParticipanteInput = scanner.nextLine();
                    scanner.nextLine();
                    UUID idParticipante = UUID.fromString(idParticipanteInput);
                    //agarro id del evento
                    System.out.println("Seleccionar Evento (Ingrese el ID): ");
                    for (EventoGastronomico eventos: eventoGastronomicoService.getEventos()){
                        System.out.println("\nID: " + eventos.getId_evento() + " -- Nombre: " +eventos.getNombre() + " -- Fecha: " + eventos.getFecha_hora());
                    }
                    String idEventoInput = scanner.nextLine();
                    scanner.nextLine();
                    UUID idEvento = UUID.fromString(idEventoInput);
                    
                    participanteService.inscribirParticipante(idParticipante, idEvento);
                    break;
                case 3:
                    //agarro el id del participante
                    System.out.println("Seleccionar Participante (Ingrese el ID): ");
                    for (Participante participante : participanteService.getParticipantes()) {
                        System.out.println("\nID: " + participante.getId_participante() + " -- Nombre y Apellido: " + participante.getNombre() + "," + participante.getApellido());
                    }
                    String idParticipanteInputResenia = scanner.nextLine();
                    UUID idParticipanteResenia = UUID.fromString(idParticipanteInputResenia);
                    scanner.nextLine();
                    //agarro id del evento
                    System.out.println("Seleccionar Evento (Ingrese el ID): ");
                    for (EventoGastronomico eventos: eventoGastronomicoService.getEventos()){
                        System.out.println("\nID: " + eventos.getId_evento() + " -- Nombre: " +eventos.getNombre() + " -- Fecha: " + eventos.getFecha_hora());
                    }
                    String idEventoInputResenia = scanner.nextLine();
                    scanner.nextLine();
                    UUID idEventoResenia = UUID.fromString(idEventoInputResenia);
                    reseniaService.crearResenia(idParticipanteResenia, idEventoResenia);
                    break;
                case 4:
                    System.out.println("\n Volviendo al menú anterior.");
                    volver = true;
                    break;
                default:
                    break;
            }

        }while (!volver);
    }
    
    
}
