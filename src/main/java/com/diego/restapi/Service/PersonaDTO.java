package com.diego.restapi.Service;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PersonaDTO {
    Long id;
    String nombre;
    String apellido;
    String email;
    String trabajo;

    public PersonaDTO() {
    }

    public PersonaDTO(Long id, String nombre, String apellido, String email, String trabajo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.trabajo = trabajo;
    }
}
