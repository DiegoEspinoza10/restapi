package com.diego.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diego.restapi.Model.Persona;
import java.util.List;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

    Persona findByUsernameAndPassword(String username, String password);
    List <Persona> findByApellido(String apellido);
} 
