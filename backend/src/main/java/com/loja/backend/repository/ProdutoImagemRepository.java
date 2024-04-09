package com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.backend.entity.ProdutoImagem;

public interface ProdutoImagemRepository extends JpaRepository<ProdutoImagem,Long>{
    
}


