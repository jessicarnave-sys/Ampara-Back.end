package br.com.ampara.Pessoa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> listar() {
        List<PessoaResponse> pessoas = pessoaService.listarPessoas()
                .stream()
                .map(PessoaResponse::new)
                .toList();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> buscarPorId(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.buscarPessoaPorId(id);
        return ResponseEntity.ok(new PessoaResponse(pessoa));
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> cadastrar(@RequestBody Pessoa pessoa) {
        Pessoa salva = pessoaService.cadastrarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PessoaResponse(salva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> atualizar(@PathVariable Long id,
                                                    @RequestBody Pessoa pessoa) {
        Pessoa atualizada = pessoaService.atualizarPessoa(id, pessoa);
        return ResponseEntity.ok(new PessoaResponse(atualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
        return ResponseEntity.noContent().build();
    }
}