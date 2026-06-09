package com.example.tutoria03.models;

import lombok.Data;

@Data
public class EstudianteResponse {
    private int id;
    private String nombres;
    private String correo;
    private String numeroTelefono;
    private String carrera;
    private String direccion;
    private String semestre;
    private boolean activo;
}
