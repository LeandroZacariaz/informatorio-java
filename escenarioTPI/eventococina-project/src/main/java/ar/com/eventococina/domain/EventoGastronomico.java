package ar.com.eventococina.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventoGastronomico {
    private UUID id_evento;
    private String nombre;
    private String descripcion;
    private LocalDateTime fecha_hora;
    private String ubicacion;
    private int capacidad;
    private Chef chef;
    private List<Participante> participantes = new ArrayList();
    private List<Resenia> resenias = new ArrayList();


    public EventoGastronomico(UUID id_evento, String nombre, String descripcion, LocalDateTime fecha_hora,
            String ubicacion, int capacidad) {
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_hora = fecha_hora;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    public EventoGastronomico(){}

    //getters & setters 
    public UUID getId_evento() {
        return id_evento;
    }
    public void setId_evento(UUID id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }
    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Chef getChef() {
        return chef;
    }
    public void setChef(Chef chef) {
        this.chef = chef;
    }
    
    public List<Resenia> getResenias() {
        return resenias;
    }
    public void setResenias(List<Resenia> resenias) {
        this.resenias = resenias;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
    

    
}
