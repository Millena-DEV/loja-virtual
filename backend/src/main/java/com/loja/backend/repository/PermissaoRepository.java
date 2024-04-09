package com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.loja.backend.entity.Permissao;
import java.util.List;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    List<Permissao> findByNome(String nome);

}