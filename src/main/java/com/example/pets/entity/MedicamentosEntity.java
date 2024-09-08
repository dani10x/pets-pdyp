package com.example.pets.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="medicamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentosEntity {
    
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="dosis")
    private String dosis;

    @Column(name="nombre")
    private String nombre;
}
