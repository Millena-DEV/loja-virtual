package com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.loja.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    
}


