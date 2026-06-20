package com.example.tutoria03.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.example.tutoria03.exceptions.DocenteNotFoundException;
import com.example.tutoria03.exceptions.DocumentoDuplicadoException;
import com.example.tutoria03.models.Docente;
import com.example.tutoria03.models.DocenteRequest;
import com.example.tutoria03.models.DocenteResponse;
import com.example.tutoria03.repositories.IDocenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocenteService {

    private final IDocenteRepository docenteRepository;

    public List<DocenteResponse> getAll() {
        return StreamSupport.stream(docenteRepository.findAll().spliterator(), false)
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public DocenteResponse save(DocenteRequest request) {
        if (existeDocumento(request.getTipoDocumento(), request.getNumeroDocumento())) {
            throw new DocumentoDuplicadoException(request.getTipoDocumento(), request.getNumeroDocumento());
        }
        return toResponse(docenteRepository.save(toEntity(request)));
    }

    public DocenteResponse update(int id, DocenteRequest request) {
        if (!docenteRepository.existsById(id)) {
            throw new DocenteNotFoundException(id);
        }
        Docente docente = toEntity(request);
        docente.setId(id);
        return toResponse(docenteRepository.save(docente));
    }

    public void delete(int id) {
        if (!docenteRepository.existsById(id)) {
            throw new DocenteNotFoundException(id);
        }
        docenteRepository.deleteById(id);
    }

    private boolean existeDocumento(String tipoDocumento, String numeroDocumento) {
        return docenteRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento) != null;
    }

    private Docente toEntity(DocenteRequest request) {
        Docente d = new Docente();
        d.setTipoDocumento(request.getTipoDocumento());
        d.setNumeroDocumento(request.getNumeroDocumento());
        d.setNombres(request.getNombres());
        d.setApellidos(request.getApellidos());
        d.setCorreo(request.getCorreo());
        d.setTelefono(request.getTelefono());
        d.setEspecialidad(request.getEspecialidad());
        return d;
    }

    private DocenteResponse toResponse(Docente d) {
        DocenteResponse response = new DocenteResponse();
        response.setId(d.getId());
        response.setTipoDocumento(d.getTipoDocumento());
        response.setNumeroDocumento(d.getNumeroDocumento());
        response.setNombres(d.getNombres());
        response.setApellidos(d.getApellidos());
        response.setCorreo(d.getCorreo());
        response.setTelefono(d.getTelefono());
        response.setEspecialidad(d.getEspecialidad());
        return response;
    }
}
