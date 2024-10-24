package br.com.bruno.rest_spring.controller;

import br.com.bruno.rest_spring.ProdutoService.ProdutoService;
import br.com.bruno.rest_spring.entity.Produto;
import br.com.bruno.rest_spring.exception.ProductNullException;
import br.com.bruno.rest_spring.exception.ProductPriceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws ProductNullException, ProductPriceException {
        produto = service.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id) {
        Produto produto = service.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/busca-todos")
    public ResponseEntity<List<Produto>> buscaTodosProdutos() {
        List<Produto> produtos = service.findAll();
        return ResponseEntity.ok().body(produtos);
    }
}
