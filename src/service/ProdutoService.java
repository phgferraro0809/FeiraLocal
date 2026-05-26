package service;

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

            System.out.println(produto);

        }

    }

    // SEARCH
    public ArrayList<Produto> buscarProduto(String nome) {

        ArrayList<Produto> encontrados = new ArrayList<>();

        for (Produtor produtor : produtorService.getProdutores()) {

            for (Produto produto : produtor.getProdutos()) {

                if (produto.getNome().equalsIgnoreCase(nome)) {

                    encontrados.add(produto);

                }

            }

        }

        return encontrados;
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

}