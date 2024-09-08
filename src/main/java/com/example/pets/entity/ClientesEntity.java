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
@Table(name="clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientesEntity {
    
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="cedula")
    private String cedula;

    @Column(name="nombres")
    private String nombres;

    @Column(name="apellidos")
    private String apellidos;

    @Column(name="direccion")
    private String direccion;

    @Column(name="telefono")
    private String telefono;

}
