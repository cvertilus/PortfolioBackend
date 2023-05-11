package com.Portfolio.Porfolio_Backend.Repository;

import com.Portfolio.Porfolio_Backend.Model.Habilidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad,Long> {
}
