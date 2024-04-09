package com.loja.backend.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.loja.backend.entity.Pessoa;
import com.loja.backend.repository.PessoaRepository;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaNova;

    public List<Pessoa> buscarTodos() {
        return pessoaNova.findAll();
    }

    public Pessoa inserir( @RequestBody Pessoa pessoaP) {
        pessoaP.setDataCriacao(new Date());
        Pessoa NovaPessoa = (pessoaP);
        return NovaPessoa;
        
    }

    public Pessoa alterar(@RequestBody Pessoa pessoaP) {
        pessoaP.setDataAtualizacao(new Date());
        return pessoaNova.saveAndFlush(pessoaP);
    }

    public void excluir(Long id) {
        Pessoa cidade = pessoaNova.findById(id).get();
        pessoaNova.delete(cidade);
    }

}
