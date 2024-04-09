package com.loja.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.loja.backend.entity.Categoria;
import com.loja.backend.service.CategoriaService;

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
@RequestMapping("/api/categoria")

public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/")
    public List<Categoria> buscarTodos(){
       return categoriaService.buscarTodos();
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria novaCategoria){
        return categoriaService.inserir(novaCategoria);
    }

    @PutMapping("/")
    public Categoria alterar(@RequestBody  Categoria alteraCategoria){
        return categoriaService.alterar(alteraCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        categoriaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}