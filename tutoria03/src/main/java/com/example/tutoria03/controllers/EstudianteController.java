package com.example.tutoria03.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutoria03.models.Estudiante;
import com.example.tutoria03.services.EstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    
    @Autowired
    private EstudianteService estudianteService;
    
    @GetMapping
    public ResponseEntity<ArrayList<Estudiante>> getAll(){
        return ResponseEntity.ok(estudianteService.GetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getStudentById(@PathVariable("id") int id) {
        return ResponseEntity.ok(estudianteService.GetStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante estudiante){
        return ResponseEntity.ok(estudianteService.save(estudiante) );
    }

    @PutMapping
    public ResponseEntity<Estudiante> update(@RequestBody Estudiante estudiante){
        return ResponseEntity.ok(estudianteService.update(estudiante) );
    }

}
