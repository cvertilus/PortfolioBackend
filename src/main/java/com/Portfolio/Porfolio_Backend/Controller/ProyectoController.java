package com.Portfolio.Porfolio_Backend.Controller;

import com.Portfolio.Porfolio_Backend.Model.Proyecto;
import com.Portfolio.Porfolio_Backend.Servicio.ProyectoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin("http://localhost:4200")
public class ProyectoController {
    private final ProyectoServicio proyectoServicio;

    public ProyectoController(ProyectoServicio proyectoServicio) {
        this.proyectoServicio = proyectoServicio;
    }

    @GetMapping("")
    private ResponseEntity<List<Proyecto>> getProyecto(){
        return  new ResponseEntity<>(proyectoServicio.obtenerProyectos(), HttpStatus.OK);
    }

    @PostMapping("")
    private  ResponseEntity<Proyecto> postProyecto(@RequestBody @Validated Proyecto proyecto){
        return  new ResponseEntity<>(proyectoServicio.agregarProyecto(proyecto),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Proyecto> putProyecto(@RequestBody @Validated Proyecto proyecto, @PathVariable Long id){
        return  new ResponseEntity<>(proyectoServicio.editarProyecto(proyecto,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Proyecto> deleteProyecto(@PathVariable Long id){
        return new ResponseEntity<>(proyectoServicio.eliminarProyecto(id),HttpStatus.OK);
    }
}
