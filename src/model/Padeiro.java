package model;

public class Padeiro extends Produtor {

    private String tipoProducao;
    private boolean aceitaEncomenda;
    private String prazoEntrega;

    public Padeiro() {
        super();
    }

    public Padeiro(
            int id,
            String nome,
            String regiao,
            String telefone,
            String email,
            String descricao,
            String formasPagamento,
            String tipoProducao,
            boolean aceitaEncomenda,
            String prazoEntrega
    ) {
        super(id, nome, regiao, telefone, email, descricao, formasPagamento);

        this.tipoProducao = tipoProducao;
        this.aceitaEncomenda = aceitaEncomenda;
        this.prazoEntrega = prazoEntrega;
    }

    public String getTipoProducao() {
        return tipoProducao;
    }

    public void setTipoProducao(String tipoProducao) {
        this.tipoProducao = tipoProducao;
    }

    public boolean getAceitaEncomenda() {
        return aceitaEncomenda;
    }

    public void setAceitaEncomenda(boolean aceitaEncomenda) {
        this.aceitaEncomenda = aceitaEncomenda;
    }

    public String getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(String prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTipo de produção: " + tipoProducao
                + "\nAceita encomenda: " + (aceitaEncomenda ? "Sim" : "Não")
                + "\nPrazo de entrega: " + prazoEntrega;
    }

    @Override
    public String exibirDescricao() {
        return "Padeiro: " + getNome()
                + "\nDescrição: " + getDescricao()
                + "\nTipo de produção: " + tipoProducao
                + "\nAceita encomenda: " + (aceitaEncomenda ? "Sim" : "Não")
                + "\nPrazo de entrega: " + prazoEntrega;
    }
}