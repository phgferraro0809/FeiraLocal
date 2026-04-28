package model;

public class Categoria {
    //Atributos
    private int id;
    private String nome;
    private String descricao;

    //Construtores
    public Categoria(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    //Método toString
    public String toString() {
        return "Id: " + id + "\nNome: " + nome + "\nDescricao: " + descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}