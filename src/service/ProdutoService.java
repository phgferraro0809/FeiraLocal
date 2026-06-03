package service;

import java.text.Normalizer;
import java.util.ArrayList;
import model.Produto;
import model.Produtor;

public class ProdutoService {

    private ProdutorService produtorService;

    public ProdutoService(ProdutorService produtorService){
        this.produtorService = produtorService;
    }

    // CREATE
    public void adicionarProduto(Produtor produtor, Produto produto) {

        produtor.getProdutos().add(produto);

    }

    // READ
    public void listarProdutos(Produtor produtor) {

        if (produtor.getProdutos().isEmpty()) {

            System.out.println("Nenhum produto cadastrado.");
            return;

        }

        for (Produto produto : produtor.getProdutos()) {

            System.out.println(produto.exibirDescricao());

        }

    }

    // SEARCH
    public ArrayList<Produto> buscarProduto(String nome) {

        ArrayList<Produto> encontrados = new ArrayList<>();

        for (Produtor produtor : produtorService.getProdutores()) {

            for (Produto produto : produtor.getProdutos()) {

                if (normalizarTexto(produto.getNome()).equals(normalizarTexto(nome))) {

                    encontrados.add(produto);

                }

            }

        }

        return encontrados;
    }

    public ArrayList<Produto> buscarPorCategoria(String nomeCategoria) {

        ArrayList<Produto> produtosEncontrados = new ArrayList<>();

        for (Produtor produtor : produtorService.getProdutores()) {

            for (Produto produto : produtor.getProdutos()) {

                if (produto.getCategoria() != null &&
                    normalizarTexto(produto.getCategoria().getNome()).equals(normalizarTexto(nomeCategoria)) &&
                    !produtoJaFoiAdicionado(produtosEncontrados, produto.getNome())) {

                    produtosEncontrados.add(produto);
                }
            }
        }

        return produtosEncontrados;
    }

    private boolean produtoJaFoiAdicionado(ArrayList<Produto> produtos, String nomeProduto) {

        for (Produto produto : produtos) {

            if (normalizarTexto(produto.getNome()).equals(normalizarTexto(nomeProduto))) {
                return true;
            }
        }

        return false;
    }

    // DELETE
    public boolean removerProduto(Produtor produtor, int id) {

        for (Produto produto : produtor.getProdutos()) {

            if (produto.getId() == id) {

                produtor.getProdutos().remove(produto);
                return true;

            }

        }

        return false;

    }

    // UPDATE
    public boolean atualizarQuantidade(Produtor produtor, int id, int novaQuantidade) {

        for (Produto produto : produtor.getProdutos()) {

            if (produto.getId() == id) {

                produto.setQuantidadeDisponivel(novaQuantidade);
                return true;

            }

        }

        return false;

    }

    // ORDER BY PRICE
    public void ordenarPorPreco(Produtor produtor) {

        produtor.getProdutos().sort(
                (p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco())
        );

    }

    public void ordenarPorPreco(ArrayList<Produto> produtos) {

    produtos.sort(
            (p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco())
    );

    }

    private String normalizarTexto(String texto) {
    if (texto == null) {
        return "";
    }

    return Normalizer
            .normalize(texto, Normalizer.Form.NFD)
            .replaceAll("\\p{M}", "")
            .toLowerCase()
            .trim();
}

}