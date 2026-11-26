package br.com.ampara.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProdutoController {

    public class ProductController {

        @Autowired
        ProdutoRepository repository;

        @GetMapping
        public ResponseEntity getAll(){
            List<Produto> ListProduto = repository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(ListProduto);
        }

        @PostMapping
        public ResponseEntity save(@RequestBody Produto produto){
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
        }

    }
}
