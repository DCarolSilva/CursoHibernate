package com.examenDaniela.examen.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Vehiculo_Daniela_Silva")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "color")
    private String color;
    @Column(name = "transmision")
    private String transmision;
    @Column(name = "anio")
    private Integer anio;
}
