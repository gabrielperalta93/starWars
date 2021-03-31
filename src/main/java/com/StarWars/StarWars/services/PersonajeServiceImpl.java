package com.StarWars.StarWars.services;

import com.StarWars.StarWars.dto.PersonajeDTO;
import com.StarWars.StarWars.repositories.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService{
    private final PersonajeRepository personajeRepository;

    public PersonajeServiceImpl(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> obtenerPersonajes(String nombre) {
        List<PersonajeDTO> personajes = personajeRepository.findPersonajes(nombre);
        return null;
    }
}
