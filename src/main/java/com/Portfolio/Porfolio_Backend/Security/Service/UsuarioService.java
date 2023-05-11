package com.Portfolio.Porfolio_Backend.Security.Service;

import com.Portfolio.Porfolio_Backend.Security.Model.Usuario;
import com.Portfolio.Porfolio_Backend.Security.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public  Boolean existByNombreUsuario(String nomrbreUsuario){
        return  usuarioRepository.existsByNombreUsuario(nomrbreUsuario);
    }

    public  Boolean existByEmail(String email){
        return  usuarioRepository.existsByEmail(email);
    }

    public void guardarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }



}
