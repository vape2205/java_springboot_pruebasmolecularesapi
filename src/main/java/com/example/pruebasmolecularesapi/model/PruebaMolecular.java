package com.example.pruebasmolecularesapi.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PruebaMolecular {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prueba_molecular_generator")
    @SequenceGenerator(name = "prueba_molecular_generator", sequenceName = "prueba_molecular_seq")
    public Long id;
    @Nullable
    public Long uuid;
    public String fechaCorte;
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
