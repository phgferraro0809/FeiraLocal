package model;

public class ProdutorRural extends Produtor {

    //Atributos
    private String especialidade;
    private String tipoProducao;

    //Construtores
    public ProdutorRural() {
        super();
    }

    public ProdutorRural(int id, String nome, String regiao, String telefone, String email, String descricao, String formasPagamento, String especialidade, String tipoProducao) {
        super(id, nome, regiao, telefone, email, descricao, formasPagamento);

        this.especialidade = especialidade;
        this.tipoProducao = tipoProducao;
    }

    //Getters e Setters
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTipoProducao() {
        return tipoProducao;
    }

    public void setTipoProducao(String tipoProducao) {
        this.tipoProducao = tipoProducao;
    }

    public String toString() {
        return super.toString() + "\nEspecialidade: " + especialidade + "\nTipo de Produção: " + tipoProducao;
    }
}