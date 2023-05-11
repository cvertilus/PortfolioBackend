package com.Portfolio.Porfolio_Backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Hero {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String apellido;
    @Column(columnDefinition = "longtext")
    private String img_src;
    @Column(columnDefinition = "longtext")
    private  String about_me;

    public Hero(String nombre, String apellido, String img_src, String about_me) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img_src = img_src;
        this.about_me = about_me;
    }

    public Hero() {
    }
}
