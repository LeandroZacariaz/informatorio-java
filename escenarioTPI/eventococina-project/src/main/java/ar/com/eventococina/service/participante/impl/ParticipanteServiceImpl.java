package ar.com.eventococina.service.participante.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.NoSuchElementException;

import ar.com.eventococina.domain.EventoGastronomico;
import ar.com.eventococina.domain.Participante;
import ar.com.eventococina.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventococina.service.participante.ParticipanteService;

public class ParticipanteServiceImpl implements ParticipanteService{
    private List<Participante> participantes = new ArrayList<>();
    //private ParticipanteService participanteService;
    private EventoGastronomicoService eventoGastronomicoService;

    public ParticipanteServiceImpl(EventoGastronomicoService eventoGastronomicoService) {
        this.eventoGastronomicoService = eventoGastronomicoService;
    }


    @Override
    public Participante registrarParticipante() {
        Participante nuevoParticipante = new Participante();
        Scanner sc = new Scanner(System.in);

        //ingresando datos
        nuevoParticipante.setId_participante(UUID.randomUUID());

        System.out.println("Ingrese el nombre del participante: ");
        String nombre = sc.nextLine();
        sc.nextLine();
        nuevoParticipante.setNombre(nombre);

        System.out.println("Ingrese el apellido del participante: ");
        String apellido = sc.nextLine();
        sc.nextLine();
        nuevoParticipante.setApellido(apellido);

        List<String> interesesCulinarios = new ArrayList<>();
        System.out.println("Ingrese los intereses culinarios del participante (Escriba fin para finalizar): ");
        while (true) {
            String intereses = sc.nextLine();
            if (intereses.equalsIgnoreCase("fin")){
                break;
            }

            interesesCulinarios.add(intereses);
        }
        nuevoParticipante.setIntereses_culinarios(interesesCulinarios);

        participantes.add(nuevoParticipante);
        System.out.println("Participante creado correctamente.");
        return nuevoParticipante;
    }


    @Override
    public void inscribirParticipante(UUID idParticipante, UUID idEvento) {
        Participante participanteSeleccionado = null;
        EventoGastronomico eventoGastronomicoSeleccionado = null;
        boolean existeParticipante = Boolean.FALSE;
        boolean existeEvento = Boolean.FALSE;

        for (EventoGastronomico eventoGastronomico: eventoGastronomicoService.getEventos()){
            if(eventoGastronomico.getId_evento().equals(idEvento)){
                eventoGastronomicoSeleccionado = eventoGastronomico;
                existeEvento=Boolean.TRUE;
                break;
            }
        }
        if (!existeEvento) {
            throw new NoSuchElementException ("No existe el evento.");
        }

        for (Participante participante: this.getParticipantes()){
            if (participante.getId_participante().equals(idParticipante)){
                participanteSeleccionado = participante;
                existeParticipante = Boolean.TRUE;
                break;
            }
        }
        if (!existeParticipante) {
            throw new NoSuchElementException ("No existe el participante.");
        }

        if (eventoGastronomicoSeleccionado.getParticipantes().size() >= eventoGastronomicoSeleccionado.getCapacidad()) {
            throw new IllegalStateException("El evento con ID: " + idEvento + " ya esta lleno.");
        }

        if (existeParticipante&&existeEvento){
            eventoGastronomicoSeleccionado.getParticipantes().add(participanteSeleccionado);
            participanteSeleccionado.getHistorial_eventos().add(eventoGastronomicoSeleccionado);
            System.out.println("Participante añadido correctamente.");
        } else{
            System.out.println("No se pudo inscribir el participante.");
        }
        

        
    }

    @Override
    public List<Participante> getParticipantes() {
        return participantes;
    }

    
    
}
