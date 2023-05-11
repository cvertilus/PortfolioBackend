package com.Portfolio.Porfolio_Backend.Servicio;

import com.Portfolio.Porfolio_Backend.Model.Proyecto;
import com.Portfolio.Porfolio_Backend.Repository.ProyectoRepeositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServicio {
    @Autowired
    private ProyectoRepeositoy proyectoRepeositoy;

    public List<Proyecto> obtenerProyectos(){
        return  proyectoRepeositoy.findAll();
    }

    public Proyecto agregarProyecto(Proyecto proyecto){
        return  proyectoRepeositoy.save(proyecto);
    }

    public Proyecto editarProyecto(Proyecto proyecto,Long id){
        Proyecto proyecto1 = proyectoRepeositoy.findById(id).orElse(null);
        if(proyecto1 == null) return null;
        proyecto1.setNombre(proyecto.getNombre());
        proyecto1.setDescripcion(proyecto.getDescripcion());
        proyecto1.setGithub_url(proyecto.getGithub_url());
        proyecto1.setImg_src(proyecto.getImg_src());
        proyecto1.setLenguajeDeProgramaciion(proyecto.getLenguajeDeProgramaciion());
        return  this.agregarProyecto(proyecto1);
    }

    public Proyecto eliminarProyecto(Long id){
        Proyecto proyecto = proyectoRepeositoy.findById(id).orElse(null);
        if(proyecto != null) proyectoRepeositoy.deleteById(id);
        return proyecto;
    }

}
