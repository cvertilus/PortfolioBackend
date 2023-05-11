package com.Portfolio.Porfolio_Backend.Repository;

import com.Portfolio.Porfolio_Backend.Model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepeository extends JpaRepository<Educacion,Long> {
}
