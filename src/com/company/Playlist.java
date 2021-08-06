package com.company;

public class Playlist {

    ListaCircularDuplamenteEncadeadaOrdenada<Musica> listaDeMusicas;

    public Playlist() {

        listaDeMusicas = new ListaCircularDuplamenteEncadeadaOrdenada<>();
    }

    public void addMusica(String nomeMusica, String nomeCantor) {
        this.listaDeMusicas.insere(new Musica(nomeMusica, nomeCantor));
    }

    public void removerMusica(Musica musica) {

        this.listaDeMusicas.remove(musica);
    }

    public Musica proximaMusica(Musica musica) {
        No<Musica> musicaBuscada = listaDeMusicas.buscaNo(musica);
        if (musicaBuscada != null) {
            return musicaBuscada.getProximo().getChave();
        }
        return null;
    }

    public Musica voltarMusica(Musica musica) {
        No<Musica> musicaBuscada = listaDeMusicas.buscaNo(musica);
        if (musicaBuscada != null) {
            return musicaBuscada.getAnterior().getChave();
        }
        return null;
    }

    public void imprime() {
        No<Musica> ponteiroMusica =
                this.listaDeMusicas.getInicio();
        System.out.println("-----------------PlayList-----------------");
        if (!this.listaDeMusicas.estaVazia()) {
            do {
                System.out.println(ponteiroMusica.getChave().toString());
                 ponteiroMusica = ponteiroMusica.getProximo();
            } while (ponteiroMusica != this.listaDeMusicas.getInicio());
        }
        System.out.println("-------------------------------------------\n");
    }

//    public void inserir( Musica musica){
//        No<Musica> novo= new No(musica,null,null);
//        novo.setChave(musica);
//
//        if(estaVazia()){
//            novo.setProximo(novo);
//            novo.setAnterior(novo);
//            inicio=novo;
//        }else{
//            No tpm=inicio;
//
//            while (tpm.getProximo()!=inicio){
//                tpm = tpm.getProximo();
//            }
//            tpm.setProximo(novo);
//            tpm.setAnterior(tpm);
//            novo.setProximo(inicio);
//        }
//    }
}


