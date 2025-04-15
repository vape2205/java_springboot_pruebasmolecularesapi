package com.example.pruebasmolecularesapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.pruebasmolecularesapi.dto.PruebaMolecularCSVModel;
import com.example.pruebasmolecularesapi.dto.PruebaMolecularDTO;
import com.example.pruebasmolecularesapi.model.PruebaMolecular;

@Mapper(componentModel = "spring")
public interface PruebaMolecularMapper {

    PruebaMolecularMapper INSTANCE = Mappers.getMapper(PruebaMolecularMapper.class);

    PruebaMolecular toEntity(PruebaMolecularDTO dto);

    PruebaMolecularDTO toDTO(PruebaMolecular domain);

    List<PruebaMolecularDTO> toDTOList(List<PruebaMolecular> list);

    @Mapping(target = "fechaCorte", source = "FECHA_CORTE")
    @Mapping(target = "fechaMuestra", source = "FECHA_MUESTRA")
    @Mapping(target = "departamentoPaciente", source = "DEPARTAMENTO_PACIENTE")
    @Mapping(target = "provinciaPaciente", source = "PROVINCIA_PACIENTE")
    @Mapping(target = "distritoPaciente", source = "DISTRITO_PACIENTE")
    @Mapping(target = "departamentoMuestra", source = "DEPARTAMENTO_MUESTRA")
    @Mapping(target = "provinciaMuestra", source = "PROVINCIA_MUESTRA")
    @Mapping(target = "distritoMuestra", source = "DISTRITO_MUESTRA")
    @Mapping(target = "tipoMuestra", source = "TIPO_MUESTRA")
    @Mapping(target = "ubigeoPaciente", source = "UBIGEO_PACIENTE")
    @Mapping(target = "edad", source = "EDAD")
    @Mapping(target = "uuid", source = "UUID")
    @Mapping(target = "institiutcion", source = "INSTITIUTCION")
    @Mapping(target = "resultado", source = "RESULTADO")
    @Mapping(target = "sexo", source = "SEXO")
    PruebaMolecular toEntity(PruebaMolecularCSVModel dto);

    List<PruebaMolecular> toListEntities(List<PruebaMolecularCSVModel> list);

}
