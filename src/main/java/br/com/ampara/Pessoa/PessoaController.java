package br.com.ampara.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pessoa")
public class PessoaController {

        @Autowired
        private PessoaRepository pessoaRepository;


        @GetMapping
        public List<Pessoa> listar() {
            return pessoaRepository.findAll();
        }


        @GetMapping("/{id}")
        public Optional<Pessoa> buscarPorId(@PathVariable Long id) {
            return pessoaRepository.findById(id);
        }


        @PostMapping
        public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
            return pessoaRepository.save(pessoa);
        }


        @PutMapping("/{id}")
        public Pessoa atualizar(@PathVariable Long id,
                                @RequestBody Pessoa pessoa) {
            pessoa.setId(id);
            return pessoaRepository.save(pessoa);
        }


        @DeleteMapping("/{id}")
        public void excluir(@PathVariable Long id) {
            pessoaRepository.deleteById(id);
        }
}
