package com.loja.backend.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.loja.backend.entity.Marca;
import com.loja.backend.repository.MarcaRepository;


@Service
public class MarcaService {

    @Autowired
    private MarcaRepository mr;

    public List<Marca> buscarTodos() {
        return mr.findAll();
    }

    public Marca inserir( @RequestBody Marca novaMarca) {
        novaMarca.setDataCriacao(new Date());
        Marca produtoNovo = mr.saveAndFlush(novaMarca);
        return produtoNovo;
        
    }

    public Marca alterar(@RequestBody Marca alteraMarca) {
        alteraMarca.setDataAtualizacao(new Date());
        return mr.saveAndFlush(alteraMarca);
    }

    public void excluir(Long id) {
        Marca deletarproduto = mr.findById(id).get();
        mr.delete(deletarproduto);
    }

}
