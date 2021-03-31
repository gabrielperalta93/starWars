package com.StarWars.StarWars.repositories;

import com.StarWars.StarWars.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeRepository {
    public List<PersonajeDTO> findPersonajes(String name);
}
