package br.com.ampara.Pessoa;

import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoaExistente = buscarPessoaPorId(id);

        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setEmail(pessoaAtualizada.getEmail());
        pessoaExistente.setTelefone(pessoaAtualizada.getTelefone());

        return pessoaRepository.save(pessoaExistente);
    }


    public void excluirPessoa(Long id) {
        Pessoa pessoa = buscarPessoaPorId(id);
        pessoaRepository.delete(pessoa);
    }
}