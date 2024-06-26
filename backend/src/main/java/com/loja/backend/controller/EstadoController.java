package com.loja.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.loja.backend.entity.Estado;
import com.loja.backend.service.EstadoService;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/estado")

public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;
    
    @GetMapping("/")
    public List<Estado> buscarTodos(){
       return estadoService.buscarTodos();
    }

    @PostMapping("/")
    public Estado inserir(@RequestBody Estado novoEstado){
        return estadoService.inserir(novoEstado);
    }

    @PutMapping("/")
    public Estado alterar(@RequestBody  Estado alteraEstado){
        return estadoService.alterar(alteraEstado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        estadoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}