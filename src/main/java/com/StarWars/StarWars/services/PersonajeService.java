package com.StarWars.StarWars.services;

import com.StarWars.StarWars.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeService {
    public List<PersonajeDTO> obtenerPersonajes(String nombre);
}
