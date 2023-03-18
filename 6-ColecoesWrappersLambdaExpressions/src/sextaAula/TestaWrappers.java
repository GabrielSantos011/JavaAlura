package sextaAula;

import java.util.ArrayList;
import java.util.List;

public class TestaWrappers {

    public static void main(String[] args) {
        //aprendendo sobre os Wrappers

        //perceba que neste curso começamos com os arrays
        //e neles podemos ter arrays de primitivos e de referencias
        //como:
        int[] arrayNumeros = new int[5];
        String[] strings = new String[5];

        //porém nas Listas só podemos receber referências
        //ou seja não ha lista de primitivos
        List lista = new ArrayList();
        //repare que nessa lista o método add espera um Object
        //logo se dessemos um add(1) deveria dar errado
        //mas vamos testar isso...
        lista.add(1);
        //deu certo? Sim. Por que isso acontece?
        //no java para cada tipo primitivo há uma classe wrapper (um objeto que
        //internamente guarda o valor primitivo)
        //----------------------
        //byte    - Byte
        //short   - Short
        //int     - Integer
        //long    - Long
        //float   - Float
        //double  - Double
        //char    - Character
        //boolean - Boolean
        //----------------------
        //obs: essas classes pertencem ao java.lang portanto n precisamos importar
        //----------------------
        //e temos uma coisa chamada Autoboxing e Unboxing
        //ou seja quando passamos um add(1) em um lugar que espera um objeto
        //o java internamente faz um autoboxing ou seja, como se ele desse um 'new Integer(1)'
        //repare que esse código ainda funciona porém ja está depreciado (não é a melhor maneira
        //de instanciarmos um Wrapper)
        Integer integer = new Integer(1);
        //e o unboxing é a situação ao inversa
        int i = integer;
        //ou seja, jogamos um objeto dentro de um primitivo

        //alguns métodos da Integer (por exemplo):

        //vimos que o construtor não é a melhor maneira de inicializarmos
        //então como deve ser feito
        integer = Integer.valueOf(1);// autoboxing
        integer++;//funciona (acontece o unboxin e o autoboxing aqui)

        //para pegar o primitivo
        i = integer.intValue();//unboxing

        //o método valueOf que vimos acima tem algumas variações
        //no caso anterior ele tranforma um int em um Integer
        //porém podemos transformar uma String em um Integer
        integer = Integer.valueOf("11");

        //podemos também transformar uma string direto em um int
        i = Integer.parseInt("3");

        //podemos transformar nosso integer em algum outro tipo primitivo por exemplo:
        double d = integer.doubleValue();

        //temos algumas constantes também

        //valor maximo que pode ser guardado
        System.out.println(Integer.MAX_VALUE);
        //menor número que pode ser guardado
        System.out.println(Integer.MIN_VALUE);
        //numero de bits
        System.out.println(Integer.SIZE);
        //número de bytes
        System.out.println(Integer.BYTES);

        //há diversos outros métodos - olhar o javadoc
        //de uma maneira geral conhecendo um wrapper você conhece os outros
        //porém uma curiosidade legal de Boolean
        Boolean b = Boolean.valueOf(false);
        //como no boolean só deveria existir dois valores (true e false) há constantes
        //então podemos fazer:
        b = Boolean.FALSE;

        //outro ponto importante é que todas as classes wrapper que representam valores
        //inteiros e de ponto flutuante extendem de Number
        //ou seja, podemos usar o polimorfismo:
        Number numero = Integer.valueOf(1);

        //pode ser muito util em uma lista por exemplo (pois aceitará todos os tipos de numeros)
        List<Number> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(1.1);
        numeros.add(2l);
        numeros.add(2.1f);
    }

}
