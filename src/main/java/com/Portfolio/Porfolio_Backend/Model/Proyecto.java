package com.Portfolio.Porfolio_Backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String github_url;
    private String lenguajeDeProgramaciion;
    private String img_src;
    private  String descripcion;

    public Proyecto(String nombre, String github_url, String lenguajeDeProgramaciion, String img_src, String descripcion) {
        this.nombre = nombre;
        this.github_url = github_url;
        this.lenguajeDeProgramaciion = lenguajeDeProgramaciion;
        this.img_src = img_src;
        this.descripcion = descripcion;
    }

    public Proyecto() {
    }
}
