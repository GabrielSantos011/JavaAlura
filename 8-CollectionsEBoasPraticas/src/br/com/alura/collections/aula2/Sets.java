package br.com.alura.collections.aula2;

import java.util.*;

public class Sets {

    public static void main(String[] args) {
        //outra implementação se Collection são os sets
        //sets são conjuntos
        //diferente das lists eles não tem ordem definida
        //logo não tem indices e não tem o método get
        //não é possível fazer ordenação
        //até aqui aparenta só ter desvantagens porém
        //nem em todos os casos precisamos de ordem
        //e nos conjuntos não há itens repetidos
        //e para os métodos contains, remove (que vem de Collection)
        //ele é muito mais rápidos do que as lists
        Set<String> alunos = new HashSet<>();
        //possivel pelo polimorfismo
        //Collection c = alunos;
        alunos.add("Rodrigo Turini");
        alunos.add("Alberto Souza");
        alunos.add("Nico Steppat");
        //outro Nico Steppat, exatamente igual ao anterior para testar os itens repetidos
        alunos.add("Nico Steppat");

        System.out.println(alunos);
        //repare que apareceu somente um

        //caso seja necessário podemos criar uma lista com base em um set (Collection)
        List<String> listaAlunos = new ArrayList<>(alunos);

        //assim como em list podemos programar defensivamente
        //Collections.unmodifiableSet(set) - retorna um set que não pode ser alterado
        //temos também o Collections.emptySet() que retorna um conjunto vazio
        //caso tentemos adicionar algo nele dara uma exception
        /*
        Um conjunto destinado a ser vazio não pode ter um elemento, certo?
        Então faz sentido receber essa exceção. Mas para que um conjunto vazio poderia ser útil?
        Por exemplo, imagina que você precisa representar um curso que foi cancelado
        pois não teve matriculas. Nesse caso faria sentido devolver um Collections.emptySet()
        */
        //e para trabalhar com threads (threadsafe) Collections.synchronizedSet(set);

        //há outras implementações de set e uma delas pode ser muito interessante
        //muito embora as coleções não gaurdem indices há a LinkedHashSet
        //pela maneira de implementação ela guarda de maneira ordenada

        //outro ponto interessante é que sets não tem indices
        //conseguimos iterar através de um foreach mas antes do java 5 ele não existia
        //como era feito?
        //Collection herda de Iterator e era com ele que era feito
        Iterator<String> iterador = alunos.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }

}
