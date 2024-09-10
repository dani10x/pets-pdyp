package com.example.pets.repository;

import com.example.pets.entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<ClientesEntity, Integer> {

    Optional<ClientesEntity> findByCedula(String cedula);

    boolean existsByCedula(String cedula);
}
