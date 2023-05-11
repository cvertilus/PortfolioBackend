package com.Portfolio.Porfolio_Backend.Repository;

import com.Portfolio.Porfolio_Backend.Model.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral,Long> {
}
