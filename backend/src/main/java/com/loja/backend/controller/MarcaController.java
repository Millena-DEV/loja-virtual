package com.loja.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import com.loja.backend.entity.Marca;
import com.loja.backend.service.MarcaService;



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
@RequestMapping("/api/marca")

public class MarcaController {
    
    @Autowired
    private MarcaService marcaService;
    
    @GetMapping("/")
    public List<Marca> buscarTodos(){
       return marcaService.buscarTodos();
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca novaMarca){
        return marcaService.inserir(novaMarca);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody  Marca alteraMarca){
        return marcaService.alterar(alteraMarca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        marcaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}