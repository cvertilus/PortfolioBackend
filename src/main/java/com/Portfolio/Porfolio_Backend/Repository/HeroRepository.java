package com.Portfolio.Porfolio_Backend.Repository;

import com.Portfolio.Porfolio_Backend.Model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
}
