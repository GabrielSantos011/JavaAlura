package br.com.alura.collections.aula1;

import br.com.alura.collections.classesBase.Aula;
import br.com.alura.collections.classesBase.Curso;

import java.util.*;

public class Listas {

    public static void main(String[] args) {
        //no curso 6 tivemos ja aulas sobre listas
        //sabemos que tratasse de uma estrutura em que a ordem importa,
        //pode repetir itens, tem indice...

        //representação básica para lista:

        //objetos que serão adicionados
        String aula1 = "Conhecendo mais de listas";
        String aula2 = "Modelando a classe Aula";
        String aula3 = "Trabalhando com Cursos e Sets";

        //arrayList é uma implementação de List que utiliza arrays internamente
        //e não é threadsafe
        ArrayList<String> aulasStr = new ArrayList<>();

        //adicionar na lista
        aulasStr.add(aula1);
        aulasStr.add(aula2);
        aulasStr.add(aula3);

        System.out.println(aulasStr);

        //remover da lista
        aulasStr.remove(0);

        System.out.println(aulasStr);

        //foreach
        for (String aula : aulasStr) {
            System.out.println("Aula: " + aula);
        }

        //método get (pegar o objeto)
        String primeiraAula = aulasStr.get(0);
        System.out.println("A primeira aula é " + primeiraAula);

        for (int i = 0; i < aulasStr.size(); i++) {
            System.out.println("Aula: " + aulasStr.get(i));
        }

        //tamanho da lista
        System.out.println(aulasStr.size());

        //foreach com lambda
        aulasStr.forEach(aula -> System.out.println("Aula " + aula));

        aulasStr.add("Aumentando nosso conhecimento");
        System.out.println(aulasStr);

        //ordenação através da classe Collections
        //sem passagem de um Comparator, isso só Ocorre pois String
        //Implementa Comparable e define uma ordem natural
        Collections.sort(aulasStr);

        System.out.println("Depois de ordenado:");
        System.out.println(aulasStr);

        //Listas com Objetos proprios

        Aula a1 = new Aula("Revistando as ArrayLists", 21);
        Aula a2 = new Aula("Listas de objetos", 20);
        Aula a3 = new Aula("Relacionamento de listas e objetos", 15);

        //outra implementação de List que utiliza a estrutura de dados de lista duplamente encadeada
        //mais eficiente para adicionar e remover itens se comparada com ArrayList
        //porém menos eficiente nas iterações e get de indices
        LinkedList<Aula> aulas = new LinkedList<>();
        aulas.add(a1);
        aulas.add(a2);
        aulas.add(a3);

        // antes de ordenar:
        System.out.println(aulas);

        //ordenação através da classe Collections
        //novamente sem passagem de um Comparator, isso só Ocorre pois Aula
        //Implementa Comparable e define uma ordem natural
        Collections.sort(aulas);

        // depois de ordenar:
        System.out.println(aulas);

        //porém a ordem natural da classe aula é a ordem alfabética
        //podemos querer outro tipo de filtragem
        //para isso podemos usar um Comparator
        //como ja foi visto em cursos anterires aqui colocarei em um novo formato
        //teremos um curso mais para frente que explicará melhor, nesse momento vamos
        //nos conter apenas com o funcionamento - um comparator que compara com base no método
        //getTempo da classe Aula
        Collections.sort(aulas, Comparator.comparing(Aula::getTempo));

        //javas mais recentes a propria lista tem um método de ordenação
        aulas.sort(Comparator.comparing(Aula::getTempo));

        //relacionamento com outras listas

        Curso javaColecoes = new Curso("Dominando as coleções do Java",
                "Paulo Silveira");

        //utilizando o polimorfismo, o método retorna um List
        //e somente a classe Curso sabe que tipo de lista é instanciada
        //se olharmos a classe veremso que é um Vector
        //porem se colocarmos Vector aqui o código não compila
        //o método retorna um List (todos vector são List, nem todos list são vector )
        List<Aula> aulasCurso = javaColecoes.getAulas();
        System.out.println(aulasCurso);

        //o método getAulas retornando a lista normalmente, logo podemos utilizar
        //ela para utilizar e chamar métodos como adicionar, ou seja linhas como a debaixo sriam possíveis
        //javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
        //porém nem sempre é interessante permitir esse acesso livre a sua lista
        //o correto seria que houvesse "um pedido" para a classe curso para adicionar
        //e não simplesmente fazer na mão (há exceções)
        //para isso o nosso método retorna uma lista que não pode ser modifiicada
        //servindo assim para iterações e gets
        //caso eu precise alterar a lista para uma ordenação por exemplo eu faço da seguinte forma
        List<Aula> aulasImutaveis = javaColecoes.getAulas();
        System.out.println(aulasImutaveis);

        //crio um outro objeto - esse sim pode ser modificado- e nele faço as coisas
        List<Aula> aulasList = new ArrayList<>(aulasImutaveis);

        Collections.sort(aulasList);
        System.out.println(aulasList);

    }

}
