package br.com.alura.novidadesImportantes.java8.methodReferences;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class TestMethodReferences {

    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");

        //no java 8 há muitos novos métodos auxiliares estáticos
        //inclusive métodos default estátios nas interfaces
        //então o código da aula anterior
        palavras.sort((s1,s2) -> Integer.compare(s1.length(), s2.length()));
        //pode se tranformar em
        palavras.sort(Comparator.comparing(s -> s.length()));
        //o método comparing recebe uma interface funcional (que pode ser transformada em lambda)
        //aqui o conceito é "palavras ordene comparando s.length()"
        //Function<String, Integer> funcao = s -> s.length();

        //agora sim Method References
        //dado um objeto retorne uma função
        palavras.sort(Comparator.comparing(String::length));

        //Method References no foreach
        //aqui ele está dando um print no objeto string
        //imaginando uma outra classe isso chamaria o toString
        //da classe, no caso de dar print em alguma outra propriedade o
        //method reference não funciona
        //foi feito para lambda bem simples
        palavras.forEach(System.out::println);
    }

}
