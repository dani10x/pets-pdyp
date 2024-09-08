package com.example.pets.repository;

import com.example.pets.entity.MascotasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotasRepository extends JpaRepository<MascotasEntity, Integer> {
}
