package model;

public class ProdutoPanificado extends Produto {

    // Atributos específicos
    private String dataFabricacao;
    private String validade;
    private boolean contemGluten;

    // Construtor vazio
    public ProdutoPanificado() {
        super();
    }

    // Construtor completo
    public ProdutoPanificado(
            int id,
            String nome,
            double preco,
            String unidade,
            int quantidadeDisponivel,
            Produtor produtor,
            String dataFabricacao,
            String validade,
            boolean contemGluten
    ) {
        super(id, nome, preco, unidade, quantidadeDisponivel, produtor);

        this.dataFabricacao = dataFabricacao;
        this.validade = validade;
        this.contemGluten = contemGluten;
    }

    // Método usado para polimorfismo
    @Override
    public String exibirDescricao() {
        return "\nProduto Panificado"
                + "\nNome: " + getNome()
                + "\nCategoria: " + getNomeCategoria()
                + "\nPreço: R$" + getPreco()
                + "\nUnidade: " + getUnidade()
                + "\nQuantidade disponível: " + getQuantidadeDisponivel()
                + "\nData de fabricação: " + dataFabricacao
                + "\nValidade: " + validade
                + "\nContém glúten: " + (contemGluten ? "Sim" : "Não");
    }

    // Método toString
    @Override
    public String toString() {
        return exibirDescricao();
    }

    // Getters e Setters
    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public boolean getContemGluten() {
        return contemGluten;
    }

    public void setContemGluten(boolean contemGluten) {
        this.contemGluten = contemGluten;
    }

}