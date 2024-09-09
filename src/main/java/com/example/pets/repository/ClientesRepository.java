package com.example.pets.repository;

import com.example.pets.entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<ClientesEntity, Integer> {
}
