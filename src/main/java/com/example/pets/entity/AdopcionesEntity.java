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
@Table(name="adopciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdopcionesEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adopciones_seq")
    @SequenceGenerator(name = "adopciones_seq", sequenceName = "adopciones_seq", allocationSize = 1)
    @Column(name="id")
    private Integer id;

    @Column(name="cliente_id")
    private Integer clienteId;

    @Column(name="mascotas_id")
    private Integer mascotasId;    
}
