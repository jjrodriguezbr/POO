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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
@Tag(name = "Estudiantes", description = "Operaciones relacionadas con la gestión de estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Operation(summary = "Listar todos los estudiantes", description = "Retorna la lista completa de todos los estudiantes registrados en el sistema.")
    @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente")
    @GetMapping
    public ResponseEntity<List<EstudianteResponse>> getAll() {
        return ResponseEntity.ok(estudianteService.getAll());
    }

    @Operation(summary = "Buscar estudiante por ID", description = "Retorna un único estudiante según el ID proporcionado.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Estudiante encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponse> getStudentById(
            @Parameter(description = "ID del estudiante a buscar") @PathVariable("id") int id) {
        return ResponseEntity.ok(estudianteService.getStudentById(id));
    }

    @Operation(summary = "Registrar nuevo estudiante", description = "Crea y guarda un nuevo estudiante en el sistema con los datos proporcionados.")
    @ApiResponse(responseCode = "200", description = "Estudiante creado exitosamente")
    @PostMapping
    public ResponseEntity<EstudianteResponse> save(@RequestBody EstudianteRequest request) {
        return ResponseEntity.ok(estudianteService.save(request));
    }

    @Operation(summary = "Actualizar estudiante", description = "Actualiza los datos de un estudiante existente según su ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Estudiante actualizado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResponse> update(
            @Parameter(description = "ID del estudiante a actualizar") @PathVariable("id") int id,
            @RequestBody EstudianteRequest request) {
        EstudianteResponse updated = estudianteService.update(id, request);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Eliminar estudiante", description = "Elimina permanentemente un estudiante del sistema según su ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Estudiante eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID del estudiante a eliminar") @PathVariable("id") int id) {
        return ResponseEntity.ok(estudianteService.delete(id));
    }
}
