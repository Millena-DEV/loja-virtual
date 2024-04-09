package com.loja.backend.entity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name="Permissao_pessoa")

public class PermissaoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermissaoPessoa;
    
    @ManyToOne
    @JoinColumn(name="idPessoa")
    @JsonIgnore
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name="idPermissao")
    private Permissao permissao;
 
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;
}
