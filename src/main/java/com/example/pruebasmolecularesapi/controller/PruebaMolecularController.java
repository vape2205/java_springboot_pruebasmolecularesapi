package com.example.pruebasmolecularesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pruebasmolecularesapi.dto.PruebaMolecularDTO;
import com.example.pruebasmolecularesapi.helpers.CSVHelper;
import com.example.pruebasmolecularesapi.service.PruebaMolecularService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/pruebas-moleculares")
@RequiredArgsConstructor
public class PruebaMolecularController {

    @Autowired
    private PruebaMolecularService pruebaMolecularService;

    @PostMapping
    public ResponseEntity<PruebaMolecularDTO> crear(@RequestBody PruebaMolecularDTO request){
        var creado = pruebaMolecularService.create(request);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PruebaMolecularDTO> obtenerPorId(@PathVariable Long id) {
        var prueba = pruebaMolecularService.getById(id);
        return ResponseEntity.ok(prueba);
    }

    @GetMapping
    public ResponseEntity<List<PruebaMolecularDTO>> obtenerTodos(@RequestParam(name = "page",defaultValue = "0") Integer page,
    @RequestParam(name = "size",defaultValue = "20") Integer size) {
        var lista = pruebaMolecularService.getAll(page, size);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/departamento-muestra/{departamento}")
    public ResponseEntity<List<PruebaMolecularDTO>> buscarPorDepartamentoMuestra(@PathVariable String departamento,
        @RequestParam(name = "page",defaultValue = "0") Integer page,
        @RequestParam(name = "size",defaultValue = "20") Integer size) {
        var lista = pruebaMolecularService.findByDepartamentoMuestra(departamento, page,size);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PruebaMolecularDTO> actualizar(
            @PathVariable Long id,
            @RequestBody PruebaMolecularDTO request){
        var actualizado = pruebaMolecularService.update(id, request);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        pruebaMolecularService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (!CSVHelper.hasCSVFormat(file)) {
            message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        } 

        try {
            pruebaMolecularService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
}
