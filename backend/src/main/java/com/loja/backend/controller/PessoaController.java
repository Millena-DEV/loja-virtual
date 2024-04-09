package com.loja.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import com.loja.backend.entity.Pessoa;
import com.loja.backend.service.PessoaService;

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
@RequestMapping("/api/pessoa")

public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;
    
    @GetMapping("/")
    public List<Pessoa> buscarTodos(){
       return pessoaService.buscarTodos();
    }

    @PostMapping("/")
    public Pessoa inserir(@RequestBody Pessoa novaPessoa){
        return pessoaService.inserir(novaPessoa);
    }

    @PutMapping("/")
    public Pessoa alterar(@RequestBody  Pessoa alteraPessoa){
        return pessoaService.alterar(alteraPessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}