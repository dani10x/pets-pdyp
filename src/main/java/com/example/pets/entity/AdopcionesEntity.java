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
@Table(name="adopciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdopcionesEntity {
    
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="cliente_id")
    private Integer clienteId;

    @Column(name="mascotas_id")
    private Integer mascotasId;    
}
