package ar.com.eventococina.service.resenia.impl;
import java.util.UUID;
import java.util.Scanner;
import ar.com.eventococina.domain.EventoGastronomico;
import ar.com.eventococina.domain.Participante;
import ar.com.eventococina.domain.Resenia;
import ar.com.eventococina.service.eventogastronomico.EventoGastronomicoService;
import ar.com.eventococina.service.resenia.ReseniaService;

public class ReseniaServiceImpl implements ReseniaService{
    private EventoGastronomicoService eventoGastronomicoService;
    
    public ReseniaServiceImpl(EventoGastronomicoService eventoGastronomicoService) {
        this.eventoGastronomicoService = eventoGastronomicoService;
    }

    @Override
    public Resenia crearResenia(UUID idParticipante, UUID idEvento) {
        Participante participanteSeleccionado = null;
        EventoGastronomico eventoGastronomicoSeleccionado = null;
        boolean existeParticipante = Boolean.FALSE;

        for (EventoGastronomico eventoGastronomico : eventoGastronomicoService.getEventos()) {
            if (eventoGastronomico.getId_evento().equals(idEvento)) {
                //encuentro al evento
                eventoGastronomicoSeleccionado = eventoGastronomico;
                for (Participante participante : eventoGastronomico.getParticipantes()) {
                    if (participante.getId_participante().equals(idParticipante)) {
                        //encuentro al participante
                        participanteSeleccionado=participante;
                        existeParticipante = Boolean.TRUE;
                    }
                }
            }
        }

        if (existeParticipante){
            
            Resenia nuevaResenia = new Resenia();
            Scanner sc = new Scanner(System.in);
            int calificacion;

            //ingresando datos

            nuevaResenia.setId_resenia(UUID.randomUUID());
            nuevaResenia.setParticipante(participanteSeleccionado);
            nuevaResenia.setEvento(eventoGastronomicoSeleccionado);

            do {
                System.out.println("Ingrese la calificación del evento (1-5): ");
                calificacion = sc.nextInt();
                sc.nextLine();

            }while (calificacion <1 || calificacion > 5);
            nuevaResenia.setCalificacion(calificacion);

            
            System.out.println("Ingrese el comentario: ");
            String comentario = sc.nextLine();
            sc.nextLine();
            nuevaResenia.setComentario(comentario);
            
            eventoGastronomicoSeleccionado.getResenias().add(nuevaResenia);
            
            System.out.println("Reseña añadida correctamente.");
            
        } else{
            System.out.println("No se pudo agregar la reseña.");
        }
        return null;
    }
    
}
