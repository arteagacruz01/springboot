package com.mac.Proyecto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {
@GetMapping({"/saludo/{name}", "/amor/{name}" })
    public String greeting(@PathVariable String name){

        return "hola " + name;
    }

}
