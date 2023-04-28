package br.com.alura.collections.classesBase;

import java.util.Objects;

public class Aula implements Comparable<Aula> {

    private String titulo;
    private int tempo;

    public Aula(String titulo, int tempo) {
        this.titulo = titulo;
        this.tempo = tempo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTempo() {
        return tempo;
    }

    @Override
    public int compareTo(Aula outraAula) {
        return this.titulo.compareTo(outraAula.titulo);
    }

    //método para transformar o objeto em uma string (o que vai ser mostrado ao dar um System.out.println())
    @Override
    public String toString() {
        return "[Aula: " + this.titulo + ", " + this.tempo + " minutos]";
    }

    //equals é um método que define em que condições um objeto seria igual ao outro
    //segundo a implementação da classe Object ele vai comparar as referencias
    //ou seja ao dar um novo new estamos falando de outro objeto
    //mas nem sempre é o caso então sobrescrevemos definindo a regra
    //além de poder ser usado de maneira direta se tratando de Collection o contains()
    //utiliza o equals por baixo dos panos
    @Override
    public boolean equals(Object obj) {
        Aula outra = (Aula) obj;

        return ( this.titulo.equals(outra.titulo) && this.tempo == outra.tempo );
    }

    //ao reescrever o equals devemos reescrever o hashcode
    //para lists isso não interfere mas quando utilizamos sets ele é de extrema importância
    //Imagine que cada vez que você adiciona algo dentro do seu Set para espalhar os objetos
    //um número mágico é gerado e todos os objetos que o tenham são agrupados.
    //E ao buscar, em vez de comparar o objeto com todos os outros objetos contidos
    //dentro do Set (isso daria muitas comparações), ele gera novamente o mesmo número mágico,
    //e compara apenas com aqueles que também tiveram como resultado esse número.
    //Ou seja, ele compara apenas dentro do grupo de semelhança.
    //caso não sobrescreva a classe object gera um diferente a cada new
    @Override
    public int hashCode() {
        //guardando na tabela de espalhamento com base na inicial do titulo
        //ou seja serão agrupados todos com mesma inicial
        return this.titulo.charAt(0);
        //aqui foi só um exemplo, o ideal poderia ser utilizar o hashCode da propria classe String
    }
}

