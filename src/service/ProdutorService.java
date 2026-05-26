package service;

import java.util.ArrayList;
import model.Avaliacao;
import model.Produto;
import model.Produtor;

public class ProdutorService {

    //Lista de produtores
    private ArrayList<Produtor> produtores;

    //Construtor
    public ProdutorService() {
        produtores = new ArrayList<>();
    }

    public ArrayList<Produtor> getProdutor(){
        return produtores;
    }

    //Cadastro de Produtores

    public void cadastrarProdutor(Produtor produtor) {

        if (produtor == null) {
            System.out.println("Erro: produtor inválido.");
            return;
        }

        produtores.add(produtor);

    }

    //Listar produtores
    public void listarProdutores() {

        if (produtores.isEmpty()) {
            System.out.println("Nenhum produtor cadastrado.");
            return;
        }

        for (Produtor produtor : produtores) {
            System.out.println(produtor);
        }
    }

    //Buscar por ID
    public Produtor buscarPorId(int id) {

        for (Produtor produtor : produtores) {

            if (produtor.getId() == id) {
                return produtor;
            }

        }

        return null;
    }

    //Buscar por região
    public ArrayList<Produtor> buscarPorRegiao(String regiao) {

        ArrayList<Produtor> encontrados = new ArrayList<>();

        for (Produtor produtor : produtores) {

            if (produtor.getRegiao().equalsIgnoreCase(regiao)) {
                encontrados.add(produtor);
            }

        }

        return encontrados;
    }

    //Buscar pelo nome
    public Produtor buscarPorNome(String nome) {

        for (Produtor produtor : produtores) {

            if (produtor.getNome().equalsIgnoreCase(nome)) {
                return produtor;
            }

        }

        return null;
    }

    //Exibir detalhes do produtor
    public void exibirDetalhesProdutor(Produtor produtor) {

        if (produtor == null) {
            System.out.println("Produtor não encontrado.");
            return;
        }

        System.out.println("=== DETALHES DO PRODUTOR ===");

        System.out.println(produtor.exibirDescricao());
        System.out.println("Região: " + produtor.getRegiao());
        System.out.println("Telefone: " + produtor.getTelefone());
        System.out.println("Email: " + produtor.getEmail());
        System.out.println("Formas de pagamento: " + produtor.getFormasPagamento());

        //Média das avaliações
        double media = calcularMediaAvaliacoes(produtor);

        System.out.printf("Média das avaliações: %.1f\n", media);

        // Produtos
        System.out.println("\nPRODUTOS:");

        if (produtor.getProdutos().isEmpty()) {

            System.out.println("Nenhum produto cadastrado.");

        } else {

            for (Produto produto : produtor.getProdutos()) {
                System.out.println(produto);
            }

        }

        //Avaliações
        System.out.println("\nAVALIAÇÕES:");

        if (produtor.getAvaliacoes().isEmpty()) {

            System.out.println("Nenhuma avaliação cadastrada.");

        } else {

            for (Avaliacao avaliacao : produtor.getAvaliacoes()) {
                System.out.println(avaliacao);
            }

        }
    }

    //Associar produto
    public void adicionarProdutoAoProdutor(int idProdutor, Produto produto) {

        Produtor produtor = buscarPorId(idProdutor);

        if (produtor == null) {
            System.out.println("Produtor não encontrado.");
            return;
        }

        produtor.getProdutos().add(produto);

        System.out.println("Produto adicionado ao produtor!");
    }

    // Listar produtos do produtor
    public void listarProdutosDoProdutor(int idProdutor) {

        Produtor produtor = buscarPorId(idProdutor);

        if (produtor == null) {
            System.out.println("Produtor não encontrado.");
            return;
        }

        if (produtor.getProdutos().isEmpty()) {
            System.out.println("O produtor não possui produtos.");
            return;
        }

        System.out.println("PRODUTOS DE " + produtor.getNome());

        for (Produto produto : produtor.getProdutos()) {
            System.out.println(produto);
        }
    }

    // Avaliações

    // Adicionar avaliação ao produtor
    public void adicionarAvaliacao(int idProdutor, Avaliacao avaliacao) {

        Produtor produtor = buscarPorId(idProdutor);

        if (produtor == null) {
            System.out.println("Produtor não encontrado.");
            return;
        }

        produtor.getAvaliacoes().add(avaliacao);

        System.out.println("Avaliação adicionada com sucesso!");
    }

    // Calcular média das avaliações
    public double calcularMediaAvaliacoes(Produtor produtor) {

        if (produtor.getAvaliacoes().isEmpty()) {
            return 0;
        }

        double soma = 0;

        for (Avaliacao avaliacao : produtor.getAvaliacoes()) {
            soma += avaliacao.getNota();
        }

        return soma / produtor.getAvaliacoes().size();
    }

    // Validação

    // Verificar ID
    public boolean produtorExiste(int id) {
        return buscarPorId(id) != null;
    }

    //Verificar se a lista está vazia
    public boolean listaVazia() {
        return produtores.isEmpty();
    }

    //Getter e Setter

    public ArrayList<Produtor> getProdutores() {
        return produtores;
    }

    public void setProdutores(ArrayList<Produtor> produtores) {
        this.produtores = produtores;
    }
}