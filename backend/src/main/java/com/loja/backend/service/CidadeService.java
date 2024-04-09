package com.loja.backend.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.loja.backend.entity.Cidade;
import com.loja.backend.repository.CidadeRepository;


@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cr;

    public List<Cidade> buscarTodos() {
        return cr.findAll();
    }
  
    public Cidade inserir( @RequestBody Cidade novaCidade) {
        novaCidade.setDataCriacao(new Date());
        Cidade cidade = new Cidade();
        Cidade cidadeNova = cr.saveAndFlush(novaCidade);
        return cidadeNova;
        
    }

    public Cidade alterar(@RequestBody Cidade cidade) {
        cidade.setDataAtualizacao(new Date());
        return cr.saveAndFlush(cidade);
    }

    public void excluir(Long id) {
        Cidade cidade = cr.findById(id).get();
        cr.delete(cidade);
    }

}
