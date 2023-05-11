package com.Portfolio.Porfolio_Backend.Security.Service;

import com.Portfolio.Porfolio_Backend.Security.Enums.RolNombre;
import com.Portfolio.Porfolio_Backend.Security.Model.Rol;
import com.Portfolio.Porfolio_Backend.Security.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
    public  void guardarRol(Rol rol){
        rolRepository.save(rol);
    }
}
