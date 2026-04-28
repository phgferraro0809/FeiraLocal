package view;

import java.util.ArrayList;
import model.Avaliacao;
import model.Categoria;
import model.Produto;
import model.Produtor;
import model.ProdutorRural;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== TESTE FEIRALOCAL ===\n");

        //Criar Categoria
        Categoria verduras = new Categoria(
                1,
                "Verduras",
                "Folhas frescas"
        );

        System.out.println(verduras);

        //Criar Produtor
        Produtor produtor = new Produtor(
                1,
                "Sítio Esperança",
                "Zona Leste",
                "(11)99999-1234",
                "sitio@email.com",
                "Produtos orgânicos",
                "Pix"
        );

        System.out.println(produtor);

        //Criar ProdutorRural
        ProdutorRural rural = new ProdutorRural(
                2,
                "Chácara Boa Terra",
                "Zona Norte",
                "(11)98888-7777",
                "boaterra@email.com",
                "Produção familiar",
                "Pix",
                "Orgânicos",
                "Hidroponia"
        );

        System.out.println(rural);

        //Criar Produtos
        Produto p1 = new Produto(
                1,
                "Alface",
                3.50,
                "unidade",
                20,
                "Verão",
                produtor
        );

        Produto p2 = new Produto(
                2,
                "Cenoura",
                5.00,
                "kg",
                15,
                "Outono",
                produtor
        );

        System.out.println(p1);
        System.out.println(p2);

        //Lista de produtos
        ArrayList<Produto> produtos = new ArrayList<>();

        produtos.add(p1);
        produtos.add(p2);

        System.out.println("\nLista de produtos:");
        for (Produto p : produtos){
            System.out.println(p);
        }

        //Criar Avaliações
        Avaliacao a1 = new Avaliacao(
                1,
                produtor,
                "Pedro",
                5,
                "Excelente",
                "17/04/2026"
        );

        Avaliacao a2 = new Avaliacao(
                2,
                produtor,
                "Maria",
                4,
                "Muito bom",
                "27/04/2026"
        );

        System.out.println(a1);
        System.out.println(a2);

        //Lista de Avaliações
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

        avaliacoes.add(a1);
        avaliacoes.add(a2);

        System.out.println("\nAvaliações:");
        for(Avaliacao a : avaliacoes){
            System.out.println(a);
        }

        //Teste getters e setters
        p1.setPreco(4.00);

        System.out.println(
            "\nNovo preço do alface: " +
            p1.getPreco()
        );

        //ProdutorRural
        System.out.println("Especialidade: " +
                rural.getEspecialidade());

        System.out.println("Tipo de produção: " +
                rural.getTipoProducao());

        rural.setEspecialidade("Fruticultura");
        rural.setTipoProducao("Agroecológica");

        System.out.println("\nApós alterações:");
        System.out.println("Especialidade: " +
                rural.getEspecialidade());

        System.out.println("Tipo de produção: " +
                rural.getTipoProducao());


        System.out.println("\nEncerrando teste...");

    }
}