package br.com.alura.consumindoApi;

import com.google.gson.annotations.SerializedName;

public class Titulo {

    //maneira de indicarmos que esse atributo no JSON tem este nome
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;

    @SerializedName("Runtime")
    private String tempo;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        //setando apenas para ter a informação
        this.tempo = "200 min";
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    @Override
    public String toString() {
        return "nome='" + nome + "'" +
                ", anoDeLancamento=" + anoDeLancamento +
                ", tempo=" + tempo;
    }

}
