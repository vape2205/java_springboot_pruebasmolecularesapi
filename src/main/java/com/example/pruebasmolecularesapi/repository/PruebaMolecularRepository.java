package com.example.pruebasmolecularesapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebasmolecularesapi.model.PruebaMolecular;

@Repository
public interface PruebaMolecularRepository extends JpaRepository<PruebaMolecular, Long> {

    List<PruebaMolecular> findByDepartamentoMuestra(String departamento, Pageable pageable);
}
