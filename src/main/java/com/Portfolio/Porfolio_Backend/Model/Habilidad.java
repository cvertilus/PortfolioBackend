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
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lenguajedeProgramacion;
    private int porcentajeDeConocimiento;

    public Habilidad(String lenguajedeProgramacion, int porcentajeDeConocimiento) {
        this.lenguajedeProgramacion = lenguajedeProgramacion;
        this.porcentajeDeConocimiento = porcentajeDeConocimiento;
    }

    public Habilidad() {
    }
}
