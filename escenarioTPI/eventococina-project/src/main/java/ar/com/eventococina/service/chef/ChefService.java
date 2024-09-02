package ar.com.eventococina.service.chef;

import java.util.List;

import ar.com.eventococina.domain.Chef;

public interface ChefService {
    Chef crearChef();

    List<Chef> getChefs();

    boolean noHayChefsDisponibles();
}
