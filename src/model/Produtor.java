package model;

import java.util.ArrayList;

public class Produtor {
    //Atributos Privados
    private int id;
    private String nome;
    private String regiao;
    private String telefone;
    private String email;
    private String descricao;
    private String formasPagamento;
    private String senha;

    private ArrayList<Produto> produtos;
    private ArrayList<Avaliacao> avaliacoes;

    //Construtores
    public Produtor() {
        produtos = new ArrayList<>();
        avaliacoes = new ArrayList<>();
    }

    public Produtor(int id, String nome, String regiao, String telefone, String email, String descricao, String formasPagamento) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
        this.telefone = telefone;
        this.email = email;
        this.descricao = descricao;
        this.formasPagamento = formasPagamento;

        this.produtos = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    //Método toString
    public String toString() {
        return "\nNome: " + nome + "\nRegião: " + regiao + "\nTelefone: " + telefone + "\nEmail: " + email + "\nDescrição: " + descricao;
    }

    //GETTERS E SETTERS
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


    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(String formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }


    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    // Método para exibir a Descrição do produtor
    public String exibirDescricao() {
    return "Produtor: " + nome + "\nDescrição: " + descricao;
    }

}