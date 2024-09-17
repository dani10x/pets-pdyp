package com.example.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pets.entity.TratamientosEntity;

public interface TratamientoRepository extends JpaRepository<TratamientosEntity, Integer> {
    
}
