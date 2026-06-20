package com.example.tutoria03.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tutoria03.models.Docente;

@Repository
public interface IDocenteRepository extends CrudRepository<Docente, Integer> {
    Docente findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}
