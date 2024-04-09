package com.loja.backend.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="ProdutoImagem")
@SequenceGenerator(name = "seq_imagens", sequenceName = "seq_imagens", allocationSize = 1, initialValue = 1)
public class ProdutoImagem implements Serializable {
    private static final long seialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_imagens")
    private long idImagens;
    @ManyToOne // Relação muitos pra 1. muitas cidades pra 1 estado
    @JoinColumn(name = "idProduto")
    private Produto produto;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;

   
    
}
