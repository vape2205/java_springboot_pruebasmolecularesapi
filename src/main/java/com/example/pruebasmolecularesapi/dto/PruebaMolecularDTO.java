package com.example.pruebasmolecularesapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PruebaMolecularDTO {
    public Long id;
    public String fechaCorte;
    public Long uuid;
    public String fechaMuestra;
    public short edad;
    public String sexo;
    public String institiutcion;
    public String ubigeoPaciente;
    public String departamentoPaciente;
    public String provinciaPaciente;
    public String distritoPaciente;
    public String departamentoMuestra;
    public String provinciaMuestra;
    public String distritoMuestra;
    public String tipoMuestra;
    public String resultado;
}
