package br.com.ampara.Pessoa;

public record PessoaResponse(
        Long id,
        String nome,
        String email,
        String telefone
) {
    public PessoaResponse(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone());
    }
}