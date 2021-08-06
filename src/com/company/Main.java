package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Playlist playlist = new Playlist();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numDeMusicasASemremAdd = Integer.parseInt(bf.readLine());

        String verificaAvancaOuVolta;
        String musica, cantor, imprimirOuRemover;
        String[] vetorSplit;

        Musica musicaAux;


        while (numDeMusicasASemremAdd > 0) {
            vetorSplit = bf.readLine().split("--");
            playlist.addMusica(vetorSplit[0], vetorSplit[1]);
            numDeMusicasASemremAdd--;
        }

        playlist.imprime();
        vetorSplit = bf.readLine().split("--");
        musicaAux = new Musica(vetorSplit[0], vetorSplit[1]);
        int verificaImprimeOuRemove = Integer.parseInt(bf.readLine());
        if (verificaImprimeOuRemove == 1) {
            verificaAvancaOuVolta = bf.readLine();
            do {


                if (verificaAvancaOuVolta.equals(">>")) {

                    musicaAux = playlist.proximaMusica(musicaAux);
                    System.out.println(">> " + musicaAux.getNomeDaMusica() + " [" + musicaAux.getNomeDoCantor() + "]");


                } else if (verificaAvancaOuVolta.equals("<<")) {
                    musicaAux = playlist.voltarMusica(musicaAux);
                    System.out.println("<< " + musicaAux.getNomeDaMusica() + " [" + musicaAux.getNomeDoCantor() + "]");
                }
                verificaAvancaOuVolta = bf.readLine();
            } while (verificaAvancaOuVolta != "0");
        } else if (verificaImprimeOuRemove == 2) {
            playlist.removerMusica(musicaAux);
        playlist.imprime();
        } else {
            System.out.println("opçao invalida");
        }
    }

}

