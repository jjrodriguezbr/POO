package com.example.tutoria03.models;

import lombok.Data;

@Data
public class DocenteRequest {
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String especialidad;
}
