package com.Portfolio.Porfolio_Backend.Controller;

import com.Portfolio.Porfolio_Backend.Model.Educacion;
import com.Portfolio.Porfolio_Backend.Servicio.EducacionServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educacion")
@CrossOrigin("http://localhost:4200")
public class EducacionController {
    private  EducacionServicio educacionSercice ;

    public EducacionController(EducacionServicio educacionSercice) {
        this.educacionSercice = educacionSercice;
    }

    @GetMapping("")
    private ResponseEntity<List<Educacion>> getEducaciones(){
        return  new ResponseEntity<>(educacionSercice.obtenerEducaciones(), HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<Educacion> postEducacion(@RequestBody @Validated Educacion educacion){
        return  new ResponseEntity<>(educacionSercice.agregarEducacion(educacion),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Educacion> putEduacion(@RequestBody @Validated Educacion educacion, @PathVariable Long id){
        return  new ResponseEntity<>(educacionSercice.editarEducacion(educacion,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private  ResponseEntity<Educacion> deleteEducacion(@PathVariable Long id){
        return  new ResponseEntity<>(educacionSercice.eliminarEduacion(id),HttpStatus.OK);
    }

}
