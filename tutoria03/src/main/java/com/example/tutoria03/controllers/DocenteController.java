package com.example.tutoria03.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutoria03.models.DocenteRequest;
import com.example.tutoria03.models.DocenteResponse;
import com.example.tutoria03.services.DocenteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/docentes")
@RequiredArgsConstructor
@Tag(name = "Docentes", description = "Operaciones relacionadas con la gestión de docentes")
public class DocenteController {

    private final DocenteService docenteService;

    @Operation(summary = "Listar todos los docentes", description = "Retorna la lista completa de todos los docentes registrados en el sistema.")
    @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente")
    @GetMapping
    public ResponseEntity<List<DocenteResponse>> getAll() {
        return ResponseEntity.ok(docenteService.getAll());
    }

    @Operation(summary = "Registrar nuevo docente", description = "Crea un nuevo docente. No se permite duplicar la combinación de tipoDocumento y numeroDocumento.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Docente creado exitosamente"),
        @ApiResponse(responseCode = "409", description = "Ya existe un docente con ese tipo y número de documento")
    })
    @PostMapping
    public ResponseEntity<DocenteResponse> save(@RequestBody DocenteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.save(request));
    }

    @Operation(summary = "Actualizar docente", description = "Actualiza los datos de un docente existente según su ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Docente actualizado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<DocenteResponse> update(
            @Parameter(description = "ID del docente a actualizar") @PathVariable("id") int id,
            @RequestBody DocenteRequest request) {
        return ResponseEntity.ok(docenteService.update(id, request));
    }

    @Operation(summary = "Eliminar docente", description = "Elimina un docente del sistema según su ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Docente eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID del docente a eliminar") @PathVariable("id") int id) {
        docenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
