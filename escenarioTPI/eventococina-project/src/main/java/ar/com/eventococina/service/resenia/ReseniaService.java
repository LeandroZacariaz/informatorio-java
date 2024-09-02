package ar.com.eventococina.service.resenia;
import java.util.UUID;
import ar.com.eventococina.domain.Resenia;

public interface ReseniaService {
    Resenia crearResenia(UUID idParticipante, UUID idEvento);
}
