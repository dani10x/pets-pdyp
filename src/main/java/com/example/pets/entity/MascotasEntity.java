package com.example.pets.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "mascotas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MascotasEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "raza")
    private String raza;

    @Column(name = "peso")
    private Float peso;

    @Column(name = "fechanacimiento")
    private LocalDateTime fechaNacimiento;
}
