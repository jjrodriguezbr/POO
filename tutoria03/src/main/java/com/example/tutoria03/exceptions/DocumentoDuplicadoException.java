package com.example.tutoria03.exceptions;

public class DocumentoDuplicadoException extends RuntimeException {
    public DocumentoDuplicadoException(String tipoDocumento, String numeroDocumento) {
        super("Ya existe un docente con " + tipoDocumento + " N° " + numeroDocumento);
    }
}
