package br.com.ampara.Pessoa;

public record PessoaResponse(
        Long id,
        String nome,
        String email
) {
    public PessoaResponse(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
    }
}