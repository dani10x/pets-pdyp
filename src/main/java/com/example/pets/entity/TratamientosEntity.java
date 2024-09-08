package com.example.pets.entity;

import java.time.LocalDateTime;

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
@Table(name="tratamientos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TratamientosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tratamientos_seq")
    @SequenceGenerator(name = "tratamientos_seq", sequenceName = "tratamientos_seq", allocationSize = 1)
    @Column(name="id")
    private Integer id;

    @Column(name="fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name="medicamentos_id")
    private Integer medicamentosId;

    @Column(name="mascotas_id")
    private Integer mascotasId;


}
