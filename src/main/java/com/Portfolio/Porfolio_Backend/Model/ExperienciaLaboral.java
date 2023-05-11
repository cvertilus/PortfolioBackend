package com.Portfolio.Porfolio_Backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter @Setter @ToString
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nombreEstablecimiento;
    private String puestoTrabajo;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    private  String direccion;

    public ExperienciaLaboral(String nombreEstablecimiento, String puestoTrabajo, Date fechaInicio, Date fechaFinal, String direccion) {
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.puestoTrabajo = puestoTrabajo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.direccion = direccion;
    }

    public ExperienciaLaboral() {
    }
}
