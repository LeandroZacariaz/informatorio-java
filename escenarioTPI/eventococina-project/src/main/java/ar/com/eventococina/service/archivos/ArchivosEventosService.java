package ar.com.eventococina.service.archivos;
import java.util.List;
import ar.com.eventococina.domain.EventoGastronomico;

public interface ArchivosEventosService {
    void exportarCursosCsv(List<EventoGastronomico> eventos);

    void cerrarWriter();
}
