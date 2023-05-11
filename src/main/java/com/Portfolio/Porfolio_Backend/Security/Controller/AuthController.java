package com.Portfolio.Porfolio_Backend.Security.Controller;

import com.Portfolio.Porfolio_Backend.Security.DTO.ErrorMensaje;
import com.Portfolio.Porfolio_Backend.Security.DTO.JWTdto;
import com.Portfolio.Porfolio_Backend.Security.DTO.LoginUsuario;
import com.Portfolio.Porfolio_Backend.Security.DTO.NuevoUsuario;
import com.Portfolio.Porfolio_Backend.Security.Enums.RolNombre;
import com.Portfolio.Porfolio_Backend.Security.JsonWebToken.JWTProvider;
import com.Portfolio.Porfolio_Backend.Security.Model.Rol;
import com.Portfolio.Porfolio_Backend.Security.Model.Usuario;
import com.Portfolio.Porfolio_Backend.Security.Service.RolService;
import com.Portfolio.Porfolio_Backend.Security.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JWTProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new ErrorMensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity<>(new ErrorMensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity<>(new ErrorMensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ADMIN).get());
        usuario.setRols(roles);
        usuarioService.guardarUsuario(usuario);
        return new ResponseEntity<>(new ErrorMensaje("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JWTdto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new ErrorMensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        String token = jwtProvider.generateToken(userDetails.getUsername());
        JWTdto jwtDto = new JWTdto(token, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }


}
