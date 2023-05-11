package com.Portfolio.Porfolio_Backend.Servicio;

import com.Portfolio.Porfolio_Backend.Model.Hero;
import com.Portfolio.Porfolio_Backend.Repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServicio {
    private  final HeroRepository heroRepository;

    public HeroServicio(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> obtenerHero(){
        return  heroRepository.findAll();
    }

    public Hero editarHero(Hero hero , Long id){
        Hero hero1 = heroRepository.findById(id).orElse(null);
        if (hero1 == null) return  hero1;

        hero1.setAbout_me(hero.getAbout_me());
        hero1.setApellido(hero.getApellido());
        hero1.setNombre(hero.getNombre());
        hero1.setImg_src(hero.getImg_src());

        return  this.agregarHero(hero1);
    }

    public Hero agregarHero(Hero hero1) {
         return  heroRepository.save(hero1);
    }


}
