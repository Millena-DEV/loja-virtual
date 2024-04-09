package com.loja.backend.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.loja.backend.entity.Produto;
import com.loja.backend.repository.ProdutoRepository;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository pr;

    public List<Produto> buscarTodos() {
        return pr.findAll();
    }

    public Produto inserir( @RequestBody Produto novoProduto) {
        novoProduto.setDataCriacao(new Date());
        Produto produtoNovo = new Produto();
        pr.saveAndFlush(produtoNovo);
        return produtoNovo;
            
    }

    public Produto alterar(@RequestBody Produto alteraProduto) {
        alteraProduto.setDataAtualizacao(new Date());
        return pr.saveAndFlush(alteraProduto);
    }

    public void excluir(Long id) {
      Produto deletarproduto = pr.findById(id).get();
        pr.delete(deletarproduto);
    }

}
