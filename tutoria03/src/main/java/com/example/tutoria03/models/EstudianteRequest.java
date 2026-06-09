package com.example.tutoria03.models;

import lombok.Data;

@Data
public class EstudianteRequest {
    private String nombres;
    private String correo;
    private String numeroTelefono;
    private String carrera;
    private String direccion;
    private String semestre;
    private boolean activo;
}
