package model;

public class ProdutoArtesanal extends Produto {

    // Atributos específicos
    private String materialPrincipal;
    private String tempoProducao;

    // Construtor vazio
    public ProdutoArtesanal() {
        super();
    }

    // Construtor completo
    public ProdutoArtesanal(
            int id,
            String nome,
            double preco,
            String unidade,
            int quantidadeDisponivel,
            Produtor produtor,
            String materialPrincipal,
            String tempoProducao
    ) {
        super(id, nome, preco, unidade, quantidadeDisponivel, produtor);
        this.materialPrincipal = materialPrincipal;
        this.tempoProducao = tempoProducao;
    }

    // Método usado para polimorfismo
    @Override
    public String exibirDescricao() {
        return "\nProduto Artesanal"
                + "\nNome: " + getNome()
                + "\nCategoria: " + getNomeCategoria()
                + "\nPreço: R$" + getPreco()
                + "\nUnidade: " + getUnidade()
                + "\nQuantidade disponível: " + getQuantidadeDisponivel()
                + "\nMaterial principal: " + materialPrincipal
                + "\nTempo de produção: " + tempoProducao;
    }

    // Método toString
    @Override
    public String toString() {
        return exibirDescricao();
    }

    // Getters e Setters
    public String getMaterialPrincipal() {
        return materialPrincipal;
    }

    public void setMaterialPrincipal(String materialPrincipal) {
        this.materialPrincipal = materialPrincipal;
    }

    public String getTempoProducao() {
        return tempoProducao;
    }

    public void setTempoProducao(String tempoProducao) {
        this.tempoProducao = tempoProducao;
    }
}