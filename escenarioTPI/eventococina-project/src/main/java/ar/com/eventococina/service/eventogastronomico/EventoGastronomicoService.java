package ar.com.eventococina.service.eventogastronomico;

import java.util.List;
import java.util.UUID;
import ar.com.eventococina.domain.Chef;
import ar.com.eventococina.domain.EventoGastronomico;


public interface EventoGastronomicoService {

    EventoGastronomico crearEvento(List<Chef> chefs);
    void listarEventosFecha();
    List<EventoGastronomico> getEventos();
    EventoGastronomico getEventoById(UUID id_evento);
}
