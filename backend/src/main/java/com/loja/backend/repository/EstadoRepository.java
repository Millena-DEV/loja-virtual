package com.loja.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.loja.backend.entity.Estado;



@Repository
public interface EstadoRepository  extends JpaRepository<Estado,Long>{


}