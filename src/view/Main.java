package view;

import model.Avaliacao;
import model.Produto;
import model.ProdutorRural;
import service.AvaliacaoService;
import service.ProdutoService;
import service.ProdutorService;

public class Main {

    public static void main(String[] args) {

        ProdutorService produtorService = new ProdutorService();
        ProdutoService produtoService = new ProdutoService(produtorService);
        AvaliacaoService avaliacaoService = new AvaliacaoService();

        // ================= PRODUTORES RURAIS =================

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

        produtorService.cadastrarProdutor(p1);
        produtorService.cadastrarProdutor(p2);
        produtorService.cadastrarProdutor(p3);
        produtorService.cadastrarProdutor(p4);
        produtorService.cadastrarProdutor(p5);

        // ================= PRODUTOS =================
        // Produtos em comum: Alface, Tomate, Cenoura e Ovos

        Produto prod1 = new Produto(1, "Alface", 3.50, "unidade", 20, "Verão 2026", p1);
        Produto prod2 = new Produto(2, "Tomate", 6.00, "kg", 25, "Verão 2026", p1);
        Produto prod3 = new Produto(3, "Cenoura", 4.00, "kg", 30, "Verão 2026", p1);
        Produto prod4 = new Produto(4, "Ovos caipira", 14.00, "dúzia", 10, "Não se aplica", p1);

        Produto prod5 = new Produto(5, "Alface", 3.20, "unidade", 15, "Verão 2026", p2);
        Produto prod6 = new Produto(6, "Tomate", 5.50, "kg", 20, "Verão 2026", p2);
        Produto prod7 = new Produto(7, "Banana prata", 4.50, "kg", 35, "Verão 2026", p2);
        Produto prod8 = new Produto(8, "Limão", 3.00, "kg", 18, "Verão 2026", p2);

        Produto prod9 = new Produto(9, "Alface", 4.00, "unidade", 10, "Verão 2026", p3);
        Produto prod10 = new Produto(10, "Cenoura", 3.80, "kg", 22, "Verão 2026", p3);
        Produto prod11 = new Produto(11, "Batata", 5.00, "kg", 40, "Verão 2026", p3);
        Produto prod12 = new Produto(12, "Ovo caipira", 13.50, "dúzia", 12, "Não se aplica", p3);

        Produto prod13 = new Produto(13, "Alface", 2.80, "unidade", 30, "Verão 2026", p4);
        Produto prod14 = new Produto(14, "Tomate", 5.20, "kg", 28, "Verão 2026", p4);
        Produto prod15 = new Produto(15, "Couve", 2.50, "maço", 18, "Verão 2026", p4);
        Produto prod16 = new Produto(16, "Salsa e cebolinha", 2.00, "maço", 15, "Verão 2026", p4);

        Produto prod17 = new Produto(17, "Alface", 5.00, "unidade", 8, "Verão 2026", p5);
        Produto prod18 = new Produto(18, "Tomate", 7.00, "kg", 15, "Verão 2026", p5);
        Produto prod19 = new Produto(19, "Cenoura", 5.50, "kg", 20, "Verão 2026", p5);
        Produto prod20 = new Produto(20, "Morango", 9.00, "bandeja", 12, "Verão 2026", p5);

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

        // ================= AVALIAÇÕES =================

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
        // ================= CHAMAR MENU =================

        Menu menu = new Menu(produtorService, produtoService);
        menu.menu();
    }
}