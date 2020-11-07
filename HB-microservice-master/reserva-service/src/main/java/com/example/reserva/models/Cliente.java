package com.example.reserva.models;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Cliente {
    private Long id;
    private String nombres;
    private String apellidos;
    private String numeroDocumento;
    private String celular;
    private String direccion;
    private String correo;
}
