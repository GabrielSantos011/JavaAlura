package oitavaAula.parteDois;

import setimaAula.Conta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TesteLambdas {

    public static void main(String[] args) {
        //uma breve introdução aos lambdas

        List<Conta> lista = new ArrayList<>();

        lista.add(new Conta(33, 33));
        lista.add(new Conta(11, 11));
        lista.add(new Conta(22, 22));

        for (Conta c: lista) {
            System.out.println(c);
        }

        //as sintaxes de classes anonimas são complexas
        //para algo mais clean usamos lambdas
        //internamente o java continua criando uma classe anonima mas a sixtaxe é mais amigavel
        //colocamos diretamente os parametros do método compare
        //adicionamos uma ->
        //adcionamos oq o método deve fazer
        lista.sort( (Conta c1, Conta c2) -> {
                            return Integer.compare(c1.getAgencia(), c2.getAgencia());
                    }
        );

        //para casos simples de uma linha podemos simplificar ainda mais
        //removendo as chaves, o return e o ;
        lista.sort( (Conta c1, Conta c2) -> Integer.compare(c1.getAgencia(), c2.getAgencia()) );

        //ainda há como simplificar mais ainda
        //a lista é de contas então ela sabe que vai receber uma conta
        //não sendo mais necessário deixar explícito
        lista.sort( (c1, c2) -> Integer.compare(c1.getAgencia(), c2.getAgencia()) );

        //usando lambda para foreach
        //assim como o sort precisam da implementação de uma interface
        //neste caso um consumer
        //sem lambdas ficaria assim
        //lista.forEach(new Consumer<Conta>() {
        //    @Override
        //    public void accept(Conta conta) {
        //        System.out.println(conta);
        //    }
        //});
        //utilizando lambdas
        lista.forEach((c) -> System.out.println(c));

        //apenas demonstrando que podemos colocar em variaveis de referencia
        Comparator<Conta> c = (c1,c2) -> Integer.compare(c1.getAgencia(), c2.getAgencia());
    }

}
