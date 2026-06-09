package com.example.tutoria03.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutoria03.models.EstudianteRequest;
import com.example.tutoria03.models.EstudianteResponse;
import com.example.tutoria03.services.EstudianteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<List<EstudianteResponse>> getAll() {
        return ResponseEntity.ok(estudianteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponse> getStudentById(@PathVariable("id") int id) {
        return ResponseEntity.ok(estudianteService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<EstudianteResponse> save(@RequestBody EstudianteRequest request) {
        return ResponseEntity.ok(estudianteService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResponse> update(@PathVariable("id") int id, @RequestBody EstudianteRequest request) {
        EstudianteResponse updated = estudianteService.update(id, request);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(estudianteService.delete(id));
    }
}
