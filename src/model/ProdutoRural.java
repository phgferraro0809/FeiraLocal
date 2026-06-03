package model;

public class ProdutoRural extends Produto {

    // Atributos específicos
    private String safra;
    private boolean organico;

    // Construtor vazio
    public ProdutoRural() {
        super();
    }

    // Construtor completo
    public ProdutoRural(
            int id,
            String nome,
            double preco,
            String unidade,
            int quantidadeDisponivel,
            Produtor produtor,
            String safra,
            boolean organico
    ) {
        super(id, nome, preco, unidade, quantidadeDisponivel, produtor);
        this.safra = safra;
        this.organico = organico;
    }

    // Método usado para polimorfismo
    @Override
    public String exibirDescricao() {
        return "\nProduto Rural"
                + "\nNome: " + getNome()
                + "\nCategoria: " + getNomeCategoria()
                + "\nPreço: R$" + getPreco()
                + "\nUnidade: " + getUnidade()
                + "\nQuantidade disponível: " + getQuantidadeDisponivel()
                + "\nSafra: " + safra
                + "\nOrgânico: " + (organico ? "Sim" : "Não");
    }

    // Método toString
    @Override
    public String toString() {
        return exibirDescricao();
    }

    // Getters e Setters
    public String getSafra() {
        return safra;
    }

    public void setSafra(String safra) {
        this.safra = safra;
    }

    public boolean isOrganico() {
        return organico;
    }

    public void setOrganico(boolean organico) {
        this.organico = organico;
    }
}