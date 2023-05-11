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
        this.setNombreInstitucion(nombreInstitucion);
        this.setNivelEstudio(nivelEstudio);
        this.setFechaInicio(fechaInicio);
        this.setFechaFinalizacion(fechaFinalizacion);
        this.setInstitucionUrl(institucion_url);
    }

    public Educacion() {
    }

	public String getNombreInstitucion() {
		return nombreInstitucion;
	}

	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}

	public String getNivelEstudio() {
		return nivelEstudio;
	}

	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getInstitucionUrl() {
		return institucionUrl;
	}

	public void setInstitucionUrl(String institucionUrl) {
		this.institucionUrl = institucionUrl;
	}
    
   
}
