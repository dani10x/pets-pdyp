package com.example.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pets.entity.MedicamentosEntity;

public interface MedicamentosRepository extends JpaRepository<MedicamentosEntity, Integer> {

}
