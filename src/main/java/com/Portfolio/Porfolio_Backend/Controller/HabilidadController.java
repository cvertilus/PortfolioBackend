package com.Portfolio.Porfolio_Backend.Controller;

import com.Portfolio.Porfolio_Backend.Model.Habilidad;
import com.Portfolio.Porfolio_Backend.Servicio.HabilidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidad")
@CrossOrigin("http://localhost:4200")
public class HabilidadController {
    HabilidadServicio habilidadServicio;
    public HabilidadController(HabilidadServicio habilidadServicio) {
        this.habilidadServicio = habilidadServicio;
    }

    @GetMapping("")
    private ResponseEntity<List<Habilidad>> getHabilidad(){
        return  new ResponseEntity<>(habilidadServicio.obtenerHabilidades(), HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<Habilidad> posthablidad(@RequestBody @Validated Habilidad habilidad){
        return  new ResponseEntity<>(habilidadServicio.agregarHabilidad(habilidad),HttpStatus.OK);
    }



    @PutMapping("/{id}")
    private ResponseEntity<Habilidad> putHabilidad(@RequestBody @Validated Habilidad habilidad,@PathVariable Long id){
        return  new ResponseEntity<>(habilidadServicio.editarHabilidad(habilidad,id),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    private ResponseEntity<Habilidad> deleteHabilidad(@PathVariable Long id){
        return  new ResponseEntity<>(habilidadServicio.eliminarHabiliad(id),HttpStatus.OK);
    }
}
