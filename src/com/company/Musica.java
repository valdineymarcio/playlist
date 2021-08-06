package com.company;

public class Musica implements Comparable<Musica> {
    private String nomeDaMusica;
    private String nomeDoCantor;


    public String getNomeDaMusica() {

        return nomeDaMusica;
    }

    public void setNomeDaMusica(String nomeDaMusica) {

        this.nomeDaMusica = nomeDaMusica;
    }

    public String getNomeDoCantor() {

        return nomeDoCantor;
    }

    public void setNomeDoCantor(String nomeDoCantor) {

        this.nomeDoCantor = nomeDoCantor;
    }

    public Musica(String nomeDaMusica, String nomeDoCantor) {
        this.nomeDaMusica = nomeDaMusica;
        this.nomeDoCantor = nomeDoCantor;
    }

    @Override
    public int compareTo(Musica o) {
        int retornoDaComparacaoDosNomesDasMusicas = this.nomeDaMusica.compareToIgnoreCase(o.getNomeDaMusica());
        if (retornoDaComparacaoDosNomesDasMusicas == 0) {
            return this.nomeDoCantor.compareToIgnoreCase(o.getNomeDoCantor());
        }
        return retornoDaComparacaoDosNomesDasMusicas;
    }

    @Override
    public String toString() {

        return this.nomeDaMusica +  " [" + this.nomeDoCantor + "]";
    }

    public void imprime() {

        System.out.println(this.nomeDaMusica + " -- " + this.nomeDoCantor);
    }
}
