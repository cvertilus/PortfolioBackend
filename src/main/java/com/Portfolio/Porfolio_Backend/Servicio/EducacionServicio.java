package com.Portfolio.Porfolio_Backend.Servicio;

import com.Portfolio.Porfolio_Backend.Model.Educacion;
import com.Portfolio.Porfolio_Backend.Repository.EducacionRepeository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionServicio {
    private final EducacionRepeository educacionRepeository;

    public EducacionServicio(EducacionRepeository educacionRepeository) {
        this.educacionRepeository = educacionRepeository;
    }

    public List<Educacion> obtenerEducaciones(){
        return  educacionRepeository.findAll();
    }

    public Educacion agregarEducacion(Educacion educacion){
        return  educacionRepeository.save(educacion);
    }

    public Educacion editarEducacion(Educacion educacion, Long id) {
        Educacion educacion1 = educacionRepeository.findById(id).orElse(null);
        if (educacion1 == null) return educacion1;

        educacion1.setFechaFinalizacion(educacion.getFechaFinalizacion());
        educacion1.setFechaInicio(educacion.getFechaInicio());
        educacion1.setNivelEstudio(educacion.getNivelEstudio());
        educacion1.setInstitucionUrl(educacion.getInstitucionUrl());
        educacion1.setNombreInstitucion(educacion.getNombreInstitucion());
        return this.agregarEducacion(educacion1);
    }

    public Educacion eliminarEduacion(Long id){
        Educacion educacion = educacionRepeository.findById(id).orElse(null);
        if(educacion != null) {
            educacionRepeository.delete(educacion);
        }
        return  educacion;
    }


}
