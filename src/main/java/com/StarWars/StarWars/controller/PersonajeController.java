package com.StarWars.StarWars.controller;

import com.StarWars.StarWars.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @PostMapping("/obtenerPersonajes")
    public ResponseEntity obtenerCalorias(@RequestBody String nombre){
        return new ResponseEntity(personajeService.obtenerPersonajes(nombre), HttpStatus.OK);
    }
}
