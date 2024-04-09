package com.loja.backend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Table(name = "Pessoa")
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1, initialValue = 1)
public class Pessoa implements Serializable {
    private static final long seialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_permissao_pessoa")
    private Long idPessoa;
    @ManyToOne // Relação muitos pra 1. muitas cidades pra 1 estado
    @JoinColumn(name = "idCidade")
    private Cidade cidade;
    private String nome;
    private String CPF;
    private String email;
    private String senha;
    private String endereco;
    private String cep;
    private String codigoRecuperacaoSenha;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvioCodigo;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, fetch = FetchType.EAGER)
    @Setter(value = AccessLevel.NONE) // DESATIVAR O SETER PARA PERMISSAO PESSOA
    private List<PermissaoPessoa> permissaoPessoas;

    @Temporal(TemporalType.DATE)
    private Date DataCriacao;
    @Temporal(TemporalType.DATE)
    private Date DataAtualizacao;

    public void setPermissaoPessoas(List<PermissaoPessoa> pp) {
        for (PermissaoPessoa p : pp) {
            p.setPessoa(this);
        }
        this.permissaoPessoas = pp;
    }

    /*
     * @Override
     * public Collection<? extends GrantedAuthority> getAuthorities() {
     * 
     * return permissaoPessoas;
     * }
     * 
     * @Override
     * public String getPassword() {
     * return senha;
     * }
     * 
     * @Override
     * public String getUsername() {
     * return email;
     * }
     * 
     * @Override
     * public boolean isAccountNonExpired() {
     * return true;
     * }
     * 
     * @Override
     * public boolean isAccountNonLocked() {
     * return true;
     * }
     * 
     * @Override
     * public boolean isCredentialsNonExpired() {
     * return true;
     * }
     * 
     * @Override
     * public boolean isEnabled() {
     * return true;
     * }
     */

}
