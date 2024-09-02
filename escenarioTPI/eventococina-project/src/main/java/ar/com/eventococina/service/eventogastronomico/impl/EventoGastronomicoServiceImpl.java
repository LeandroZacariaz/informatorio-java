package ar.com.eventococina.service.eventogastronomico.impl;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import ar.com.eventococina.domain.Chef;
import ar.com.eventococina.domain.EventoGastronomico;
import ar.com.eventococina.domain.Participante;
import ar.com.eventococina.domain.Resenia;
import ar.com.eventococina.service.chef.ChefService;
import ar.com.eventococina.service.eventogastronomico.EventoGastronomicoService;

public class EventoGastronomicoServiceImpl implements EventoGastronomicoService{

    private List<EventoGastronomico> eventos = new ArrayList<>();
    private ChefService chefService;
    public EventoGastronomicoServiceImpl(ChefService chefService) {
        this.chefService = chefService;
    }

    
    public EventoGastronomicoServiceImpl() {
        this.eventos = new ArrayList<>();
    }


    @Override
    public EventoGastronomico crearEvento(List<Chef> chefs) {

        // metodo para asegurar que minimo haya un chef creado para ser asignado al evento, de lo contrario no se puede crear un evento
        if(chefService.noHayChefsDisponibles()){
            System.out.println("No hay chefs creados. Crea un chef para poder crear un evento.");
            return null;
        }
        
        //ingresando datos
        EventoGastronomico nuevoEvento = new EventoGastronomico();
        Scanner sc = new Scanner(System.in);

        nuevoEvento.setId_evento(UUID.randomUUID());

        System.out.println("Ingrese el nombre del evento: ");
        String nombre = sc.nextLine();
        sc.nextLine();
        nuevoEvento.setNombre(nombre);

        System.out.println("Ingrese una descripción del evento: ");
        String descripcion = sc.nextLine();
        sc.nextLine();
        nuevoEvento.setNombre(descripcion);

        System.out.println("Ingrese la hora del evento (Formato YYYY-MM-DD'T'HH:MM:SS -- Ejemplo: 2024-12-24T15:30:00)");
        LocalDateTime fecha_hora = LocalDateTime.parse(sc.nextLine());
        sc.nextLine();
        nuevoEvento.setFecha_hora(fecha_hora);

        System.out.println("Ingrese la ubicacion del evento: ");
        String ubicacion = sc.nextLine();
        sc.nextLine();
        nuevoEvento.setUbicacion(ubicacion);

        System.out.println("Ingrese la capacidad de participantes");
        int capacidad = sc.nextInt();
        sc.nextLine();
        nuevoEvento.setCapacidad(capacidad);
        
        System.out.println("Seleccione al chef a cargo del evento (Ingrese su ID): ");
        for (Chef chef : chefs) {
            System.out.println("\nID: " + chef.getId_chef() + " -- Nombre: " + chef.getNombre() + " -- Especialidad: " + chef.getEspecialidad());
        }

        String idChefInput = sc.nextLine();
        UUID idChef;
        try {
            idChef = UUID.fromString(idChefInput); //convertir a UUID
        } catch (IllegalArgumentException e) {
            System.out.println("El ID ingresado no es válido.");
            return null;
        }

        Chef chefSeleccionado = null;
        for (Chef chef : chefs) {
            if (chef.getId_chef().equals(idChef)) { //compara usando equals 
                chefSeleccionado = chef;
                break; 
            }
        }
        
        nuevoEvento.setChef(chefSeleccionado);

        eventos.add(nuevoEvento);
        System.out.println("Evento creado correctamente.");
        return nuevoEvento;
    }

    @Override
    public void listarEventosFecha() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la fecha y hora (Formato YYYY-MM-DD'T'HH:MM:SS): ");
        LocalDateTime fecha_hora = LocalDateTime.parse(sc.nextLine());
        sc.nextLine();

        System.out.println("Eventos a partir de " + fecha_hora + ": ");
        for (EventoGastronomico evento : eventos) {
            if (evento.getFecha_hora().isAfter(fecha_hora)) {
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println(evento.getNombre() + 
                                    " -- Ubicación: "+evento.getUbicacion() + 
                                    " -- Fecha y Hora: " + evento.getFecha_hora() + 
                                    " \nCHEF A CARGO: " + evento.getChef().getNombre() + " -- Especialidad: " + evento.getChef().getEspecialidad() +
                                    "\nPARTICIPANTES: ");
                for (Participante participante: evento.getParticipantes()){
                    System.out.println("\nID: " + participante.getId_participante() + 
                                        " -- Nombre: " + participante.getNombre() + 
                                        " -- Apellido: " + participante.getApellido());
                }
                System.out.println("RESEÑAS: ");
                for (Resenia resenia: evento.getResenias()){
                    System.out.println("\nParticipante: " + resenia.getParticipante().getNombre() + resenia.getParticipante().getApellido() +
                                        " -- Calificacion: " + resenia.getCalificacion() + 
                                        " -- Comentario " + resenia.getComentario());
                }
                System.out.println("--------------------------------------------------------------------------------");
            }
        }

    }

    @Override
    public List<EventoGastronomico> getEventos() {
        return eventos;
    }
    
    
}
