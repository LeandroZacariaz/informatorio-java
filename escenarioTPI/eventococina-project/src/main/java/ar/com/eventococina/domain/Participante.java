package ar.com.eventococina.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Participante {
    private UUID id_participante;
    private String nombre;
    private String apellido;
    private List<String> intereses_culinarios = new ArrayList(); 
    private List<EventoGastronomico> historial_eventos = new ArrayList();

    
    public Participante(UUID id_participante, String nombre, String apellido, List<String> intereses_culinarios) {
        this.id_participante = id_participante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.intereses_culinarios = intereses_culinarios;
    }

    public Participante(){}


    //getters & setters 
    public UUID getId_participante() {
        return id_participante;
    }
    public void setId_participante(UUID id_participante) {
        this.id_participante = id_participante;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getIntereses_culinarios() {
        return intereses_culinarios;
    }
    public void setIntereses_culinarios(List<String> intereses_culinarios) {
        this.intereses_culinarios = intereses_culinarios;
    }
    
    public List<EventoGastronomico> getHistorial_eventos() {
        return historial_eventos;
    }
    public void setHistorial_eventos(List<EventoGastronomico> historial_eventos) {
        this.historial_eventos = historial_eventos;
    }

    
}
