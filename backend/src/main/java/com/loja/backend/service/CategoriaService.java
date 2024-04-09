package com.loja.backend.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.loja.backend.entity.Categoria;
import com.loja.backend.repository.CategoriaRepository;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository cr;

    public List<Categoria> buscarTodos() {
        return cr.findAll();
    }

    public Categoria inserir( @RequestBody Categoria novaCategoria) {
        novaCategoria.setDataCriacao(new Date());
        Categoria categoriaNova = cr.saveAndFlush(novaCategoria);
        return categoriaNova;
        
    }

    public Categoria alterar(@RequestBody Categoria alteraCategoria) {
        alteraCategoria.setDataAtualizacao(new Date());
        return cr.saveAndFlush(alteraCategoria);
    }

    public void excluir(Long id) {
      Categoria deletarCategoria = cr.findById(id).get();
        cr.delete(deletarCategoria);
    }

}
