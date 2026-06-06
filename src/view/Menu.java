package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private boolean encerrarSistema = true;

    public Menu(ProdutorService produtorService, ProdutoService produtoService){
        this.produtorService = produtorService;
        this.produtoService = produtoService;
    }

    public void menu(){

        int opcao;

        do {
            System.out.println("=== FEIRA LOCAL ===");

            System.out.println("1- Entrar como Consumidor");
            System.out.println("2- Entrar como Produtor");
            System.out.println("3- Cadastrar novo Produtor");
            System.out.println("4- Sair");

            opcao = lerInteiro("Escolha: ");

            switch (opcao) {

                case 1:
                    menuConsumidor();

                break;

                case 2:
                    System.out.println("=== LOGIN DO PRODUTOR ===");

                    if (produtorService.listaVazia()) {
                        System.out.println("Nenhum produtor cadastrado.");
                        break;
                    }

                    System.out.print("Email: ");
                    String emailLogin = sc.nextLine();

                    System.out.print("Senha: ");
                    String senhaLogin = sc.nextLine();

                    Produtor produtorLogado = produtorService.loginProdutor(emailLogin, senhaLogin);

                    if (produtorLogado == null) {
                        System.out.println("Email ou senha inválidos.");
                        break;
                    }

                    System.out.println("Login realizado com sucesso!");
                    menuProdutor(produtorLogado);

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

                    if (produtorService.emailCadastrado(email)) {
                        System.out.println("Já existe um produtor cadastrado com esse email.");
                        break;
                    }

                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    if (senha.isBlank()) {
                        System.out.println("Senha inválida.");
                        break;
                    }

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
                
                    produtor.setSenha(senha);
                    produtorService.cadastrarProdutor(produtor);

                    System.out.println("Produtor cadastrado com sucesso!");

                break;

                case 4:
                    System.out.println("Encerrando...");
                    encerrarSistema = false;

                break;

                default:
                    System.out.println("Opção inválida.");

                break;
            }

        } while (opcao != 4 && encerrarSistema);

    }

    public void menuConsumidor(){
        int opcao;

        do{
            System.out.println("=== Menu Consumidor ===");
            System.out.println("1- Buscar Produtos");
            System.out.println("2- Buscar por Região");
            System.out.println("3- Buscar por Categoria");
            System.out.println("4- Avaliar Produtor");
            System.out.println("5- Voltar");
            System.out.println("6- Sair");
            opcao = lerInteiro("Escolha: ");

            switch (opcao){
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

                case 4:
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

                        int nota = lerInteiro("Nota (1 a 5): ");

                        if (nota < 1 || nota > 5) {
                            System.out.println("Nota inválida. Digite uma nota de 1 a 5.");
                            break;
                        }

                        System.out.print("Comentário: ");
                        String comentario = sc.nextLine();

                        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        Avaliacao avaliacao = new Avaliacao(
                            produtorEscolhido.getAvaliacoes().size() + 1,
                            produtorEscolhido,
                            nomeAvaliador,
                            nota,
                            comentario,
                            data
                        );

                        produtorService.adicionarAvaliacao(
                            produtorEscolhido.getId(),
                            avaliacao
                        );

                    } else {

                        System.out.println("Produtor inválido.");
                    }

                break;

                case 5:
                    System.out.println("Voltando ao menu principal...");

                break;

                case 6:
                    System.out.println("Encerrando...");
                    encerrarSistema = false;
                break;

                default:
                    System.out.println("Opção inválida.");

                break;


            }
        }while (opcao != 5 && encerrarSistema);
    }

    public void menuProdutor(Produtor produtorSelecionado){
        int opcao;

        do{
            System.out.println("=== Menu Produtor ===");
            System.out.println("Produtor: " + produtorSelecionado.getNome());
            System.out.println("1- Gerenciar Produtos");
            System.out.println("2- Minha Conta");
            System.out.println("3- Voltar");
            System.out.println("4- Sair");
            opcao = lerInteiro("Escolha: ");

            switch (opcao){
                case 1:
                    gerenciarProdutos(produtorSelecionado);

                break;

                case 2:
                    minhaConta(produtorSelecionado);

                    if (!produtorService.getProdutores().contains(produtorSelecionado)){
                        return;
                    }

                break;

                case 3:
                    System.out.println("Voltando ao menu principal...");

                break;

                case 4:
                    System.out.println("Encerrando...");
                    encerrarSistema = false;
                
                break;

                default:
                    System.out.println("Opção inválida.");

                break;

            }
        }while (opcao != 3 && encerrarSistema);
    }

    private void gerenciarProdutos(Produtor produtorSelecionado) {

    int opcao;

    do {
        System.out.println("=== GERENCIAR PRODUTOS ===");
        System.out.println("Produtor selecionado: " + produtorSelecionado.getNome());
        System.out.println("1- Cadastrar produto");
        System.out.println("2- Listar meus produtos");
        System.out.println("3- Atualizar produto");
        System.out.println("4- Remover produto");
        System.out.println("5- Voltar");
        System.out.println("6- Sair");

        opcao = lerInteiro("Escolha: ");

        switch (opcao) {

            case 1:
                System.out.println("=== CADASTRAR PRODUTO ===");

                if (produtorService.listaVazia()) {
                    System.out.println("Nenhum produtor cadastrado.");
                    break;
                }

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

            case 2: 

                System.out.println("=== MEUS PRODUTOS ===");

                if (produtorSelecionado.getProdutos().isEmpty()) {
                    System.out.println("Nenhum produto cadastrado.");
                    break;
                }

                for (int i = 0; i < produtorSelecionado.getProdutos().size(); i++) {
                    Produto produtoAtual = produtorSelecionado.getProdutos().get(i);

                    System.out.println("Produto " + (i + 1) + ":");
                    System.out.println(produtoAtual.exibirDescricao());
                    System.out.println("-------------------------");
                }

            break;

            case 3: {
                System.out.println("=== ATUALIZAR PRODUTO ===");

                if (produtorSelecionado.getProdutos().isEmpty()) {
                    System.out.println("Nenhum produto cadastrado.");
                    break;
                }

                for (int i = 0; i < produtorSelecionado.getProdutos().size(); i++) {
                    Produto produtoAtual = produtorSelecionado.getProdutos().get(i);

                    System.out.println(
                        (i + 1) + " - " +
                        produtoAtual.getNome() +
                        " | R$" + produtoAtual.getPreco() +
                        " | " + produtoAtual.getUnidade() +
                        " | Quantidade: " + produtoAtual.getQuantidadeDisponivel()
                    );
                }

                int escolhaProduto = lerInteiro("Escolha o produto que deseja atualizar: ");

                if (escolhaProduto <= 0 || escolhaProduto > produtorSelecionado.getProdutos().size()) {
                    System.out.println("Produto inválido.");
                    break;
                }

                Produto produtoSelecionado = produtorSelecionado.getProdutos().get(escolhaProduto - 1);

                int opcaoAtualizacao;

                do {
                    System.out.println("=== O QUE DESEJA ATUALIZAR? ===");
                    System.out.println("Produto: " + produtoSelecionado.getNome());
                    System.out.println("1 - Nome");
                    System.out.println("2 - Preço");
                    System.out.println("3 - Unidade");
                    System.out.println("4 - Quantidade disponível");
                    System.out.println("5 - Categoria");

                    if (produtoSelecionado instanceof ProdutoRural) {
                        System.out.println("6 - Safra");
                        System.out.println("7 - Orgânico");
                    } else if (produtoSelecionado instanceof ProdutoArtesanal) {
                        System.out.println("6 - Material principal");
                        System.out.println("7 - Tempo de produção");
                    } else if (produtoSelecionado instanceof ProdutoPanificado) {
                        System.out.println("6 - Data de fabricação");
                        System.out.println("7 - Validade");
                        System.out.println("8 - Contém glúten");
                    }

                    System.out.println("0 - Voltar");

                    opcaoAtualizacao = lerInteiro("Escolha: ");

                    switch (opcaoAtualizacao) {

                        case 1: {
                            System.out.print("Novo nome: ");
                            String novoNome = sc.nextLine();

                            if (novoNome.isBlank()) {
                                System.out.println("Nome inválido.");
                                break;
                            }

                            produtoSelecionado.setNome(novoNome);
                            System.out.println("Nome atualizado com sucesso!");
                            break;
                        }

                        case 2: {
                            double novoPreco = lerDouble("Novo preço: ");

                            if (novoPreco <= 0) {
                                System.out.println("Preço inválido.");
                                break;
                            }

                            produtoSelecionado.setPreco(novoPreco);
                            System.out.println("Preço atualizado com sucesso!");
                            break;
                        }

                        case 3: {
                            System.out.print("Nova unidade: ");
                            String novaUnidade = sc.nextLine();

                            if (novaUnidade.isBlank()) {
                                System.out.println("Unidade inválida.");
                                break;
                            }

                            produtoSelecionado.setUnidade(novaUnidade);
                            System.out.println("Unidade atualizada com sucesso!");
                            break;
                        }

                        case 4: {
                            int novaQuantidade = lerInteiro("Nova quantidade disponível: ");

                            if (novaQuantidade < 0) {
                                System.out.println("Quantidade inválida.");
                                break;
                            }

                            produtoSelecionado.setQuantidadeDisponivel(novaQuantidade);
                            System.out.println("Quantidade atualizada com sucesso!");
                            break;
                        }

                        case 5: {
                            System.out.print("Nova categoria: ");
                            String novaCategoriaNome = sc.nextLine();

                            if (novaCategoriaNome.isBlank()) {
                                System.out.println("Categoria inválida.");
                                break;
                            }

                            Categoria novaCategoria = new Categoria(
                                0,
                                novaCategoriaNome,
                                "Categoria atualizada pelo produtor"
                            );

                            produtoSelecionado.setCategoria(novaCategoria);
                            System.out.println("Categoria atualizada com sucesso!");
                            break;
                        }

                        case 6: {
                            if (produtoSelecionado instanceof ProdutoRural) {

                                ProdutoRural produtoRural = (ProdutoRural) produtoSelecionado;

                                System.out.print("Nova safra: ");
                                String novaSafra = sc.nextLine();

                                produtoRural.setSafra(novaSafra);
                                System.out.println("Safra atualizada com sucesso!");

                            } else if (produtoSelecionado instanceof ProdutoArtesanal) {

                                ProdutoArtesanal produtoArtesanal = (ProdutoArtesanal) produtoSelecionado;

                                System.out.print("Novo material principal: ");
                                String novoMaterialPrincipal = sc.nextLine();

                                produtoArtesanal.setMaterialPrincipal(novoMaterialPrincipal);
                                System.out.println("Material principal atualizado com sucesso!");

                            } else if (produtoSelecionado instanceof ProdutoPanificado) {

                                ProdutoPanificado produtoPanificado = (ProdutoPanificado) produtoSelecionado;

                                System.out.print("Nova data de fabricação: ");
                                String novaDataFabricacao = sc.nextLine();

                                produtoPanificado.setDataFabricacao(novaDataFabricacao);
                                System.out.println("Data de fabricação atualizada com sucesso!");
                            }

                            break;
                        }

                        case 7: {
                            if (produtoSelecionado instanceof ProdutoRural) {

                                ProdutoRural produtoRural = (ProdutoRural) produtoSelecionado;

                                String respostaOrganico = lerSimOuNao("É orgânico? (s/n): ");
                                produtoRural.setOrganico(respostaOrganico.equalsIgnoreCase("s"));

                                System.out.println("Informação de orgânico atualizada com sucesso!");

                            } else if (produtoSelecionado instanceof ProdutoArtesanal) {

                                ProdutoArtesanal produtoArtesanal = (ProdutoArtesanal) produtoSelecionado;

                                System.out.print("Novo tempo de produção: ");
                                String novoTempoProducao = sc.nextLine();

                                produtoArtesanal.setTempoProducao(novoTempoProducao);
                                System.out.println("Tempo de produção atualizado com sucesso!");

                            } else if (produtoSelecionado instanceof ProdutoPanificado) {

                                ProdutoPanificado produtoPanificado = (ProdutoPanificado) produtoSelecionado;

                                System.out.print("Nova validade: ");
                                String novaValidade = sc.nextLine();

                                produtoPanificado.setValidade(novaValidade);
                                System.out.println("Validade atualizada com sucesso!");
                            }

                            break;
                        }

                        case 8: {
                            if (produtoSelecionado instanceof ProdutoPanificado) {

                                ProdutoPanificado produtoPanificado = (ProdutoPanificado) produtoSelecionado;

                                String respostaGluten = lerSimOuNao("Contém glúten? (s/n): ");
                                produtoPanificado.setContemGluten(respostaGluten.equalsIgnoreCase("s"));

                                System.out.println("Informação de glúten atualizada com sucesso!");

                            } else {
                                System.out.println("Opção inválida para esse tipo de produto.");
                            }

                            break;
                        }

                        case 0:
                            System.out.println("Voltando ao gerenciamento de produtos...");
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }

                } while (opcaoAtualizacao != 0);

            break;
            }

            case 4: {
                System.out.println("=== REMOVER PRODUTO ===");

                if (produtorSelecionado.getProdutos().isEmpty()) {
                    System.out.println("Nenhum produto cadastrado.");
                    break;
                }

                for (int i = 0; i < produtorSelecionado.getProdutos().size(); i++) {
                    Produto produtoAtual = produtorSelecionado.getProdutos().get(i);

                    System.out.println(
                        (i + 1) + " - " +
                        produtoAtual.getNome() +
                        " | R$" + produtoAtual.getPreco() +
                        " | " + produtoAtual.getUnidade() +
                        " | Quantidade: " + produtoAtual.getQuantidadeDisponivel()
                    );
                }

                int escolhaProduto = lerInteiro("Escolha o produto que deseja remover: ");

                if (escolhaProduto <= 0 || escolhaProduto > produtorSelecionado.getProdutos().size()) {
                    System.out.println("Produto inválido.");
                    break;
                }

                Produto produtoRemover = produtorSelecionado.getProdutos().get(escolhaProduto - 1);

                System.out.println("Produto selecionado:");
                System.out.println(produtoRemover.exibirDescricao());

                String confirmacao = lerSimOuNao("Tem certeza que deseja remover esse produto? (s/n): ");

                if (confirmacao.equalsIgnoreCase("n")) {
                    System.out.println("Remoção cancelada.");
                    break;
                }

                boolean removido = produtoService.removerProduto(produtorSelecionado, produtoRemover.getId());

                if (removido) {
                    System.out.println("Produto removido com sucesso!");
                } else {
                    System.out.println("Não foi possível remover o produto.");
                }

                break;
            }
            case 5:
                System.out.println("Voltando ao menu do produtor...");

            break;

            case 6:
                System.out.println("Encerrando...");
                encerrarSistema = false;

            break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

    } while (opcao != 5 && encerrarSistema);
}

    private void minhaConta(Produtor produtorSelecionado){
        int opcao;

        do { 
            System.out.println("=== Minha Conta ===");
            System.out.println("Produtor: " + produtorSelecionado.getNome());
            System.out.println("1- Ver meus dados");
            System.out.println("2- Atualizar meus dados");
            System.out.println("3- Excluir minha conta");
            System.out.println("4- Voltar");
            System.out.println("5- Sair");
            opcao = lerInteiro("Escolha: ");

            switch (opcao){

                case 1:
                    produtorService.exibirDetalhesProdutor(produtorSelecionado);

                break;

                case 2:
                    int opcaoAtualizacao;

                    do {
                        System.out.println("=== ATUALIZAR MEUS DADOS ===");
                        System.out.println("1- Nome");
                        System.out.println("2- Região");
                        System.out.println("3- Telefone");
                        System.out.println("4- Email");
                        System.out.println("5- Descrição");
                        System.out.println("6- Formas de pagamento");

                        if (produtorSelecionado instanceof ProdutorRural) {
                            System.out.println("7- Especialidade");
                            System.out.println("8- Tipo de produção");
                        } else if (produtorSelecionado instanceof Artesao) {
                            System.out.println("7- Tipo de artesanato");
                            System.out.println("8- Material principal");
                            System.out.println("9- Aceita encomenda");
                        } else if (produtorSelecionado instanceof Padeiro) {
                            System.out.println("7- Tipo de produção");
                            System.out.println("8- Aceita encomenda");
                            System.out.println("9- Prazo de entrega");
                        }

                        System.out.println("0- Voltar");

                        opcaoAtualizacao = lerInteiro("Escolha: ");

                        switch (opcaoAtualizacao) {

                            case 1:
                                System.out.print("Novo nome: ");
                                String novoNome = sc.nextLine();

                                if (novoNome.isBlank()) {
                                    System.out.println("Nome inválido.");
                                    break;
                                }

                                produtorSelecionado.setNome(novoNome);
                                System.out.println("Nome atualizado com sucesso!");
                            break;

                            case 2:
                                System.out.print("Nova região: ");
                                String novaRegiao = sc.nextLine();

                                if (novaRegiao.isBlank()) {
                                    System.out.println("Região inválida.");
                                    break;
                                }

                                produtorSelecionado.setRegiao(novaRegiao);
                                System.out.println("Região atualizada com sucesso!");
                            break;

                            case 3:
                                System.out.print("Novo telefone: ");
                                String novoTelefone = sc.nextLine();

                                if (novoTelefone.isBlank()) {
                                    System.out.println("Telefone inválido.");
                                    break;
                                }

                                produtorSelecionado.setTelefone(novoTelefone);
                                System.out.println("Telefone atualizado com sucesso!");
                            break;

                            case 4:
                                System.out.print("Novo email: ");
                                String novoEmail = sc.nextLine();

                                if (novoEmail.isBlank()) {
                                    System.out.println("Email inválido.");
                                    break;
                                }

                                produtorSelecionado.setEmail(novoEmail);
                                System.out.println("Email atualizado com sucesso!");
                            break;

                            case 5:
                                System.out.print("Nova descrição: ");
                                String novaDescricao = sc.nextLine();

                                if (novaDescricao.isBlank()) {
                                    System.out.println("Descrição inválida.");
                                    break;
                                }

                                produtorSelecionado.setDescricao(novaDescricao);
                                System.out.println("Descrição atualizada com sucesso!");
                            break;

                            case 6:
                                System.out.print("Novas formas de pagamento: ");
                                String novasFormasPagamento = sc.nextLine();

                                if (novasFormasPagamento.isBlank()) {
                                    System.out.println("Formas de pagamento inválidas.");
                                    break;
                                }

                                produtorSelecionado.setFormasPagamento(novasFormasPagamento);
                                System.out.println("Formas de pagamento atualizadas com sucesso!");
                            break;

                            case 7:
                                if (produtorSelecionado instanceof ProdutorRural) {
                                    ProdutorRural produtorRural = (ProdutorRural) produtorSelecionado;

                                    System.out.print("Nova especialidade: ");
                                    String novaEspecialidade = sc.nextLine();

                                    if (novaEspecialidade.isBlank()) {
                                        System.out.println("Especialidade inválida.");
                                        break;
                                    }

                                    produtorRural.setEspecialidade(novaEspecialidade);
                                    System.out.println("Especialidade atualizada com sucesso!");

                                } else if (produtorSelecionado instanceof Artesao) {
                                    Artesao artesao = (Artesao) produtorSelecionado;

                                    System.out.print("Novo tipo de artesanato: ");
                                    String novoTipoArtesanato = sc.nextLine();

                                    if (novoTipoArtesanato.isBlank()) {
                                        System.out.println("Tipo de artesanato inválido.");
                                        break;
                                    }

                                    artesao.setTipoArtesanato(novoTipoArtesanato);
                                    System.out.println("Tipo de artesanato atualizado com sucesso!");

                                } else if (produtorSelecionado instanceof Padeiro) {
                                    Padeiro padeiro = (Padeiro) produtorSelecionado;

                                    System.out.print("Novo tipo de produção: ");
                                    String novoTipoProducao = sc.nextLine();

                                    if (novoTipoProducao.isBlank()) {
                                        System.out.println("Tipo de produção inválido.");
                                        break;
                                    }

                                    padeiro.setTipoProducao(novoTipoProducao);
                                    System.out.println("Tipo de produção atualizado com sucesso!");
                                }
                            break;

                            case 8:
                                if (produtorSelecionado instanceof ProdutorRural) {
                                    ProdutorRural produtorRural = (ProdutorRural) produtorSelecionado;

                                    System.out.print("Novo tipo de produção: ");
                                    String novoTipoProducao = sc.nextLine();

                                    if (novoTipoProducao.isBlank()) {
                                        System.out.println("Tipo de produção inválido.");
                                        break;
                                    }

                                    produtorRural.setTipoProducao(novoTipoProducao);
                                    System.out.println("Tipo de produção atualizado com sucesso!");

                                } else if (produtorSelecionado instanceof Artesao) {
                                    Artesao artesao = (Artesao) produtorSelecionado;

                                    System.out.print("Novo material principal: ");
                                    String novoMaterialPrincipal = sc.nextLine();

                                    if (novoMaterialPrincipal.isBlank()) {
                                        System.out.println("Material principal inválido.");
                                        break;
                                    }

                                    artesao.setMaterialPrincipal(novoMaterialPrincipal);
                                    System.out.println("Material principal atualizado com sucesso!");

                                } else if (produtorSelecionado instanceof Padeiro) {
                                    Padeiro padeiro = (Padeiro) produtorSelecionado;

                                    String respostaEncomenda = lerSimOuNao("Aceita encomenda? (s/n): ");
                                    padeiro.setAceitaEncomenda(respostaEncomenda.equalsIgnoreCase("s"));

                                    System.out.println("Informação de encomenda atualizada com sucesso!");
                                }
                            break;

                            case 9:
                                if (produtorSelecionado instanceof Artesao) {
                                    Artesao artesao = (Artesao) produtorSelecionado;

                                    String respostaEncomenda = lerSimOuNao("Aceita encomenda? (s/n): ");
                                    artesao.setAceitaEncomenda(respostaEncomenda.equalsIgnoreCase("s"));

                                    System.out.println("Informação de encomenda atualizada com sucesso!");

                                } else if (produtorSelecionado instanceof Padeiro) {
                                    Padeiro padeiro = (Padeiro) produtorSelecionado;

                                    System.out.print("Novo prazo de entrega: ");
                                    String novoPrazoEntrega = sc.nextLine();

                                    if (novoPrazoEntrega.isBlank()) {
                                        System.out.println("Prazo de entrega inválido.");
                                        break;
                                    }

                                    padeiro.setPrazoEntrega(novoPrazoEntrega);
                                    System.out.println("Prazo de entrega atualizado com sucesso!");

                                } else {
                                    System.out.println("Opção inválida para esse tipo de produtor.");
                                }
                            break;

                            case 0:
                                System.out.println("Voltando para Minha Conta...");
                            break;

                            default:
                                System.out.println("Opção inválida.");
                            break;
                        }

                    } while (opcaoAtualizacao != 0);


                break;

                case 3:
                    System.out.println("=== Excluir Conta ===");
                    System.out.println("Atenção! Se excluir a conta ela não poderá ser recuperada!");

                    String confirmacao = lerSimOuNao("Tem certeza que deseja excluir sua conta? (s/n): ");
                    
                    if (confirmacao.equalsIgnoreCase("n")){
                        System.out.println("Exclusão Cancelada!");
                        break;
                    }

                    boolean removido = produtorService.removerProdutor(produtorSelecionado);

                    if (removido){
                        System.out.println("Conta Excluída com sucesso!");
                        return;
                    }else {
                        System.out.println("Não foi possível excluir a conta!");
                    }

                break;

                case 4:
                    System.out.println("Voltando ao menu inicial...");
                
                break;

                case 5:
                    System.out.println("Encerrando...");
                    encerrarSistema = false;

                break;
            }
        } while (opcao != 4 && encerrarSistema);
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