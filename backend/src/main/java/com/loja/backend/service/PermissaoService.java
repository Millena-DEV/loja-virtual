package com.loja.backend.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import com.loja.backend.entity.Permissao;

import com.loja.backend.repository.PermissaoRepository;



@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository pr;

    public List<Permissao> buscarTodos() {
        return pr.findAll();
    }

    public Permissao inserir( @RequestBody Permissao novaPermissao) {
        novaPermissao.setDataCriacao(new Date());
        Permissao permissaoNova = pr.saveAndFlush(novaPermissao);
        return permissaoNova;
        
    }

    public Permissao alterar(@RequestBody Permissao alteraPermissao) {
        alteraPermissao.setDataAtualizacao(new Date());
        return pr.saveAndFlush(alteraPermissao);
    }

    public void excluir(Long id) {
        Permissao deletarPermissao = pr.findById(id).get();
        pr.delete(deletarPermissao);
    }

}
