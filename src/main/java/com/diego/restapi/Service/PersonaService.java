package com.diego.restapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.restapi.Model.Persona;
import com.diego.restapi.Repository.PersonaRepository;

@Service
public class PersonaService {
    
    @Autowired
    PersonaRepository personaRepository;

    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public List<Persona> listarPersonas () {
        return personaRepository.findAll();
    }

    public PersonaDTO buscarPersona(Long id) {
        Persona persona = personaRepository.findById(id).get();
        return new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getEmail(), persona.getTrabajo());
    }

    public void actualizarPersona(Persona persona) {
        personaRepository.save(persona);
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
    
    public PersonaDTO login(String username, String password) {
        Persona persona = personaRepository.findByUsernameAndPassword(username, password);
        if (persona != null) {
            return new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getEmail(), persona.getTrabajo());
        }
        return null;
    }

    public List<PersonaDTO> buscarPorApellido(String apellido) {
        List<Persona> personas = personaRepository.findByApellido(apellido);
        List<PersonaDTO> personasDTO = new ArrayList<>();
        for (Persona persona : personas) {
            personasDTO.add(new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getEmail(), persona.getTrabajo()));
        }
        return personasDTO;
    }
}
