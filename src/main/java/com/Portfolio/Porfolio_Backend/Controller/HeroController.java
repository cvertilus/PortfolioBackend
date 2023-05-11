package com.Portfolio.Porfolio_Backend.Controller;

import com.Portfolio.Porfolio_Backend.Model.Hero;
import com.Portfolio.Porfolio_Backend.Servicio.HeroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hero")
@CrossOrigin("http://localhost:4200")
public class HeroController {
    @Autowired
    private  HeroServicio heroServicio;



    @GetMapping("")
    private ResponseEntity<List<Hero>> getHero(){
        return  new ResponseEntity<>(heroServicio.obtenerHero(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private  ResponseEntity<Hero> putHero(@RequestBody @Validated Hero hero , @PathVariable Long id){
        return new ResponseEntity<>(heroServicio.editarHero(hero,id),HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<Hero> postHero(@RequestBody @Validated Hero hero){
        return  new ResponseEntity<>(heroServicio.agregarHero(hero),HttpStatus.OK);
    }
}
