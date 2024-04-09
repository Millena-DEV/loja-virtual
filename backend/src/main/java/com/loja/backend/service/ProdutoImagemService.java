package com.loja.backend.service;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.loja.backend.entity.ProdutoImagem;
import com.loja.backend.entity.Produto;
import com.loja.backend.repository.ProdutoImagemRepository;
import com.loja.backend.repository.ProdutoRepository;


@Service
public class ProdutoImagemService {

    @Autowired
    private ProdutoImagemRepository ir;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagem> buscarTodos() {
        return ir.findAll();
    }

    public ProdutoImagem inserir(Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagem imagemNova = new ProdutoImagem();
        try {
			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getIdProduto()) + file.getOriginalFilename();
				Path caminho = Paths
						.get("c:/imagens/" +nomeImagem );
				Files.write(caminho, bytes);
                imagemNova.setNome(nomeImagem);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        imagemNova.setProduto(produto);
        imagemNova.setDataCriacao(new Date());
        ir.saveAndFlush(imagemNova);
        return imagemNova;
            
    }

    public ProdutoImagem alterar(@RequestBody ProdutoImagem alteraImagem) {
        alteraImagem.setDataAtualizacao(new Date());
        return ir.saveAndFlush(alteraImagem);
    }

    public void excluir(Long id) {
      ProdutoImagem deletarproduto = ir.findById(id).get();
        ir.delete(deletarproduto);
    }

}
