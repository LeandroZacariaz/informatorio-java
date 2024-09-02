package ar.com.eventococina.domain;

import java.util.UUID;

public class Resenia {
    private UUID id_resenia;
    private EventoGastronomico evento;
    private Participante participante;
    private Integer calificacion;
    private String comentario;


    //getters & setters 
    public UUID getId_resenia() {
        return id_resenia;
    }
    public void setId_resenia(UUID id_resenia) {
        this.id_resenia = id_resenia;
    }

    public EventoGastronomico getEvento() {
        return evento;
    }
    public void setEvento(EventoGastronomico evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    
    public Integer getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
