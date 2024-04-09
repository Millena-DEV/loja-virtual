package com.loja.backend.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.backend.entity.Pessoa;
import com.loja.backend.service.PessoaGerenciamentoService;

@RestController
@RequestMapping("/api/pessoa-gerenciamento")
@CrossOrigin
public class PessoaGerenciamentoController {

   @Autowired
   private PessoaGerenciamentoService pessoaGerenciamentoService;

   /*
    * @Autowired
    * private JwtUtil jwtUtil;
    */

   @PostMapping("/senha-codigo")
   public String recuperarCodigo(@RequestBody Pessoa pessoa) {
      return pessoaGerenciamentoService.solicitarCodigo(pessoa.getEmail());
   }

   /*
    * @PostMapping("/senha-alterar")
    * public String alterarSenha(@RequestBody Pessoa pessoa) {
    * return pessoaGerenciamentoService.alterarSenha(pessoa);
    * }/*
    * 
    * @PostMapping("/login")
    * public ResponseEntity<?> login(@RequestBody Pessoa pessoa) {
    * Authentication authentication = authenticationManager
    * .authenticate(new UsernamePasswordAuthenticationToken(pessoa.getEmail(),
    * pessoa.getSenha()));
    * SecurityContextHolder.getContext().setAuthentication(authentication);
    * Pessoa autenticado = (Pessoa) authentication.getPrincipal();
    * // String token = jwtUtil.gerarTokenUsername(autenticado);
    * HashMap<String, Object> map = new HashMap<>();
    * // map.put("token", token);
    * // map.put("permissoes", autenticado.getAuthorities());
    * return ResponseEntity.ok(map);
    * 
    * }
    */
}