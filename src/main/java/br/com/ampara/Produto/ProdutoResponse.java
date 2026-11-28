package br.com.ampara.Produto;

public record ProdutoResponse(
        Long id,
        String name,
        Long price
) {
    public ProdutoResponse(Produto produto) {
        this(produto.getId(), produto.getName(), produto.getPrice());
    }
}
