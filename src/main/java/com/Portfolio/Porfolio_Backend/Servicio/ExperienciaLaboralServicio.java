package com.Portfolio.Porfolio_Backend.Servicio;

import com.Portfolio.Porfolio_Backend.Model.ExperienciaLaboral;
import com.Portfolio.Porfolio_Backend.Repository.ExperienciaLaboralRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaLaboralServicio {

    private ExperienciaLaboralRepository experienciaLaboralRepository;

    public ExperienciaLaboralServicio(ExperienciaLaboralRepository experienciaLaboralRepository) {
        this.experienciaLaboralRepository = experienciaLaboralRepository;
    }


    /**
     * @return una lista de las experiencias laborales que tenemos guardados en la base de datos
     */
    public List<ExperienciaLaboral> obtenerExperienciaLaboral() {
        return experienciaLaboralRepository.findAll();
    }

    public ExperienciaLaboral agregarExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
        return experienciaLaboralRepository.save(experienciaLaboral);
    }

    public ExperienciaLaboral editarExperienciaLaboral(ExperienciaLaboral experienciaLaboral, Long id) {
        ExperienciaLaboral experienciaLaboral1 = experienciaLaboralRepository.findById(id).orElse(null);
        if (experienciaLaboral1 == null) return null;
        experienciaLaboral1.setDireccion(experienciaLaboral.getDireccion());
        experienciaLaboral1.setFechaFinal(experienciaLaboral.getFechaFinal());
        experienciaLaboral1.setFechaInicio(experienciaLaboral.getFechaInicio());
        experienciaLaboral1.setPuestoTrabajo(experienciaLaboral.getPuestoTrabajo());
        experienciaLaboral1.setNombreEstablecimiento(experienciaLaboral.getNombreEstablecimiento());
        return this.agregarExperienciaLaboral(experienciaLaboral1);
    }

    public ExperienciaLaboral eliminarExperienciaLaborarl(Long id) {
       ExperienciaLaboral experienciaLaboral = experienciaLaboralRepository.findById(id).orElse(null);

        if (experienciaLaboral != null) {
            experienciaLaboralRepository.delete(experienciaLaboral);
        }

        return experienciaLaboral;
    }
}
