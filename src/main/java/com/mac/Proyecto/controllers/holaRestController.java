package com.mac.Proyecto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class holaRestController {

    @GetMapping({"/hola", "/adios"})
    public String hola(){

        System.out.println("Solicitud");
        return "hola";
    }
}
