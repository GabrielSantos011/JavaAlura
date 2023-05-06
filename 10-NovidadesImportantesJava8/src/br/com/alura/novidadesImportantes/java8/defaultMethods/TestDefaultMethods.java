package br.com.alura.novidadesImportantes.java8.defaultMethods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TestDefaultMethods {

    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");

        Comparator<String> comparador = new ComparadorDeStringPorTamanho();

        //antes não poderíamos adicionar um método em uma lista pois todas as classes que
        //a implementam seriam obrigadas a implementar também (quebraria ou seria
        //muito trabalhoso para ser feito)
        //porém no java 8 surgiu os defaults methods nas interfaces
        //ou seja, métodos já implementados
        //na interface list por exemplo surgiram alguns
        //2 deles mais utilizados são o sort e o foreach
        palavras.sort(comparador);

        Consumer<String> consumidor = new ConsumidorDeString();
        palavras.forEach(consumidor);

        //outro ponto interessante foi que interfaces passam a poder ter constantes
        //(ex: public static final CONSTANTE = 1)
    }

}

class ComparadorDeStringPorTamanho implements Comparator<String> {
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;
        return 0;
    }
}

class ConsumidorDeString implements Consumer<String> {
    public void accept(String s) {
        System.out.println(s);
    }
}