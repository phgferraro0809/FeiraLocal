package model;

public class Artesao extends Produtor {

    // Atributos específicos do artesão
    private String tipoArtesanato;
    private String materialPrincipal;
    private boolean aceitaEncomenda;

    // Construtor vazio
    public Artesao() {
        super();
    }

    // Construtor completo
    public Artesao(
            int id,
            String nome,
            String regiao,
            String telefone,
            String email,
            String descricao,
            String formasPagamento,
            String tipoArtesanato,
            String materialPrincipal,
            boolean aceitaEncomenda
    ) {
        super(id, nome, regiao, telefone, email, descricao, formasPagamento);

        this.tipoArtesanato = tipoArtesanato;
        this.materialPrincipal = materialPrincipal;
        this.aceitaEncomenda = aceitaEncomenda;
    }

    public String getTipoArtesanato() {
        return tipoArtesanato;
    }

    public void setTipoArtesanato(String tipoArtesanato) {
        this.tipoArtesanato = tipoArtesanato;
    }

    public String getMaterialPrincipal() {
        return materialPrincipal;
    }

    public void setMaterialPrincipal(String materialPrincipal) {
        this.materialPrincipal = materialPrincipal;
    }

    public boolean isAceitaEncomenda() {
        return aceitaEncomenda;
    }

    public void setAceitaEncomenda(boolean aceitaEncomenda) {
        this.aceitaEncomenda = aceitaEncomenda;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTipo de artesanato: " + tipoArtesanato
                + "\nMaterial principal: " + materialPrincipal
                + "\nAceita encomenda: " + (aceitaEncomenda ? "Sim" : "Não");
    }

    @Override
    public String exibirDescricao() {
        return "Artesão: " + getNome()
                + "\nDescrição: " + getDescricao()
                + "\nTipo de artesanato: " + tipoArtesanato
                + "\nMaterial principal: " + materialPrincipal
                + "\nAceita encomenda: " + (aceitaEncomenda ? "Sim" : "Não");
    }
}