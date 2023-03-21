package oitavaAula.parteUm;

import setimaAula.Conta;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestaClassesAnonimas {

    public static void main(String[] args) {
        //na aula anterior vimos a implementação de uma outra classe sem a necessidade
        //de criação de mais um arquivo .java
        //classes como aquelas que só encapsulam um método ao serem instanciadas
        //são chamadas de function objects
        //e há algumas alternativas no java para que não seja mais necessário ficar criando classes como
        //estas (não são chamadas fora deste código - diferente da classe conta por exemplo)
        //veremos agora as classes anonimas

        List<Conta> lista = new ArrayList<>();

        lista.add(new Conta(33, 33));
        lista.add(new Conta(11, 11));
        lista.add(new Conta(22, 22));

        for (Conta c: lista) {
            System.out.println(c);
        }

        //para fazer a ordenação ao invés de criarmos uma classe diferente criaremos ela diretamente aqui
        lista.sort( new Comparator<Conta>() {
            @Override
            public int compare(Conta c1, Conta c2) {
                return Integer.compare(c1.getAgencia(), c2.getAgencia());
            }
        }
        );
        //cuidado para que não haja confusão, o código acima não está instanciando uma interface,
        //mas sim criando uma classe em tempo de execução e instanciando ela
        //isso pode ser feito para qualquer implementação de interface

        for (Conta c: lista) {
            System.out.println(c);
        }

        //importante reparar que podemos colocar este objeto instanciado em uma variavel de referencia
        Comparator<Conta> c = new Comparator<Conta>() {
            @Override
            public int compare(Conta c1, Conta c2) {
                return Integer.compare(c1.getAgencia(), c2.getAgencia());
            }
        };
    }

}