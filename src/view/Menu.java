package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Avaliacao;
import model.Produto;
import model.Produtor;
import service.ProdutoService;
import service.ProdutorService;

public class Menu{
    Scanner sc = new Scanner(System.in);

    private ProdutorService produtorService;
    private ProdutoService produtoService;

    public Menu(ProdutorService produtorService, ProdutoService produtoService){
        this.produtorService = produtorService;
        this.produtoService = produtoService;
    }

    public void menu(){

        int opcao;

        do{
            System.out.println("=== Feira Local ===");
            System.out.println("1- Buscar produtos");
            System.out.println("2- Buscar por região");
            System.out.println("3- Cadastrar Produtor");
            System.out.println("4- Cadastrar Produto");
            System.out.println("5- Avaliar Produtor");
            System.out.println("6- Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 1:
                    System.out.print("Buscar Produto: ");
                    String busca = sc.nextLine();

                    ArrayList<Produto> encontrados = produtoService.buscarProduto(busca);

                    if (encontrados.isEmpty()){
                        System.out.println("Nenhum Produto Encontrado!");
                    }else {
                        System.out.println("PRODUTOS ENCONTRADOS");

                        for (int i = 0; i < encontrados.size(); i++) {

                            Produto produto = encontrados.get(i);

                            System.out.println(
                                (i + 1) + " - " +
                                produto.getNome() +
                                " | R$" + produto.getPreco() +
                                " | " + produto.getUnidade() +
                                " | Produtor: " + produto.getProdutor().getNome()
                            );
                        }
                        System.out.print("Ordenar por preço? (s/n): ");
                        String resposta = sc.nextLine();

                        if (resposta.equalsIgnoreCase("s")){
                            produtoService.ordenarPorPreco(encontrados);
                            System.out.println("PRODUTOS ORDENADOS POR PREÇO (mais barato primeiro):");

                            for (int i = 0; i < encontrados.size(); i++){

                                Produto produto = encontrados.get(i);

                                System.out.println(
                                    (i + 1) + " - " +
                                    produto.getNome() +
                                    " | R$" + produto.getPreco() +
                                    " | " + produto.getUnidade() +
                                    " | Produtor: " + produto.getProdutor().getNome()
                                );
                            }
                        }

                        System.out.print("Deseja ver detalhes de algum produtor? (digite o número ou 0): ");
                        int escolha = sc.nextInt();
                        sc.nextLine();

                        if (escolha > 0 && escolha <= encontrados.size()){
                            Produto produtoEscolhido = encontrados.get (escolha - 1);

                            produtorService.exibirDetalhesProdutor(produtoEscolhido.getProdutor());
                        }else if (escolha != 0){
                            System.out.println("Opção Inválida!");
                        }
                    }

                break;

                case 2:

                    System.out.print("Buscar por região: ");
                    String regiao = sc.nextLine();

                    ArrayList<Produtor> produtoresRegiao =
                            produtorService.buscarPorRegiao(regiao);

                    if (produtoresRegiao.isEmpty()) {

                        System.out.println("Nenhum produtor encontrado.");

                    } else {

                        System.out.println("PRODUTORES DA REGIÃO:");

                        for (Produtor produtor : produtoresRegiao) {

                            System.out.println("\n" + produtor.getNome());

                            System.out.println(
                                "Contato: " +
                                produtor.getTelefone() +
                                " | Email: " +
                                produtor.getEmail()
                            );

                            System.out.println(
                                "Descrição: " +
                                produtor.getDescricao()
                            );

                            double media =
                                    produtorService.calcularMediaAvaliacoes(produtor);

                            System.out.printf(
                                "Avaliação: %.1f/5\n",
                                media
                            );

                            System.out.println("PRODUTOS:");

                            if (produtor.getProdutos().isEmpty()) {

                                System.out.println(
                                    "Nenhum produto cadastrado."
                                );

                            } else {

                                for (Produto produto : produtor.getProdutos()) {

                                    System.out.println(
                                        produto.getNome() +
                                        ": R$" + produto.getPreco() +
                                        "/" + produto.getUnidade()
                                    );
                                }
                            }
                        }
                    }

                break;

                case 3:

                    System.out.println("=== CADASTRAR PRODUTOR ===");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Região: ");
                    String regiaoProdutor = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();

                    System.out.print("Formas de pagamento: ");
                    String formasPagamento = sc.nextLine();

                    Produtor produtor = new Produtor(
                        produtorService.getProdutor().size() + 1,
                        nome,
                        regiaoProdutor,
                        telefone,
                        email,
                        descricao,
                        formasPagamento
                    );

                    produtorService.cadastrarProdutor(produtor);

                break;

                case 4:

                    System.out.println("=== CADASTRAR PRODUTO ===");

                    if (produtorService.listaVazia()) {

                        System.out.println("Nenhum produtor cadastrado.");
                        break;
                    }

                    System.out.print("Nome do produto: ");
                    String nomeProduto = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();

                    if (preco <= 0) {
                        System.out.println("Preço inválido.");
                        break;
                    }

                    System.out.print("Unidade: ");
                    String unidade = sc.nextLine();

                    System.out.print("Quantidade disponível: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    if (quantidade < 0) {
                        System.out.println("Quantidade inválida.");
                        break;
                    }


                    System.out.print("Safra: ");
                    String safra = sc.nextLine();

                    System.out.println("PRODUTORES DISPONÍVEIS:");

                    for (int i = 0; i < produtorService.getProdutores().size(); i++) {

                        Produtor produtorAtual = produtorService.getProdutores().get(i);

                        System.out.println(
                            (i + 1) + " - " +
                            produtorAtual.getNome()
                        );
                    }

                    System.out.print("Escolha o produtor: ");
                    int escolhaProdutor = sc.nextInt();
                    sc.nextLine();

                    if (
                        escolhaProdutor > 0 &&
                        escolhaProdutor <= produtorService.getProdutores().size()
                    ) {

                        Produtor produtorEscolhido =
                            produtorService.getProdutores().get(escolhaProdutor - 1);

                        Produto produto = new Produto(
                            produtorEscolhido.getProdutos().size() + 1,
                            nomeProduto,
                            preco,
                            unidade,
                            quantidade,
                            safra,
                            produtorEscolhido
                        );

                        produtorService.adicionarProdutoAoProdutor(
                            produtorEscolhido.getId(),
                            produto
                        );

                    } else {

                        System.out.println("Produtor inválido.");
                    }

                break;

                case 5:

                    System.out.println("=== AVALIAR PRODUTOR ===");

                    if (produtorService.listaVazia()) {

                        System.out.println("Nenhum produtor cadastrado.");
                        break;
                    }

                    System.out.println("PRODUTORES:");

                    for (int i = 0; i < produtorService.getProdutores().size(); i++) {

                        Produtor produtorAtual =
                            produtorService.getProdutores().get(i);

                        System.out.println(
                            (i + 1) + " - " +
                            produtorAtual.getNome()
                        );
                    }

                    System.out.print("Escolha o produtor: ");
                    int escolhaAvaliacao = sc.nextInt();
                    sc.nextLine();

                    if (
                        escolhaAvaliacao > 0 &&
                        escolhaAvaliacao <= produtorService.getProdutores().size()
                    ) {

                        Produtor produtorEscolhido =
                            produtorService.getProdutores().get(escolhaAvaliacao - 1);

                        System.out.print("Nome do avaliador: ");
                        String nomeAvaliador = sc.nextLine();

                        System.out.print("Nota (1 a 5): ");
                        int nota = sc.nextInt();
                        sc.nextLine();

                        if (nota < 1 || nota > 5) {
                            System.out.println("Nota inválida. Digite uma nota de 1 a 5.");
                            break;
                        }

                        System.out.print("Comentário: ");
                        String comentario = sc.nextLine();

                        Avaliacao avaliacao = new Avaliacao(
                            produtorEscolhido.getAvaliacoes().size() + 1,
                            produtorEscolhido,
                            nomeAvaliador,
                            nota,
                            comentario,
                            "23/05/2026"
                        );

                        produtorService.adicionarAvaliacao(
                            produtorEscolhido.getId(),
                            avaliacao
                        );

                    } else {

                        System.out.println("Produtor inválido.");
                    }

                break;

                case 6:
                    System.out.println("Encerrando...");

                break;

                default:
                    System.out.println("Opção Inválida!");
                break;
            }
        }while (opcao != 6);
    }
}