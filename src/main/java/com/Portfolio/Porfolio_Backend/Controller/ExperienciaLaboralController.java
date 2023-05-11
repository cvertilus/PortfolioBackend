package com.Portfolio.Porfolio_Backend.Controller;

import com.Portfolio.Porfolio_Backend.Model.ExperienciaLaboral;
import com.Portfolio.Porfolio_Backend.Servicio.ExperienciaLaboralServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin("http://localhost:4200")
public class ExperienciaLaboralController {
    private final ExperienciaLaboralServicio experienciaLaboralServicio;

    public ExperienciaLaboralController(ExperienciaLaboralServicio experienciaLaboralServicio) {
        this.experienciaLaboralServicio = experienciaLaboralServicio;
    }

    @GetMapping("")
    private ResponseEntity<List<ExperienciaLaboral>> getExperienciaLaboral(){
        return  new ResponseEntity<>(experienciaLaboralServicio.obtenerExperienciaLaboral(),
                HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<ExperienciaLaboral> postExperienciaLaboral(@RequestBody @Validated ExperienciaLaboral experienciaLaboral){
        return  new ResponseEntity<>(experienciaLaboralServicio.agregarExperienciaLaboral(experienciaLaboral),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private  ResponseEntity<ExperienciaLaboral> putExperienciaLaboral(@RequestBody @Validated ExperienciaLaboral experienciaLaboral,@PathVariable Long id){
        return  new ResponseEntity<>(experienciaLaboralServicio.editarExperienciaLaboral(experienciaLaboral,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ExperienciaLaboral> deleteExperienciaLaboral(@PathVariable Long id){
        return  new ResponseEntity<>(experienciaLaboralServicio.eliminarExperienciaLaborarl(id),HttpStatus.OK);
    }
}
