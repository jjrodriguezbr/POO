package com.example.tutoria03.exceptions;

public class DocenteNotFoundException extends RuntimeException {
    public DocenteNotFoundException(int id) {
        super("No existe un docente con ID: " + id);
    }
}
