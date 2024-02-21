package com.diego.restapi.Model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Basic
    String nombre;
    String apellido;
    String email;
    String trabajo;
    String username;
    String password;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String email, String trabajo, String username, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.trabajo = trabajo;
        this.username = username;
        this.password = password;
    }


}
