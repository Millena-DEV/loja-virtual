package com.loja.backend.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "permissao_pessoa")
@SequenceGenerator(name = "seq_permissao_pessoa", sequenceName = "seq_permissao_pessoa", allocationSize = 1, initialValue = 1)

public class PermissaoPessoa implements Serializable {
    private static final long seialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_permissao_pessoa")
    private Long idPermissaoPessoa;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    @JsonIgnore
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "idPermissao")
    private Permissao permissao;

    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;

    /*
     * @Override
     * public String getAuthority() {
     * return permissao.getNome();
     * }
     */
}
