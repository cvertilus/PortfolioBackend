package com.Portfolio.Porfolio_Backend.Security.Service;

import com.Portfolio.Porfolio_Backend.Security.Model.Usuario;
import com.Portfolio.Porfolio_Backend.Security.Model.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService  implements UserDetailsService {
    @Autowired
    private  UsuarioService usuarioService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario= usuarioService.getByNombreUsuario(username).get();
        return UsuarioPrincipal.build(usuario);
    }


}
