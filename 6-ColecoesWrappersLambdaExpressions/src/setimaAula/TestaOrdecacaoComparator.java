package setimaAula;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestaOrdecacaoComparator {

    public static void main(String[] args) {
        //existe uma classe Arrays que nos ajuda
        //por exemplo transformando um array em uma lista
        Conta[] array = new Conta[5];
        array[0] = new Conta(33, 33);
        array[1] = new Conta(11, 11);
        array[2] = new Conta(55, 55);
        array[3] = new Conta(22, 22);
        array[4] = new Conta(44, 44);
        List<Conta> lista = Arrays.asList(array);

        for (Conta c: lista) {
            System.out.println(c);
        }

        System.out.println("-----------------------");

        //para compararmos precisamos de uma classe que implemente a interface Comparator
        //porém essa interface nos obriga a implementar um único método (classe pequena)
        //não é necessário criar um outro arquivo para isso, aqui neste mesmo já podemos criar
        //(olhar no final)
        lista.sort(new AgenciaComparator());
        //este método sort() existe a partir do java 1.8
        //em versões anteriores para fazermos a ordenção usavamos a classe Collections
        //assim como a classe Arrays ela nos ajuda com alguns métodos úteis
        //nesta classe temos o método sort sobrecarregado
        //em uma implementação ele espera a lista e o Comparator
        //Collections.sort(lista, new AgenciaComparator());
        //e na outra você passa somente a lista, porém para que essa implementação compile e funcione
        //o tipo da lista (no caso a Conta) tem que implementar a interface Comparable
        //--------------implements Comparable<com oque vamos comparar>-------------
        //nesse caso seria: implements Comparable<Conta> - pois vamos comparar uma conta com outra conta
        //essa interface tem um único método o compareTo
        //com a mesma lógica do Comparator - ali definimos a "ordem natural"
        //caso implemente essa ordem natural podemos também chamar o método sort passando null
        //sort(null)

        for (Conta c: lista) {
            System.out.println(c);
        }
    }

}

//classe onde é implementada o método compare - generics do que vamos comparar
class AgenciaComparator implements Comparator<Conta> {

    //método onde definimos os critérios de comparação
    @Override
    public int compare(Conta c1, Conta c2) {
        //caso c1 for igual a c2
        int i = 0;

        //se c1 for menor que c2 (vir antes)
        if (c1.getAgencia() < c2.getAgencia())
            i = -1;

        if (c1.getAgencia() > c2.getAgencia())
            i = 1;

        return i;
        //funcionaria como c1.getAgencia() - c2.getAgencia()
        //ou utilizando a classe Wrapper -> Integer.compare(c1.getAgencia() - c2.getAgencia())
        //caso fosse necessário compararmos strings seria muito trabalhoso ficar definindo a ordem alfabética
        //porém existe o método compareTo -> "a".compareTo("b")
    }

}