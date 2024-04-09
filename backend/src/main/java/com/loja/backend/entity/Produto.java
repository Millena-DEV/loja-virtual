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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto  implements Serializable{
    private static final long seialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long idProduto;
     @ManyToOne // Relação muitos pra 1. muitas cidades pra 1 estado
    @JoinColumn(name = "idMarca")
    private Marca marca;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    private String descricaoCurta;
    private String descricaoDetalhada;
    private double valorCusto;
    private double valorVenda;
    @Temporal(TemporalType.DATE)
    private Date DataCriacao;
    @Temporal(TemporalType.DATE)
    private Date DataAtualizacao;
}
