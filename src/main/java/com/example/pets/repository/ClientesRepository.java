package com.example.pets.repository;

import com.example.pets.dto.ClienteAutocompletable;
import com.example.pets.entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientesRepository extends JpaRepository<ClientesEntity, Integer> {

    Optional<ClientesEntity> findByCedula(String cedula);

    boolean existsByCedula(String cedula);

    @Query("select new com.example.pets.dto.ClienteAutocompletable(" +
            "c.id, c.nombres || ' ' || c.apellidos || ' | ' || c.cedula)" +
            "from ClientesEntity c ")
    List<ClienteAutocompletable> findAutocompletable();


}
