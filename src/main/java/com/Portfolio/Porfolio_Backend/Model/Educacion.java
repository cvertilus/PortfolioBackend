package com.Portfolio.Porfolio_Backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter @Setter @ToString
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreInstitucion;
    private String nivelEstudio;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;

    private String institucionUrl;

    public Educacion(String nombreInstitucion, String nivelEstudio, Date fechaInicio, Date fechaFinalizacion, String institucion_url) {
        this.nombreInstitucion = nombreInstitucion;
        this.nivelEstudio = nivelEstudio;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.institucionUrl = institucion_url;
    }

    public Educacion() {
    }
}
