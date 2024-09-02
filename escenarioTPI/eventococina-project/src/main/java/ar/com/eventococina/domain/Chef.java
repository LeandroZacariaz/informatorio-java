package ar.com.eventococina.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Chef {
    private UUID id_chef;
    private String nombre;
    private String especialidad;
    private List<EventoGastronomico> eventos = new ArrayList();


    public Chef(UUID id_chef, String nombre, String especialidad) {
        this.id_chef = id_chef;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public Chef(){}
    
    //getters & setters 
    public UUID getId_chef() {
        return id_chef;
    }
    public void setId_chef(UUID id_chef) {
        this.id_chef = id_chef;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public List<EventoGastronomico> getEventos() {
        return eventos;
    }
    public void setEventos(List<EventoGastronomico> eventos) {
        this.eventos = eventos;
    }
    
}
