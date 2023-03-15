package quartaAula.parteDois;

import java.util.LinkedList;
import java.util.List;

public class TestaLinkedList
{
    
    public static void main( String[] args )
    {
        //podemos usar o polimorfismo através da interface List
        //AraayList é uma lista (possui as propriedades de lista como
        //guardar os itens em ordem, permite itens iguais, entre outros) 
        //que internamente trabalha com vetores.
        //porém há outra maneira de se implementar lista
        //LinkedList que trabalha com a estrutura de dados 
        //lista duplamente encadeada
        //ArrayList por utilizar vetores tem melhor eficiencia nas iterações
        //e busca de indices específicos
        //já o LinkedList tem vantagem ao incluir ou excluir 
        //indices de qualquer posição
        List<Conta> lista = new LinkedList<>();
        
        lista.add( new Conta(11, 11) );
        lista.add( new Conta(22, 22) );
        lista.add( new Conta(33, 33) );
        
        System.out.println( lista.contains( new Conta(22, 22) ) );
    }
    
}
