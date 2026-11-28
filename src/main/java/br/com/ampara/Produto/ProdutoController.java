package br.com.ampara.Produto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listar() {
        List<ProdutoResponse> produtos = produtoService.listarProdutos()
                .stream()
                .map(ProdutoResponse::new)
                .toList();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(new ProdutoResponse(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrar(@RequestBody Produto produto) {
        Produto salvo = produtoService.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProdutoResponse(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Long id,
                                                     @RequestBody Produto produto) {
        Produto atualizado = produtoService.atualizarProduto(id, produto);
        return ResponseEntity.ok(new ProdutoResponse(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}