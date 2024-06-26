package com.loja.backend.dto;

import org.springframework.beans.BeanUtils;

import com.loja.backend.entity.Cidade;
import com.loja.backend.entity.Pessoa;

import lombok.Data;

@Data
public class PessoaClienteRequestDTO {

    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private Cidade cidade;

    public Pessoa converter(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteRequestDTO, pessoa);
        return pessoa;
    }
}
