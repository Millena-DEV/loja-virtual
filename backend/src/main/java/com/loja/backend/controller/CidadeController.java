package com.loja.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.loja.backend.entity.Cidade;
import com.loja.backend.service.CidadeService;




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
@RequestMapping("/api/cidade")

public class CidadeController {
    
    @Autowired
    private CidadeService cidadeService;
    
    @GetMapping("/")
    public List<Cidade> buscarTodos(){
       return cidadeService.buscarTodos();
    }

    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade novaCidade){
        return cidadeService.inserir(novaCidade);
    }

    @PutMapping("/")
    public Cidade alterar(@RequestBody  Cidade alteraCidade){
        return cidadeService.alterar(alteraCidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        cidadeService.excluir(id);
        return ResponseEntity.ok().build();
    }
}