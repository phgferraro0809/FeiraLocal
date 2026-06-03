package model;

public class Produto {
    //Atributos
    private int id;
    private String nome;
    private double preco;
    private String unidade;
    private int quantidadeDisponivel;
    private Produtor produtor;
    private Categoria categoria;

    //Construtores
    public Produto() {
    }

    public Produto(int id, String nome, double preco, String unidade, int quantidadeDisponivel, Produtor produtor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.produtor = produtor;
    }

    //Método toString
    @Override
    public String toString() {
        return exibirDescricao();
    }

    public String exibirDescricao() {
    return "\nNome: " + nome + "\nCategoria: " + getNomeCategoria() + "\nPreco: " + preco + "\nUnidade: " + unidade + "\nQuantidade Disponivel: " + quantidadeDisponivel;
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

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public String getNomeCategoria(){
        if (categoria == null){
            return "Sem Categoria";
        }

        return categoria.getNome();
    }

}