package br.com.bruno.rest_spring.controller;

import br.com.bruno.rest_spring.ProdutoService.ProdutoService;
import br.com.bruno.rest_spring.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvaproduto(@RequestBody Produto produto) {
        produto = service.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id) {
        Produto produto = service.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/busca-todos")
    public ResponseEntity<List<Produto>> buscaTodosProdutos() {
        List<Produto> produtos = service.findAll();
        return ResponseEntity.ok().body(produtos);
    }
}
