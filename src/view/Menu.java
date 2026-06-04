package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Artesao;
import model.Avaliacao;
import model.Categoria;
import model.Padeiro;
import model.Produto;
import model.ProdutoArtesanal;
import model.ProdutoPanificado;
import model.ProdutoRural;
import model.Produtor;
import model.ProdutorRural;
import service.ProdutoService;
import service.ProdutorService;

public class Menu{
    Scanner sc = new Scanner(System.in, "Cp850");

    private ProdutorService produtorService;
    private ProdutoService produtoService;

    public Menu(ProdutorService produtorService, ProdutoService produtoService){
        this.produtorService = produtorService;
        this.produtoService = produtoService;
    }

    public void menu(){

        int opcao;

        //Definindo o menu inicial

        do{
            System.out.println("=== Feira Local ===");
            System.out.println("1- Buscar produtos");
            System.out.println("2- Buscar por região");
            System.out.println("3- Cadastrar Produtor");
            System.out.println("4- Cadastrar Produto");
            System.out.println("5- Avaliar Produtor");
            System.out.println("6- Buscar por Categoria");
            System.out.println("7- Sair");
            opcao = lerInteiro("Escolha: ");

            // Switch-Case para cada opção selecionada acima

            switch(opcao){
                case 1: // Busca de prodrutos pelo nome
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
                                " | Categoria: " + produto.getNomeCategoria() +
                                " | R$" + produto.getPreco() +
                                " | " + produto.getUnidade() +
                                " | Produtor: " + produto.getProdutor().getNome()
                            );
                        }
                        String resposta = lerSimOuNao("Ordenar por preço? (s/n): ");

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

                        int escolha = lerInteiro("Deseja ver detalhes de algum produtor? (digite o número ou 0): ");

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

                            System.out.println(produtor.exibirDescricao());

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

                    System.out.println("Tipo de produtor:");
                    System.out.println("1 - Produtor rural");
                    System.out.println("2 - Artesão");
                    System.out.println("3 - Padeiro");
                    int tipoProdutor = lerInteiro("Escolha: ");

                    if (tipoProdutor < 1 || tipoProdutor > 3) {
                        System.out.println("Tipo de produtor inválido.");
                        break;
                    }

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

                    int novoId = produtorService.getProdutores().size() + 1;

                    Produtor produtor = null;

                    switch (tipoProdutor) {

                        case 1: {
                            System.out.print("Especialidade: ");
                            String especialidade = sc.nextLine();

                            System.out.print("Tipo de produção: ");
                            String tipoProducao = sc.nextLine();

                            produtor = new ProdutorRural(
                                novoId,
                                nome,
                                regiaoProdutor,
                                telefone,
                                email,
                                descricao,
                                formasPagamento,
                                especialidade,
                                tipoProducao
                            );

                            break;
                        }

                        case 2: {
                            System.out.print("Tipo de artesanato: ");
                            String tipoArtesanato = sc.nextLine();

                            System.out.print("Material principal: ");
                            String materialPrincipalArtesao = sc.nextLine();

                            String respostaEncomendaArtesao = lerSimOuNao("Aceita encomenda? (s/n): ");

                            boolean aceitaEncomendaArtesao =
                                respostaEncomendaArtesao.equalsIgnoreCase("s");

                            produtor = new Artesao(
                                novoId,
                                nome,
                                regiaoProdutor,
                                telefone,
                                email,
                                descricao,
                                formasPagamento,
                                tipoArtesanato,
                                materialPrincipalArtesao,
                                aceitaEncomendaArtesao
                            );

                            break;
                        }

                        case 3: {
                            System.out.print("Tipo de produção: ");
                            String tipoProducaoPadeiro = sc.nextLine();

                            String respostaEncomendaPadeiro = lerSimOuNao("Aceita encomenda? (s/n): ");

                            boolean aceitaEncomendaPadeiro =
                                respostaEncomendaPadeiro.equalsIgnoreCase("s");

                            System.out.print("Prazo de entrega: ");
                            String prazoEntrega = sc.nextLine();

                            produtor = new Padeiro(
                                novoId,
                                nome,
                                regiaoProdutor,
                                telefone,
                                email,
                                descricao,
                                formasPagamento,
                                tipoProducaoPadeiro,
                                aceitaEncomendaPadeiro,
                                prazoEntrega
                            );

                            break;
                        }
                    }

                    produtorService.cadastrarProdutor(produtor);

                    System.out.println("Produtor cadastrado com sucesso!");

                break;

                case 4: {

                    System.out.println("=== CADASTRAR PRODUTO ===");

                    if (produtorService.listaVazia()) {
                        System.out.println("Nenhum produtor cadastrado.");
                        break;
                    }

                    System.out.println("PRODUTORES DISPONÍVEIS:");

                    for (int i = 0; i < produtorService.getProdutores().size(); i++) {
                        Produtor produtorAtual = produtorService.getProdutores().get(i);

                        System.out.println(
                            (i + 1) + " - " +
                            produtorAtual.getNome() + " (" +
                            produtorAtual.getRegiao() + ")"
                        );
                    }

                    int escolhaProdutor = lerInteiro("Escolha o produtor: ");

                    if (escolhaProdutor <= 0 || escolhaProdutor > produtorService.getProdutores().size()) {
                        System.out.println("Produtor inválido.");
                        break;
                    }

                    Produtor produtorSelecionado = produtorService.getProdutores().get(escolhaProdutor - 1);

                    System.out.println("Tipo de produto:");
                    System.out.println("1 - Produto rural");
                    System.out.println("2 - Produto artesanal");
                    System.out.println("3 - Produto panificado");
                    int tipoProduto = lerInteiro("Escolha: ");

                    if (tipoProduto < 1 || tipoProduto > 3) {
                        System.out.println("Tipo de produto inválido.");
                        break;
                    }

                    if (tipoProduto == 1 && !(produtorSelecionado instanceof ProdutorRural)) {
                        System.out.println("Produto rural só pode ser cadastrado para um produtor rural.");
                        break;
                    }

                    if (tipoProduto == 2 && !(produtorSelecionado instanceof Artesao)) {
                        System.out.println("Produto artesanal só pode ser cadastrado para um artesão.");
                        break;
                    }

                    if (tipoProduto == 3 && !(produtorSelecionado instanceof Padeiro)) {
                        System.out.println("Produto panificado só pode ser cadastrado para um padeiro.");
                        break;
                    }

                    int idProduto = produtorSelecionado.getProdutos().size() + 1;

                    System.out.print("Nome do produto: ");
                    String nomeProduto = sc.nextLine();

                    double preco = lerDouble("Preço: ");

                    if (preco <= 0) {
                        System.out.println("Preço inválido.");
                        break;
                    }

                    System.out.print("Unidade: ");
                    String unidade = sc.nextLine();

                    System.out.print("Quantidade disponível: ");
                    int quantidadeDisponivel = lerInteiro("Quantidade disponível: ");

                    if (quantidadeDisponivel < 0) {
                        System.out.println("Quantidade inválida.");
                        break;
                    }

                    System.out.print("Categoria: ");
                    String nomeCategoria = sc.nextLine();

                    if (nomeCategoria.isBlank()) {
                        System.out.println("Categoria inválida.");
                        break;
                    }

                    Categoria categoria = new Categoria(
                        0,
                        nomeCategoria,
                        "Categoria cadastrada pelo usuário"
                    );

                    Produto produto = null;

                    switch (tipoProduto) {

                        case 1: {
                            System.out.print("Safra: ");
                            String safra = sc.nextLine();

                            String respostaOrganico = lerSimOuNao("É orgânico? (s/n): ");

                            boolean organico = respostaOrganico.equalsIgnoreCase("s");

                            produto = new ProdutoRural(
                                idProduto,
                                nomeProduto,
                                preco,
                                unidade,
                                quantidadeDisponivel,
                                produtorSelecionado,
                                safra,
                                organico
                            );

                            break;
                        }

                        case 2: {
                            System.out.print("Material principal: ");
                            String materialPrincipalProduto = sc.nextLine();

                            System.out.print("Tempo de produção: ");
                            String tempoProducao = sc.nextLine();

                            produto = new ProdutoArtesanal(
                                idProduto,
                                nomeProduto,
                                preco,
                                unidade,
                                quantidadeDisponivel,
                                produtorSelecionado,
                                materialPrincipalProduto,
                                tempoProducao
                            );

                            break;
                        }

                        case 3: {
                            System.out.print("Data de fabricação: ");
                            String dataFabricacao = sc.nextLine();

                            System.out.print("Validade: ");
                            String validade = sc.nextLine();

                            String respostaGluten = lerSimOuNao("Contém glúten? (s/n): ");

                            boolean contemGluten = respostaGluten.equalsIgnoreCase("s");

                            produto = new ProdutoPanificado(
                                idProduto,
                                nomeProduto,
                                preco,
                                unidade,
                                quantidadeDisponivel,
                                produtorSelecionado,
                                dataFabricacao,
                                validade,
                                contemGluten
                            );

                            break;
                        }
                    }

                    produto.setCategoria(categoria);
                    produtoService.adicionarProduto(produtorSelecionado, produto);

                    System.out.println("Produto cadastrado com sucesso!");

                    break;
                }                
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

                    int escolhaAvaliacao = lerInteiro("Escolha o produtor: ");

                    if (
                        escolhaAvaliacao > 0 &&
                        escolhaAvaliacao <= produtorService.getProdutores().size()
                    ) {

                        Produtor produtorEscolhido =
                            produtorService.getProdutores().get(escolhaAvaliacao - 1);

                        System.out.print("Nome do avaliador: ");
                        String nomeAvaliador = sc.nextLine();

                        System.out.print("Nota (1 a 5): ");
                        int nota = lerInteiro("Nota (1 a 5): ");

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

                    System.out.println("=== BUSCAR POR CATEGORIA ===");

                    System.out.print("Digite a categoria: ");
                    String categoriaBusca = sc.nextLine();

                    ArrayList<Produto> produtosPorCategoria = produtoService.buscarPorCategoria(categoriaBusca);

                    if (produtosPorCategoria.isEmpty()) {

                        System.out.println("Nenhum produto encontrado nessa categoria.");

                    } else {

                        System.out.println("PRODUTOS ENCONTRADOS:");

                        for (int i = 0; i < produtosPorCategoria.size(); i++) {

                            Produto produto = produtosPorCategoria.get(i);

                            System.out.println(
                                (i + 1) + " - " +
                                produto.getNome()
                            );
                        }
                    }

                break;

                case 7:
                    System.out.println("Encerrando...");

                break;

                default:
                    System.out.println("Opção Inválida!");
                break;
            }
        }while (opcao != 7);
    }


    private String lerSimOuNao(String mensagem) {

        while (true) {

            System.out.print(mensagem);
            String resposta = sc.nextLine().trim();

            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("n")) {
                return resposta;
            }

            System.out.println("Entrada inválida. Digite apenas s ou n.");
        }
    }

    private int lerInteiro(String mensagem) {

        while (true) {

            System.out.print(mensagem);
            String entrada = sc.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private double lerDouble(String mensagem) {

        while (true) {

            System.out.print(mensagem);
            String entrada = sc.nextLine().trim().replace(",", ".");

            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
            }
        }
    }
}