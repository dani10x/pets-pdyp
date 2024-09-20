package com.example.pets.repository;

import com.example.pets.entity.MascotasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MascotasRepository extends JpaRepository<MascotasEntity, Integer> {

    @Query("select m from MascotasEntity m where m.ClienteEntity.id = ?1")
    List<MascotasEntity> findByClienteEntity_Id(Integer id);

}
