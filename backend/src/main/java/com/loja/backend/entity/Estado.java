package com.loja.backend.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import lombok.Data;

@Entity
@Table(name = "Estado")
@Data
@SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado", allocationSize = 1, initialValue = 1)
public class Estado implements Serializable {
    private static final long seialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estado")
    private Long idEstado;

    private String nome;
    private String sigla;
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;

}
