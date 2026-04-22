package com.example.tutoria03.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.tutoria03.models.Estudiante;
import com.example.tutoria03.repositories.IEstudianteRepository;

public class EstudianteService {
    
    // crear una instancia de repository
    @Autowired
    private IEstudianteRepository estudianteRepository;

    public ArrayList<Estudiante> GetAll(){
        return (ArrayList<Estudiante>) estudianteRepository.findAll();
    }

    
}
