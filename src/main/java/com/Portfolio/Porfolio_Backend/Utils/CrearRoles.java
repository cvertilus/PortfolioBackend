/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.Porfolio_Backend.Utils;

import com.Portfolio.Porfolio_Backend.Security.Enums.RolNombre;
import com.Portfolio.Porfolio_Backend.Security.Model.Rol;
import com.Portfolio.Porfolio_Backend.Security.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author colby
 */
//para crear los roles , si tendremos una nueva base de datos , hay que descomentar el component 
//@Component
public class CrearRoles implements CommandLineRunner{
    @Autowired
    RolService rolservice;
    


    @Override
    public void run(String... args) throws Exception {
        Rol admin = new Rol(RolNombre.ADMIN);
        Rol user = new Rol(RolNombre.USER);
        rolservice.guardarRol(user);
        rolservice.guardarRol(admin);
        
    }
       
    
}
