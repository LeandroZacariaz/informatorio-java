package ar.com.eventococina.service.chef.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.NoSuchElementException;

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

    @Override
    public Chef seleccionarChef(List <Chef> chefs){
        Scanner sc = new Scanner(System.in);
        Chef chefSeleccionado=null;
        listarChefs();

        while (chefSeleccionado==null) {
            System.out.println("Ingrese el ID del chef: ");
            String idChefInput = sc.nextLine();
            sc.nextLine();
            UUID idChef = null;
            try {
                idChef = UUID.fromString(idChefInput); // convertir a UUID
            } catch (IllegalArgumentException e) {
                System.out.println("El formato del ID ingresado no es válido.");
                continue;
            }

            try {
                chefSeleccionado=getChefById(idChef);
            } catch (NoSuchElementException e) {
                System.out.println("No se encontró ningún chef con el ID ingresado.");
            }
            
        }

        return chefSeleccionado;
    }

    private void listarChefs(){
        System.out.println("Lista de Chefs: ");
        for (Chef chef : chefs) {
            System.out.println("\nID: " + chef.getId_chef() + " -- Nombre: " + chef.getNombre() + " -- Especialidad: " + chef.getEspecialidad());
        }
    }

    @Override
    public Chef getChefById(UUID id_chef){
        for (Chef chef : chefs) { 
            if (chef.getId_chef().equals(id_chef)) {
                return chef;
            }
        }
        throw new NoSuchElementException("Chef con ID: " + id_chef + " no encontrado.");
    }
    
}
