package ar.com.eventococina.service.resenia.impl;
import java.util.UUID;
import java.util.Scanner;
import ar.com.eventococina.domain.EventoGastronomico;
import ar.com.eventococina.domain.Participante;
import ar.com.eventococina.domain.Resenia;
import ar.com.eventococina.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventococina.service.participante.ParticipanteService;
import ar.com.eventococina.service.resenia.ReseniaService;

public class ReseniaServiceImpl implements ReseniaService{
    private EventoGastronomicoService eventoGastronomicoService;
    private ParticipanteService participanteService;
    
    public ReseniaServiceImpl(EventoGastronomicoService eventoGastronomicoService, ParticipanteService participanteService) {
        this.eventoGastronomicoService = eventoGastronomicoService;
        this.participanteService=participanteService;
    }

    @Override
    public Resenia crearResenia(UUID idParticipante, UUID idEvento) {
        EventoGastronomico eventoGastronomicoSeleccionado = eventoGastronomicoService.getEventoById(idEvento);
        Participante participanteSeleccionado=participanteService.getParticipanteById(idParticipante);
        if (verificarInscripcion(idParticipante, idEvento)) {
            Resenia nuevaResenia = new Resenia();
            Scanner sc = new Scanner(System.in);
            int calificacion;

            // ingresando datos

            nuevaResenia.setId_resenia(UUID.randomUUID());
            nuevaResenia.setParticipante(participanteSeleccionado);
            nuevaResenia.setEvento(eventoGastronomicoSeleccionado);

            do {
                System.out.println("Ingrese la calificación del evento (1-5): ");
                calificacion = sc.nextInt();
                sc.nextLine();

            } while (calificacion < 1 || calificacion > 5);
            nuevaResenia.setCalificacion(calificacion);

            System.out.println("Ingrese el comentario: ");
            String comentario = sc.nextLine();
            sc.nextLine();
            nuevaResenia.setComentario(comentario);

            eventoGastronomicoSeleccionado.getResenias().add(nuevaResenia);

            System.out.println("Reseña añadida correctamente.");

            return nuevaResenia;
        }
        return null;
    }
    
    private boolean verificarInscripcion(UUID idParticipante, UUID idEvento){
        EventoGastronomico eventoGastronomicoSeleccionado = eventoGastronomicoService.getEventoById(idEvento);
        boolean inscrito = eventoGastronomicoSeleccionado.getParticipantes().stream()
                .anyMatch(participante -> participante.getId_participante().equals(idParticipante));

        if (!inscrito) {
            System.out.println("El participante NO está inscrito en el evento.");
        }

        return inscrito;
    }
}
