package com.StarWars.StarWars.repositories;

import com.StarWars.StarWars.dto.PersonajeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository{
    private final List<PersonajeDTO> database;

    public PersonajeRepositoryImpl(List<PersonajeDTO> database) {
        this.database = loadDataBase();
    }

    @Override
    public List<PersonajeDTO> findPersonajes(String name) {
        return database.stream()
                .filter(personajeDTO -> matchWith(name, personajeDTO))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, PersonajeDTO characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }

    private List<PersonajeDTO> loadDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> typeReference = new TypeReference<List<PersonajeDTO>>() {};
        List<PersonajeDTO> personajes = null;

        try {
            personajes = objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personajes;
    }
}
