package ar.com.eventococina.service.chef;

import java.util.List;
import java.util.UUID;

import ar.com.eventococina.domain.Chef;

public interface ChefService {
    Chef crearChef();

    List<Chef> getChefs();

    boolean noHayChefsDisponibles();

    Chef getChefById(UUID id_chef);
    
    Chef seleccionarChef(List <Chef> chefs);
}
