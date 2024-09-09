package com.info.info_primera_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("aplicacion/v1/despedida")
    public String goodByeWorld(){
        return "Adios mundo";
    }

    @GetMapping("aplicacion/v1/saludo")
    public String helloWorld(@RequestParam(required = true, name = "nombre") String nombre){
        return "Hola " + nombre;
    }
}
