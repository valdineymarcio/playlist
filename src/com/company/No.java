package com.company;

public class No <T> {
    private T chave;
    private No <T> proximo,anterior;

     public No(T chave){
        this.proximo=null;
        this.anterior=null;
        this.chave=chave;

    }

    public T getChave() {

        return chave;
    }

    public void setChave(T chave) {

        this.chave = chave;
    }

    public No<T> getProximo() {

        return proximo;
    }

    public void setProximo(No<T> proximo) {

        this.proximo = proximo;
    }

    public No<T> getAnterior() {

         return anterior;
    }

    public void setAnterior(No<T> anterior) {

        this.anterior = anterior;
    }
    public boolean equals(No<T> objeto){

        return this == objeto;
    }
}

