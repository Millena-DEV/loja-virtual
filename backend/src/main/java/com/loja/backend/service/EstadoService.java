package com.loja.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.loja.backend.entity.Estado;
import com.loja.backend.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository er;

    public List<Estado> buscarTodos() {
        return er.findAll();
    }

    public Estado inserir( @RequestBody Estado estado) {
        estado.setDataCriacao(new Date());
        Estado estadoNovo  = new Estado();// configure o estado
        er.saveAndFlush(estado); 
        return estadoNovo;
    }

    public Estado alterar(@RequestBody Estado estado) {
        estado.setDataAtualizacao(new Date());
        return er.saveAndFlush(estado);
    }

    public void excluir(Long id) {
        Estado estado = er.findById(id).get();
        er.delete(estado);
    }

}
