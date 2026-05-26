package service;

import model.Avaliacao;
import model.Produtor;

public class AvaliacaoService {

    // Adicionar avaliação ao produtor
    public void adicionarAvaliacao(Avaliacao avaliacao) {

        avaliacao.getProdutor().getAvaliacoes().add(avaliacao);

    }

    // Calcular média do produtor
    public double calcularMedia(Produtor produtor) {

        if (produtor.getAvaliacoes().isEmpty()) {
            return 0;
        }

        double soma = 0;

        for (Avaliacao avaliacao : produtor.getAvaliacoes()) {
            soma += avaliacao.getNota();
        }

        return soma / produtor.getAvaliacoes().size();
    }

    // Listar avaliações do produtor
    public void listarAvaliacoesProdutor(Produtor produtor) {

        if (produtor.getAvaliacoes().isEmpty()) {
            System.out.println("Esse produtor não possui avaliações.");
            return;
        }

        for (Avaliacao avaliacao : produtor.getAvaliacoes()) {
            System.out.println(avaliacao);
        }
    }
}