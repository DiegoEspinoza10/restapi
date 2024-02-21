package com.diego.restapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diego.restapi.Model.Persona;
import com.diego.restapi.Service.PersonaDTO;
import com.diego.restapi.Service.PersonaService;

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/persona")
    @ResponseBody
    public List<Persona> listarPersonas() {
        return personaService.listarPersonas();
    }

    @PostMapping("/persona")
    @ResponseBody
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.crearPersona(persona);
    }

    @GetMapping("/persona/{id}")
    @ResponseBody
    public PersonaDTO buscarPersona(@PathVariable Long id) {
        return personaService.buscarPersona(id);
    }

    @DeleteMapping("/persona/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
    }

    @PutMapping("/persona")
    public void actualizarPersona(@RequestBody Persona persona) {
        personaService.actualizarPersona(persona);
    }

    @PostMapping("/login")
    public PersonaDTO login(@RequestBody Persona persona) {
        return personaService.login(persona.getUsername(), persona.getPassword());
    }

    @GetMapping("/persona/apellido/{apellido}")
    public List<PersonaDTO> buscarPorApellido(@PathVariable String apellido) {
        return personaService.buscarPorApellido(apellido);
    }
}
