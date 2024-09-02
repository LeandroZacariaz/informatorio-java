package ar.com.eventococina.service.chef.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import ar.com.eventococina.domain.Chef;
import ar.com.eventococina.service.chef.ChefService;

public class ChefServiceImpl implements ChefService{
    private List<Chef> chefs = new ArrayList<>();

    @Override
    public Chef crearChef() {
        Chef nuevoChef = new Chef(); 
        Scanner sc = new Scanner(System.in);

        //ingresando datos del chef
        nuevoChef.setId_chef(UUID.randomUUID());

        System.out.println("Ingrese el nombre del Chef: ");
        String nombre = sc.nextLine();
        sc.nextLine();
        nuevoChef.setNombre(nombre);

        System.out.println("Ingrese la especialidad del chef: ");
        String especialidad  = sc.nextLine();
        sc.nextLine();
        nuevoChef.setEspecialidad(especialidad);

        chefs.add(nuevoChef);
        System.out.println("Chef creado correctamente.");
        return nuevoChef;
    }

    @Override
    public List<Chef> getChefs() {
        return chefs;
    }

    @Override
    public boolean noHayChefsDisponibles() {
        return chefs.isEmpty();
    }
}
