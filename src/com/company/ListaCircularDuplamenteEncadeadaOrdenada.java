package com.company;

public class ListaCircularDuplamenteEncadeadaOrdenada<T extends Comparable<T>> {

    private No<T> inicio;
    private int tamanho;

    public ListaCircularDuplamenteEncadeadaOrdenada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public boolean estaNulo(No<T> objeto) {

        return objeto == null;
    }

    public boolean estaVazia() {


        return estaNulo(this.inicio);
    }

    private No<T> criaNo(T objeto) {
        return new No<>(objeto);
    }

    private void adicionaPrimeiroNo(No<T> novo) {
        novo.setAnterior(novo);
        novo.setProximo(novo);
        this.inicio = novo;
    }

    public No<T> getInicio() {
        return inicio;
    }

    public void setInicio(No<T> inicio) {
        this.inicio = inicio;
    }


    public int getTamanho() {
        return tamanho;
    }

    private No<T> buscaPosicaoParaInserir(T chave) {
        No<T> ponteiro = null;
        if (!estaVazia()) {
            ponteiro = this.inicio;
            while (!ponteiro.getProximo().equals(this.inicio) && chave.compareTo(ponteiro.getChave()) > 0) {
                ponteiro = ponteiro.getProximo();
            }
        }
        return ponteiro;
    }

    private void insereDepoisDoPtr(No<T> novo, No<T> ptr) {
        insereAntesDoPtr(novo, ptr.getProximo());
    }

    private void insereAntesDoPtr(No<T> novo, No<T> ptr) {
        novo.setAnterior(ptr.getAnterior());
        novo.setProximo(ptr);
        ptr.getAnterior().setProximo(novo);
        ptr.setAnterior(novo);
    }

    public void insere(T chave) {
        No<T> novo = criaNo(chave);
        if (estaVazia()) {
            this.adicionaPrimeiroNo(novo);
        } else {
            No<T> retornoDaBusca = buscaPosicaoParaInserir(chave);
            if (chave.compareTo(retornoDaBusca.getChave()) > 0) {
                this.insereDepoisDoPtr(novo, retornoDaBusca);
            } else {
                this.insereAntesDoPtr(novo, retornoDaBusca);
                if (retornoDaBusca.equals(this.inicio)) {
                    this.inicio = novo;
                }
            }
        }
        this.tamanho += 1;
    }

    public No<T> buscaNo(T chave) {
        No<T> retornoDaBusca = buscaParaRemover(chave);
        if (!estaNulo(retornoDaBusca)) {
            return retornoDaBusca;
        }
        return null;
    }

    public T busca(T chave) {
        No<T> retornoDaBusca = buscaParaRemover(chave);
        if (!estaNulo(retornoDaBusca)) {
            return retornoDaBusca.getChave();
        }
        return null;
    }

    private No<T> buscaParaRemover(T chave) {
        No<T> retornoDaBusca = buscaPosicaoParaInserir(chave);
        if (!estaNulo(retornoDaBusca) && retornoDaBusca.getChave().compareTo(chave) == 0) {
            return retornoDaBusca;
        }
        return null;
    }

    private void removePtr(No<T> ptr) {
        ptr.getAnterior().setProximo(ptr.getProximo());
        ptr.getProximo().setAnterior(ptr.getAnterior());
    }

    public No<T> remove(T chave) {
        No<T> retornoDaBusca = buscaParaRemover(chave);
        if (!estaNulo(retornoDaBusca)) {
            if (this.tamanho == 1) {
                this.inicio = null;
            } else {
                this.removePtr(retornoDaBusca);
                if (retornoDaBusca.equals(this.inicio)) {
                    this.inicio = this.inicio.getProximo();
                }
                this.tamanho -= 1;
            }
            return retornoDaBusca;
        }
        return null;
    }

    public void imprime() {
        No<T> ptr = this.inicio;
        System.out.println("LISTA----");
        while (!estaNulo(ptr)) {
            System.out.print(ptr.getChave().toString() + " ");
            ptr = ptr.getProximo();
        }
        System.out.println("-----------");
    }
}
