package com.example.pruebasmolecularesapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.pruebasmolecularesapi.dto.PruebaMolecularDTO;

public interface PruebaMolecularService {
    List<PruebaMolecularDTO> getAll(Integer page, Integer size);
    PruebaMolecularDTO getById(Long id);
    PruebaMolecularDTO create(PruebaMolecularDTO dto);
    PruebaMolecularDTO update(Long id, PruebaMolecularDTO dto);
    void delete(Long id);
    void save(MultipartFile file);
    // List<PruebaMolecularDTO> findByDistritoMuestra(String distrito);
    // List<PruebaMolecularDTO> findByDistritoPaciente(String distrito);
    // List<PruebaMolecularDTO> findByProvinciaMuestra(String distrito);
    // List<PruebaMolecularDTO> findByProvinciaPaciente(String distrito);
    List<PruebaMolecularDTO> findByDepartamentoMuestra(String departamento, Integer page, Integer size);
    // List<PruebaMolecularDTO> findByDepartamentoPaciente(String distrito);
    // List<PruebaMolecularDTO> findBySexo(String sexo);
    // List<PruebaMolecularDTO> findByEdad(String edad);
}
