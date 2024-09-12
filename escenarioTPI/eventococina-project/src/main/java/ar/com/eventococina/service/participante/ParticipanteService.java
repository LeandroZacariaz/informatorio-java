package ar.com.eventococina.service.participante;

import java.util.List;
import java.util.UUID;

import ar.com.eventococina.domain.Participante;

public interface ParticipanteService {
    Participante registrarParticipante();

    void inscribirParticipante(UUID idParticipante, UUID idEvento);

    List<Participante> getParticipantes();

    Participante getParticipanteById(UUID id_participante);
}
