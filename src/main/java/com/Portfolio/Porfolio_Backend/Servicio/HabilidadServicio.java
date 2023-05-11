package com.Portfolio.Porfolio_Backend.Servicio;
import com.Portfolio.Porfolio_Backend.Model.Habilidad;
import com.Portfolio.Porfolio_Backend.Repository.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HabilidadServicio {
    @Autowired
    private HabilidadRepository habilidadRepository;

    public List<Habilidad> obtenerHabilidades(){
        return  habilidadRepository.findAll();
    }

    public Habilidad agregarHabilidad(Habilidad habilidad){
        return  habilidadRepository.save(habilidad);
    }

    public Habilidad editarHabilidad(Habilidad habilidad , Long id) {
        Habilidad habilidad1 = habilidadRepository.findById(id).orElse(null);
        if (habilidad1 == null) return null;
        habilidad1.setLenguajedeProgramacion(habilidad.getLenguajedeProgramacion());
        habilidad1.setPorcentajeDeConocimiento(habilidad.getPorcentajeDeConocimiento());
        return this.agregarHabilidad(habilidad1);
    }
    public Habilidad eliminarHabiliad(Long id){
        Habilidad habilidad = habilidadRepository.findById(id).orElse(null);
        if (habilidad != null){
           habilidadRepository.deleteById(id);
       }
        return  habilidad;
    }

}
