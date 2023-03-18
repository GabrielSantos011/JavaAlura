package quintaAula;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class VectorECollections {

    public static void main(String[] args) {
        //Vector é mais uma implementação da interface List
        //assim como o array ele também utiliza arrays em sua base.
        //sua diferença é que ele é threadsafe
        List<String> vector = new Vector<>();
        vector.add("a");
        vector.add("b");
        vector.add("c");
        for (String s: vector) {
            System.out.println(s);
        }

        //outra coisa interessante é que como vimos a lista guarda sequencia (tem indices)
        //e permitem dados repetidos, porém existem outras estruturas de dados com características
        //diferentes (veremos em cursos mais avançados)
        //porém apenas uma pitada:
        //se existem outras estruturas de dados diferentes de listas elas não podem implementar List
        //então temos uma classe ainda mais genérica que é a Collection
        //ou seja, listas são Collections
        Collection<String> collection = new Vector<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        for (String s: collection) {
            System.out.println(s);
        }
        //porém vale a pena se atentar em quando utilizar esse tipo de polimorfismo pois a interface
        //List implementa alguns métodos que não são implementados em Collection
    }

}
