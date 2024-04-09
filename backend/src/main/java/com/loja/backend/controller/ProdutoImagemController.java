package com.loja.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.loja.backend.entity.ProdutoImagem;
import com.loja.backend.service.ProdutoImagemService;

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
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/produtoImagens")

public class ProdutoImagemController {
    
    @Autowired
    private ProdutoImagemService ImagemService;
    
    @GetMapping("/")
    public List<ProdutoImagem> buscarTodos(){
       return ImagemService.buscarTodos();
    }

    @PostMapping("/")
    public ProdutoImagem inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file){
        return ImagemService.inserir(idProduto, file);
    }

    @PutMapping("/")
    public ProdutoImagem alterar(@RequestBody  ProdutoImagem alteraImagem){
        return ImagemService.alterar(alteraImagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        ImagemService.excluir(id);
        return ResponseEntity.ok().build();
    }
}