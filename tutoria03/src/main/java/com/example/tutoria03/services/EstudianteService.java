package com.example.tutoria03.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.example.tutoria03.models.Estudiante;
import com.example.tutoria03.models.EstudianteRequest;
import com.example.tutoria03.models.EstudianteResponse;
import com.example.tutoria03.repositories.IEstudianteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final IEstudianteRepository estudianteRepository;

    public List<EstudianteResponse> getAll() {
        return StreamSupport.stream(estudianteRepository.findAll().spliterator(), false)
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public EstudianteResponse getStudentById(int id) {
        return estudianteRepository.findById(id).map(this::toResponse).orElse(null);
    }

    public EstudianteResponse save(EstudianteRequest request) {
        if (existeCorreo(request.getCorreo())) return null;
        Estudiante estudiante = toEntity(request);
        return toResponse(estudianteRepository.save(estudiante));
    }

    public EstudianteResponse update(int id, EstudianteRequest request) {
        if (!existeEstudiante(id)) return null;
        Estudiante estudiante = toEntity(request);
        estudiante.setId(id);
        return toResponse(estudianteRepository.save(estudiante));
    }

    public boolean delete(int id) {
        if (!existeEstudiante(id)) return false;
        estudianteRepository.deleteById(id);
        return true;
    }

    private boolean existeEstudiante(int id) {
        return estudianteRepository.findById(id).isPresent();
    }

    private boolean existeCorreo(String correo) {
        return estudianteRepository.findByCorreo(correo) != null;
    }

    private Estudiante toEntity(EstudianteRequest request) {
        Estudiante e = new Estudiante();
        e.setNombres(request.getNombres());
        e.setCorreo(request.getCorreo());
        e.setNumeroTelefono(request.getNumeroTelefono());
        e.setCarrera(request.getCarrera());
        e.setDireccion(request.getDireccion());
        e.setSemestre(request.getSemestre());
        e.setActivo(request.isActivo());
        return e;
    }

    private EstudianteResponse toResponse(Estudiante e) {
        EstudianteResponse response = new EstudianteResponse();
        response.setId(e.getId());
        response.setNombres(e.getNombres());
        response.setCorreo(e.getCorreo());
        response.setNumeroTelefono(e.getNumeroTelefono());
        response.setCarrera(e.getCarrera());
        response.setDireccion(e.getDireccion());
        response.setSemestre(e.getSemestre());
        response.setActivo(e.isActivo());
        return response;
    }
}
