package com.example.pets.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicamentos_seq")
    @SequenceGenerator(name = "medicamentos_seq", sequenceName = "medicamentos_seq", allocationSize = 1)
    @Column(name="id")
    private Integer id;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="dosis")
    private String dosis;

    @Column(name="nombre")
    private String nombre;
}
