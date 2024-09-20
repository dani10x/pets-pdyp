package com.example.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pets.entity.TratamientosEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TratamientoRepository extends JpaRepository<TratamientosEntity, Integer> {
    @Query("select t from TratamientosEntity t where t.mascotasEntity.id = ?1")
    List<TratamientosEntity> findByMascotasEntity_Id(Integer id);

}
