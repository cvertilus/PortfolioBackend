package com.Portfolio.Porfolio_Backend.Security.DTO;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
@Data
public class JWTdto {
    private  String token;
    private  String bearer ="Bearer";
    private  String nombreUsuario;
    private Collection<?  extends GrantedAuthority> authorities;

    public JWTdto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }
}
