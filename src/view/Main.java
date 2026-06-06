package view;

import model.Artesao;
import model.Avaliacao;
import model.Categoria;
import model.Padeiro;
import model.Produto;
import model.ProdutoArtesanal;
import model.ProdutoPanificado;
import model.ProdutoRural;
import model.ProdutorRural;
import service.AvaliacaoService;
import service.ProdutoService;
import service.ProdutorService;

public class Main {

    public static void main(String[] args) {

        ProdutorService produtorService = new ProdutorService();
        ProdutoService produtoService = new ProdutoService(produtorService);
        AvaliacaoService avaliacaoService = new AvaliacaoService();

        Categoria categoriaHortalicas = new Categoria(1, "Hortaliças", "Verduras, legumes e folhas");
        Categoria categoriaFrutas = new Categoria(2, "Frutas", "Frutas frescas");
        Categoria categoriaOvos = new Categoria(3, "Ovos", "Ovos e derivados");

        Categoria categoriaCeramica = new Categoria(4, "Cerâmica", "Produtos artesanais de cerâmica");
        Categoria categoriaCroche = new Categoria(5, "Crochê", "Produtos artesanais de crochê");

        Categoria categoriaPaes = new Categoria(6, "Pães", "Pães caseiros e artesanais");
        Categoria categoriaBolos = new Categoria(7, "Bolos e tortas", "Bolos, tortas e confeitaria");
        Categoria categoriaDoces = new Categoria(8, "Doces", "Doces artesanais");

        // Adicionando Produtores

        ProdutorRural p1 = new ProdutorRural(
                1,
                "Sítio Esperança",
                "Zona Leste",
                "(11) 99999-1234",
                "sitioesperanca@email.com",
                "Produtos orgânicos cultivados sem agrotóxicos",
                "Pix, Dinheiro, Cartão",
                "Hortaliças",
                "Pequena produção familiar"
        );

        ProdutorRural p2 = new ProdutorRural(
                2,
                "Chácara Santo Antônio",
                "Zona Leste",
                "(11) 99999-5678",
                "chacara@email.com",
                "Produtos frescos colhidos diariamente",
                "Pix e Dinheiro",
                "Frutas e verduras",
                "Venda local e entrega"
        );

        ProdutorRural p3 = new ProdutorRural(
                3,
                "Sítio do Seu João",
                "Zona Norte",
                "(11) 98888-1111",
                "seujoao@email.com",
                "Agricultura familiar com foco em alimentos frescos",
                "Pix",
                "Legumes",
                "Produção rural familiar"
        );

        ProdutorRural p4 = new ProdutorRural(
                4,
                "Horta Comunitária",
                "Zona Sul",
                "(11) 97777-2222",
                "horta@email.com",
                "Horta comunitária com preços acessíveis",
                "Pix e Dinheiro",
                "Hortaliças",
                "Produção comunitária"
        );

        ProdutorRural p5 = new ProdutorRural(
                5,
                "Produtos Orgânicos da Serra",
                "Zona Oeste",
                "(11) 96666-3333",
                "organicos@email.com",
                "Produtos orgânicos selecionados",
                "Pix, Dinheiro e Cartão",
                "Orgânicos",
                "Produção sem agrotóxicos"
        );

        p1.setSenha("123");
        p2.setSenha("123");
        p3.setSenha("123");
        p4.setSenha("123");
        p5.setSenha("123");

        produtorService.cadastrarProdutor(p1);
        produtorService.cadastrarProdutor(p2);
        produtorService.cadastrarProdutor(p3);
        produtorService.cadastrarProdutor(p4);
        produtorService.cadastrarProdutor(p5);

        Artesao a1 = new Artesao(
                6,
                "Ateliê Mãos da Terra",
                "Zona Leste",
                "(11) 95555-4444",
                "maosdaterra@email.com",
                "Artesanato local feito manualmente por família da região",
                "Pix, Dinheiro",
                "Cerâmica artesanal",
                "Argila",
                true
        );

        Artesao a2 = new Artesao(
                7,
                "Crochê da Dona Lúcia",
                "Zona Norte",
                "(11) 94444-5555",
                "crochedalucia@email.com",
                "Peças artesanais de crochê feitas sob encomenda",
                "Pix",
                "Crochê",
                "Linha de algodão",
                true
        );

        Artesao a3 = new Artesao(
                11,
                "Drix Atelier e Escola de Cerâmica",
                "Zona Sul",
                "(11)99467-6451",
                "agferraro71@gmail.com",
                "Artesanato em cerâmica de alta temperatura, utilitários e peças de decoração",
                "Pix e Dinheiro",
                "Cerâmica",
                "Argila",
                true
        );

        a1.setSenha("123");
        a2.setSenha("123");
        a3.setSenha("123");

        produtorService.cadastrarProdutor(a1);
        produtorService.cadastrarProdutor(a2);
        produtorService.cadastrarProdutor(a3);

        // Criando os produtos rurais e atribuindo aos respectivos produtores

        Produto prod1 = new ProdutoRural(1, "Alface", 3.50, "unidade", 20, p1, "Verão 2026", true);
        Produto prod2 = new ProdutoRural(2, "Tomate", 6.00, "kg", 25, p1, "Verão 2026", true);
        Produto prod3 = new ProdutoRural(3, "Cenoura", 4.00, "kg", 30, p1, "Verão 2026", true);
        Produto prod4 = new ProdutoRural(4, "Ovos caipira", 14.00, "dúzia", 10, p1, "Não se aplica", false);

        Produto prod5 = new ProdutoRural(5, "Alface", 3.20, "unidade", 15, p2, "Verão 2026", false);
        Produto prod6 = new ProdutoRural(6, "Tomate", 5.50, "kg", 20, p2, "Verão 2026", false);
        Produto prod7 = new ProdutoRural(7, "Banana prata", 4.50, "kg", 35, p2, "Verão 2026", false);
        Produto prod8 = new ProdutoRural(8, "Limão", 3.00, "kg", 18, p2, "Verão 2026", false);

        Produto prod9 = new ProdutoRural(9, "Alface", 4.00, "unidade", 10, p3, "Verão 2026", false);
        Produto prod10 = new ProdutoRural(10, "Cenoura", 3.80, "kg", 22, p3, "Verão 2026", false);
        Produto prod11 = new ProdutoRural(11, "Batata", 5.00, "kg", 40, p3, "Verão 2026", false);
        Produto prod12 = new ProdutoRural(12, "Ovo caipira", 13.50, "dúzia", 12, p3, "Não se aplica", false);

        Produto prod13 = new ProdutoRural(13, "Alface", 2.80, "unidade", 30, p4, "Verão 2026", false);
        Produto prod14 = new ProdutoRural(14, "Tomate", 5.20, "kg", 28, p4, "Verão 2026", false);
        Produto prod15 = new ProdutoRural(15, "Couve", 2.50, "maço", 18, p4, "Verão 2026", false);
        Produto prod16 = new ProdutoRural(16, "Salsa e cebolinha", 2.00, "maço", 15, p4, "Verão 2026", false);

        Produto prod17 = new ProdutoRural(17, "Alface", 5.00, "unidade", 8, p5, "Verão 2026", true);
        Produto prod18 = new ProdutoRural(18, "Tomate", 7.00, "kg", 15, p5, "Verão 2026", true);
        Produto prod19 = new ProdutoRural(19, "Cenoura", 5.50, "kg", 20, p5, "Verão 2026", true);
        Produto prod20 = new ProdutoRural(20, "Morango", 9.00, "bandeja", 12, p5, "Verão 2026", true);

        prod1.setCategoria(categoriaHortalicas);
        prod2.setCategoria(categoriaHortalicas);
        prod3.setCategoria(categoriaHortalicas);
        prod4.setCategoria(categoriaOvos);

        prod5.setCategoria(categoriaHortalicas);
        prod6.setCategoria(categoriaHortalicas);
        prod7.setCategoria(categoriaFrutas);
        prod8.setCategoria(categoriaFrutas);

        prod9.setCategoria(categoriaHortalicas);
        prod10.setCategoria(categoriaHortalicas);
        prod11.setCategoria(categoriaHortalicas);
        prod12.setCategoria(categoriaOvos);

        prod13.setCategoria(categoriaHortalicas);
        prod14.setCategoria(categoriaHortalicas);
        prod15.setCategoria(categoriaHortalicas);
        prod16.setCategoria(categoriaHortalicas);

        prod17.setCategoria(categoriaHortalicas);
        prod18.setCategoria(categoriaHortalicas);
        prod19.setCategoria(categoriaHortalicas);
        prod20.setCategoria(categoriaFrutas);

        produtoService.adicionarProduto(p1, prod1);
        produtoService.adicionarProduto(p1, prod2);
        produtoService.adicionarProduto(p1, prod3);
        produtoService.adicionarProduto(p1, prod4);

        produtoService.adicionarProduto(p2, prod5);
        produtoService.adicionarProduto(p2, prod6);
        produtoService.adicionarProduto(p2, prod7);
        produtoService.adicionarProduto(p2, prod8);

        produtoService.adicionarProduto(p3, prod9);
        produtoService.adicionarProduto(p3, prod10);
        produtoService.adicionarProduto(p3, prod11);
        produtoService.adicionarProduto(p3, prod12);

        produtoService.adicionarProduto(p4, prod13);
        produtoService.adicionarProduto(p4, prod14);
        produtoService.adicionarProduto(p4, prod15);
        produtoService.adicionarProduto(p4, prod16);

        produtoService.adicionarProduto(p5, prod17);
        produtoService.adicionarProduto(p5, prod18);
        produtoService.adicionarProduto(p5, prod19);
        produtoService.adicionarProduto(p5, prod20);

        // Criando os produtos artesanais e atribuindo aos respectivos artesãos

        Produto prod21 = new ProdutoArtesanal(21, "Vaso de cerâmica", 35.00, "unidade", 8, a1, "Argila", "3 dias");
        Produto prod22 = new ProdutoArtesanal(22, "Caneca artesanal", 28.00, "unidade", 12, a1, "Argila", "2 dias");
        Produto prod23 = new ProdutoArtesanal(23, "Prato decorativo", 45.00, "unidade", 5, a1, "Argila", "4 dias");

        Produto prod24 = new ProdutoArtesanal(24, "Tapete de crochê", 60.00, "unidade", 4, a2, "Linha de algodão", "5 dias");
        Produto prod25 = new ProdutoArtesanal(25, "Sousplat de crochê", 18.00, "unidade", 20, a2, "Linha de algodão", "2 dias");
        Produto prod26 = new ProdutoArtesanal(26, "Bolsa artesanal", 75.00, "unidade", 3, a2, "Linha de algodão", "7 dias");

        Produto prod36 = new ProdutoArtesanal(36, "Pratos de Sobremesa", 240.00, "Kit com 6", 1, a3, "Argila", "14 dias");
        Produto prod37 = new ProdutoArtesanal(37, "Xícara de Café", 37.00, "unidade", 4, a3, "Argila", "10 dias");
        Produto prod38 = new ProdutoArtesanal(38, "Porta Jóias", 75.00, "unidade", 3, a3, "Argila", "20 dias");

        prod21.setCategoria(categoriaCeramica);
        prod22.setCategoria(categoriaCeramica);
        prod23.setCategoria(categoriaCeramica);

        prod24.setCategoria(categoriaCroche);
        prod25.setCategoria(categoriaCroche);
        prod26.setCategoria(categoriaCroche);

        prod36.setCategoria(categoriaCeramica);
        prod37.setCategoria(categoriaCeramica);
        prod38.setCategoria(categoriaCeramica);

        produtoService.adicionarProduto(a1, prod21);
        produtoService.adicionarProduto(a1, prod22);
        produtoService.adicionarProduto(a1, prod23);

        produtoService.adicionarProduto(a2, prod24);
        produtoService.adicionarProduto(a2, prod25);
        produtoService.adicionarProduto(a2, prod26);

        produtoService.adicionarProduto(a3, prod36);
        produtoService.adicionarProduto(a3, prod37);
        produtoService.adicionarProduto(a3, prod38);

        // Cadastrando avaliações para os produtores

        // Produtor 1
        avaliacaoService.adicionarAvaliacao(new Avaliacao(1, p1, "Joana", 5, "Produtos fresquíssimos e entrega rápida.", "24/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(2, p1, "Carlos", 4, "Boa qualidade e preço justo.", "24/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(3, p1, "Marina", 5, "Gostei muito dos produtos.", "24/05/2026"));

        // Produtor 2
        avaliacaoService.adicionarAvaliacao(new Avaliacao(4, p2, "Ana", 4, "Produtos bons e atendimento rápido.", "24/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(5, p2, "Rafael", 5, "Tomate muito bom.", "24/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(6, p2, "Bianca", 4, "Voltaria a comprar.", "24/05/2026"));

        // Produtor 3
        avaliacaoService.adicionarAvaliacao(new Avaliacao(7, p3, "Lucas", 3, "Produtos bons, mas pouca variedade.", "24/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(8, p3, "Fernanda", 4, "Ovos de ótima qualidade.", "24/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(9, p3, "Paulo", 4, "Atendimento educado.", "24/05/2026"));

        // Produtor 4
        avaliacaoService.adicionarAvaliacao(new Avaliacao(10, p4, "Julia", 5, "Preço excelente.", "24/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(11, p4, "Mateus", 5, "Muito bom para a comunidade.", "24/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(12, p4, "Patrícia", 4, "Produtos simples, mas muito frescos.", "24/05/2026"));

        // Produtor 5
        avaliacaoService.adicionarAvaliacao(new Avaliacao(13, p5, "Roberto", 4, "Orgânicos de qualidade.", "24/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(14, p5, "Camila", 5, "Morango excelente.", "24/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(15, p5, "Eduardo", 4, "Preço mais alto, mas qualidade boa.", "24/05/2026"));

        // Artesão 1
        avaliacaoService.adicionarAvaliacao(new Avaliacao(16, a1, "Renata", 5, "Peças muito bonitas e bem acabadas.", "27/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(17, a1, "Gustavo", 4, "Gostei bastante da qualidade.", "27/05/2026"));

        // Artesão 2
        avaliacaoService.adicionarAvaliacao(new Avaliacao(18, a2, "Larissa", 5, "O tapete ficou excelente.", "27/05/2026"));
        avaliacaoService.adicionarAvaliacao(new Avaliacao(19, a2, "Marcos", 5, "Atendimento muito cuidadoso.", "27/05/2026"));

        // ===============================
        // TESTES COM PADEIROS
        // ===============================

        // Criando padeiros
        Padeiro pa1 = new Padeiro(
                8,
                "Padaria Pão da Vila",
                "Zona Sul",
                "(11) 93333-6666",
                "paodavila@email.com",
                "Pães, bolos e doces feitos artesanalmente no bairro",
                "Pix, Dinheiro e Cartão",
                "Pães e bolos artesanais",
                true,
                "1 dia"
        );

        Padeiro pa2 = new Padeiro(
                9,
                "Pães da Dona Marta",
                "Zona Norte",
                "(11) 92222-7777",
                "paesdamarta@email.com",
                "Produção caseira de pães, bolos e doces para a comunidade",
                "Pix e Dinheiro",
                "Pães caseiros e bolos simples",
                true,
                "2 dias"
        );

        Padeiro pa3 = new Padeiro(
                10,
                "Confeitaria Vila Doce",
                "Zona Leste",
                "(11) 91111-8888",
                "viladoce@email.com",
                "Confeitaria artesanal com doces, tortas e bolos frescos",
                "Pix, Cartão e Dinheiro",
                "Doces e confeitaria artesanal",
                true,
                "3 dias"
        );

        Padeiro pa4 = new Padeiro(
                12,
                "Ferraro's Bakery",
                "Zona Sul",
                "(11)98577-5069",
                "rgferraro@gmail.com",
                "Pães artesanais de fermentação natural",
                "Pix e Dinheiro",
                "Pães Artesanais",
                true,
                "2 dias"
        );

        // Cadastrando padeiros

        pa1.setSenha("123");
        pa2.setSenha("123");
        pa3.setSenha("123");
        pa4.setSenha("123");

        produtorService.cadastrarProdutor(pa1);
        produtorService.cadastrarProdutor(pa2);
        produtorService.cadastrarProdutor(pa3);
        produtorService.cadastrarProdutor(pa4);


        // ===============================
        // PRODUTOS PANIFICADOS
        // ===============================

        Produto prod27 = new ProdutoPanificado(
                27,
                "Pão caseiro",
                12.00,
                "unidade",
                15,
                pa1,
                "03/06/2026",
                "05/06/2026",
                true
        );

        Produto prod28 = new ProdutoPanificado(
                28,
                "Bolo de cenoura",
                25.00,
                "unidade",
                6,
                pa1,
                "03/06/2026",
                "06/06/2026",
                true
        );

        Produto prod29 = new ProdutoPanificado(
                29,
                "Pão de queijo",
                18.00,
                "dúzia",
                10,
                pa1,
                "03/06/2026",
                "04/06/2026",
                false
        );

        Produto prod30 = new ProdutoPanificado(
                30,
                "Pão integral",
                14.00,
                "unidade",
                12,
                pa2,
                "03/06/2026",
                "05/06/2026",
                true
        );

        Produto prod31 = new ProdutoPanificado(
                31,
                "Broa de milho",
                10.00,
                "unidade",
                20,
                pa2,
                "03/06/2026",
                "06/06/2026",
                false
        );

        Produto prod32 = new ProdutoPanificado(
                32,
                "Rosca doce",
                16.00,
                "unidade",
                8,
                pa2,
                "03/06/2026",
                "06/06/2026",
                true
        );

        Produto prod33 = new ProdutoPanificado(
                33,
                "Torta de limão",
                42.00,
                "unidade",
                4,
                pa3,
                "03/06/2026",
                "07/06/2026",
                true
        );

        Produto prod34 = new ProdutoPanificado(
                34,
                "Bolo de chocolate",
                35.00,
                "unidade",
                5,
                pa3,
                "03/06/2026",
                "06/06/2026",
                true
        );

        Produto prod35 = new ProdutoPanificado(
                35,
                "Brigadeiro artesanal",
                45.00,
                "cento",
                3,
                pa3,
                "03/06/2026",
                "05/06/2026",
                false
        );

        Produto prod39 = new ProdutoPanificado(
                39,
                "Pão Italiano",
                25.00,
                "unidade",
                7,
                pa4,
                "03/06/2026",
                "10/06/2026",
                true
        );

        Produto prod40 = new ProdutoPanificado(
                40,
                "Tortano",
                60.00,
                "unidade",
                8,
                pa4,
                "03/06/2026",
                "10/06/2026",
                true
        );

        Produto prod41 = new ProdutoPanificado(
                41,
                "Pão rústico multigrãos",
                35.00,
                "unidade",
                9,
                pa4,
                "03/06/2026",
                "10/06/2027",
                true
        );

        prod27.setCategoria(categoriaPaes);
        prod28.setCategoria(categoriaBolos);
        prod29.setCategoria(categoriaPaes);

        prod30.setCategoria(categoriaPaes);
        prod31.setCategoria(categoriaPaes);
        prod32.setCategoria(categoriaPaes);

        prod33.setCategoria(categoriaBolos);
        prod34.setCategoria(categoriaBolos);
        prod35.setCategoria(categoriaDoces);

        prod39.setCategoria(categoriaPaes);
        prod40.setCategoria(categoriaPaes);
        prod41.setCategoria(categoriaPaes);

        // Cadastrando produtos nos respectivos padeiros
        produtoService.adicionarProduto(pa1, prod27);
        produtoService.adicionarProduto(pa1, prod28);
        produtoService.adicionarProduto(pa1, prod29);

        produtoService.adicionarProduto(pa2, prod30);
        produtoService.adicionarProduto(pa2, prod31);
        produtoService.adicionarProduto(pa2, prod32);

        produtoService.adicionarProduto(pa3, prod33);
        produtoService.adicionarProduto(pa3, prod34);
        produtoService.adicionarProduto(pa3, prod35);

        produtoService.adicionarProduto(pa4, prod39);
        produtoService.adicionarProduto(pa4, prod40);
        produtoService.adicionarProduto(pa4, prod41);

        // ===============================
        // AVALIAÇÕES DOS PADEIROS
        // ===============================

        avaliacaoService.adicionarAvaliacao(
                new Avaliacao(
                        22,
                        pa1,
                        "Helena",
                        5,
                        "Pão caseiro muito bom e entrega rápida.",
                        "03/06/2026"
                )
        );

        avaliacaoService.adicionarAvaliacao(
                new Avaliacao(
                        23,
                        pa1,
                        "André",
                        4,
                        "Bolo gostoso e preço justo.",
                        "03/06/2026"
                )
        );

        avaliacaoService.adicionarAvaliacao(
                new Avaliacao(
                        24,
                        pa1,
                        "Carolina",
                        5,
                        "O pão de queijo estava excelente.",
                        "03/06/2026"
                )
        );

        avaliacaoService.adicionarAvaliacao(
                new Avaliacao(
                        25,
                        pa2,
                        "Bruno",
                        5,
                        "Produtos frescos e atendimento muito simpático.",
                        "03/06/2026"
                )
        );

        avaliacaoService.adicionarAvaliacao(
                new Avaliacao(
                        26,
                        pa2,
                        "Vanessa",
                        4,
                        "Gostei bastante da broa de milho.",
                        "03/06/2026"
                )
        );

        avaliacaoService.adicionarAvaliacao(
                new Avaliacao(
                        27,
                        pa2,
                        "Diego",
                        4,
                        "Boa variedade de pães caseiros.",
                        "03/06/2026"
                )
        );

        avaliacaoService.adicionarAvaliacao(
                new Avaliacao(
                        28,
                        pa3,
                        "Isabela",
                        5,
                        "A torta de limão estava muito boa.",
                        "03/06/2026"
                )
        );

        avaliacaoService.adicionarAvaliacao(
                new Avaliacao(
                        29,
                        pa3,
                        "Marcelo",
                        5,
                        "Doces bem feitos e apresentação bonita.",
                        "03/06/2026"
                )
        );

        avaliacaoService.adicionarAvaliacao(
                new Avaliacao(
                        30,
                        pa3,
                        "Sofia",
                        4,
                        "Bolo de chocolate muito saboroso.",
                        "03/06/2026"
                )
        );

        // Chamando o Menu

        Menu menu = new Menu(produtorService, produtoService);
        menu.menu();
    }
}