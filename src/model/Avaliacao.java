package model;

public class Avaliacao {
    //Atributos
    private int id;
    private Produtor produtor;
    private String nomeConsumidor;
    private int nota;
    private String comentario;
    private String data;

    //Construtores
    public Avaliacao() {
    }

    public Avaliacao(int id, Produtor produtor, String nomeConsumidor, int nota, String comentario, String data) {
        this.id = id;
        this.produtor = produtor;
        this.nomeConsumidor = nomeConsumidor;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }
    
    //Método toString
    public String toString() {
        return "Id: " + id + "\nProdutor: " + produtor.getNome() + "\nConsumidor: " + nomeConsumidor + "\nNota: "+ nota + "\nComentario: " + comentario + "\nData='" + data;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }


    public String getNomeConsumidor() {
        return nomeConsumidor;
    }

    public void setNomeConsumidor(String nomeConsumidor) {
        this.nomeConsumidor = nomeConsumidor;
    }


    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }


    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
