package br.com.alura.novidadesImportantes.java8.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TestLambdas {

    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");

        //no dia a dia, diferente doq foi implementado no TestDefaultMethods,
        //quando temos uma classe que implementa apenas uma funcionalidade
        //e que não será reaproveitada em outras partes do código
        //utilizavamos classes anonimas
        //(new em uma interface nos obrigando a implementar os métodos ali)
        //e no caso do forEach nem guardávamos em um consumidor, jogavamos direto
        //no método
        palavras.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //porém agora para esses casos em que temos uma interface com apenas um método a ser implementado
        //o java 8 traz um recurso novo - lambdas
        //para que eu daria um new em Consumer se o método forEach recebe um consumer? é obvio que se trata
        //de um consumer. Mais do que isso, Consumer só tem o método accept, então novamente é obvio que
        //vamos implementa-lo

        //para isso a sintaxe fica da seguinte forma    (-> simbolo do lambda)
        palavras.forEach((String s) -> {
            System.out.println(s);
        });

        //esse foi nosso primeiro lambda, porém ele tem alguns parametros que não são obrigatórios como:

        //nesse caso só temos um parametro então não é necessário o parenteses
        //o java consegue inferir o tipo logo não precisamos passar String
        //e como o código dentro das chaves tem apenas uma linha elas e o ponto e virgula não são necessários
        palavras.forEach(s -> System.out.println(s));

        //outro exemplo
        //para o sort feito na TestDefaultMethods para comparar por tamanho

        //como classe anonima ficaria assim
        palavras.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() < s2.length())
                    return -1;
                if(s1.length() > s2.length())
                    return 1;
                return 0;
            }
        });

        //novamente temos uma interface funcional
        //(com apenas um método abstrato)
        //logo podemos aplicar lambda
        palavras.sort((String s1, String s2) -> {
            if(s1.length() < s2.length())
                return -1;
            if(s1.length() > s2.length())
                return 1;
            return 0;
        });

        //simplificando
        //desta vez ele precisa dos parenteses pois temos mais de um parametro
        //mas os tipos ele consegue inferir (na grande maioria dos casos)
        palavras.sort((s1,s2) -> {
            if(s1.length() < s2.length())
                return -1;
            if(s1.length() > s2.length())
                return 1;
            return 0;
        });

        //não tiramos as chaves pois não é um comando de uma linha
        //mas podemos melhorar e transformar isso em uma linha
        //como só tem uma linha o return também não é obrigatório

        palavras.sort((s1,s2) -> Integer.compare(s1.length(), s2.length()));

        //tipo do lambda
        Comparator<String> comparator = (s1,s2) -> Integer.compare(s1.length(), s2.length());
        //intreface funcional

        //mas não é um object comum
        //Object o = (s1,s2) -> Integer.compare(s1.length(), s2.length());
        //não compila porque Object não é uma interface funcional.
    }

}
