package br.com.alura.java.io.sextaAula.parteDois;

//classe usada para demonstrar como serializar qualquer objeto

import java.io.Serializable;

//para uma classe poder utilizar a serialização ela deve implementar Serializable
//(uma interface de marcação, ou seja não há métodos para serem implementados)
public class Cliente implements Serializable {

    //este atributo não é obrigatório pois caso não seja colocado o java faz por debaixo dos panos
    //funciona como se fosse uma versão da classe. Caso haja a serialização de uma classe e antes de ocorrer
    //a deserialização ocorra uma mudança de estrutura a classe antiga não pode funcionar mais.
    //caso deixe que o java faça de maneira ímplicita qualquer mínima mudança o java ira gerar um outro UID
    //por isso é recomendavel colocar e gerir de maneira própria
    //*serialização com herança - caso a classe mãe seja serializavel todas as filhas herdam
    //porém caso seja uma classe filha a classe mãe também deverá ser
    //*serialização com associação - a classe associada deve implementar Serializable
    //ou colocarmos a palavra chave transient para que ela seja ignorada
    //ex: private transient Tipo nome
    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private String profissao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}

