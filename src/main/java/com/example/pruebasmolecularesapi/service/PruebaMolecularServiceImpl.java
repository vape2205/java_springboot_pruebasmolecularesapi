package com.example.pruebasmolecularesapi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.pruebasmolecularesapi.dto.PruebaMolecularCSVModel;
import com.example.pruebasmolecularesapi.dto.PruebaMolecularDTO;
import com.example.pruebasmolecularesapi.exception.ResourceNotFoundException;
import com.example.pruebasmolecularesapi.helpers.CSVHelper;
import com.example.pruebasmolecularesapi.mapper.PruebaMolecularMapper;
import com.example.pruebasmolecularesapi.model.PruebaMolecular;
import com.example.pruebasmolecularesapi.repository.PruebaMolecularRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PruebaMolecularServiceImpl implements PruebaMolecularService {
@Autowired
    private PruebaMolecularRepository pruebaMolecularRepository;

    @Autowired
    private PruebaMolecularMapper pruebaMapper;

    @Override
    public List<PruebaMolecularDTO> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        var list = pruebaMolecularRepository.findAll(pageable).toList();
        return pruebaMapper.toDTOList(list);
    }

    @Override
    public PruebaMolecularDTO getById(Long id) {
        PruebaMolecular prueba = pruebaMolecularRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prueba molecular no encontrado con id: " + id));
        return pruebaMapper.toDTO(prueba);
    }

    @Override
    public PruebaMolecularDTO create(PruebaMolecularDTO dto) {
        PruebaMolecular prueba = pruebaMapper.toEntity(dto);
        PruebaMolecular savedPrueba = pruebaMolecularRepository.save(prueba);
        return pruebaMapper.toDTO(savedPrueba);
    }

    @Override
    public PruebaMolecularDTO update(Long id, PruebaMolecularDTO dto) {
        PruebaMolecular existingPrueba = pruebaMolecularRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prueba molecular no encontrado con id: " + id));

        PruebaMolecular updatedPrueba = pruebaMolecularRepository.save(existingPrueba);
        return pruebaMapper.toDTO(updatedPrueba);
    }

    @Override
    public void delete(Long id) {
        PruebaMolecular prueba = pruebaMolecularRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prueba molecular no encontrado con id: " + id));
                pruebaMolecularRepository.delete(prueba);
    }

    @Override
    public void save(MultipartFile file) {
        try {
            List<PruebaMolecularCSVModel> listDtos = CSVHelper.loadObjectList(PruebaMolecularCSVModel.class, file.getInputStream());
            var entities = pruebaMapper.toListEntities(listDtos);
            pruebaMolecularRepository.saveAll(entities);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    @Override
    public List<PruebaMolecularDTO> findByDepartamentoMuestra(String departamento, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        var list = pruebaMolecularRepository.findByDepartamentoMuestra(departamento, pageable);
        return pruebaMapper.toDTOList(list);
    }
}
