package com.Portfolio.Porfolio_Backend.Security.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class NuevoUsuario {
    @NotBlank
    private String nombre;
    @NotBlank
    private String nombreUsuario;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank
    private String password;

    private Set<String> roles = new HashSet<>();

    public NuevoUsuario(String nombre, String nombreUsuario, String email, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public NuevoUsuario(String nombre, String nombreUsuario, String email, String password, Set<String> roles) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public NuevoUsuario() {
    }
}
