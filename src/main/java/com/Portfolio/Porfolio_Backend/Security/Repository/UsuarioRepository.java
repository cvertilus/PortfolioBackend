package com.Portfolio.Porfolio_Backend.Security.Repository;

import com.Portfolio.Porfolio_Backend.Security.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {
    Optional<Usuario>findByNombreUsuario(String nombreUsuario);
    Boolean existsByNombreUsuario(String nombreUsuario);
    Boolean existsByEmail(String email);
}
