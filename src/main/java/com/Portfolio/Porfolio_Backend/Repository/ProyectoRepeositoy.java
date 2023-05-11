package com.Portfolio.Porfolio_Backend.Repository;

import com.Portfolio.Porfolio_Backend.Model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepeositoy extends JpaRepository<Proyecto,Long> {
}
