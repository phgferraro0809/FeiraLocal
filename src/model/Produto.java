package model;

public class Produto {
    //Atributos
    private int id;
    private String nome;
    private double preco;
    private String unidade;
    private int quantidadeDisponivel;
    private String safra;
    private Produtor produtor;

    //Construtores
    public Produto() {
    }

    public Produto(int id, String nome, double preco, String unidade, int quantidadeDisponivel, String safra, Produtor produtor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.safra = safra;
        this.produtor = produtor;
    }

    //Método toString
    public String toString() {
        return "Id: " + id + "\nNome: " + nome + "\nPreco: " + preco + "\nUnidade: " + unidade + "\nQuantidade Disponivel: " + quantidadeDisponivel + "\nSafra: " + safra;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getSafra() {
        return safra;
    }

    public void setSafra(String safra) {
        this.safra = safra;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

}