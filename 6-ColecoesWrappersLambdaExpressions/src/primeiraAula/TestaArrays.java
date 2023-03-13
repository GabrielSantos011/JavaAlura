package primeiraAula;

public class TestaArrays {

    public static void main(String[] args) {
        //Arrays (vetores são objetos) - uma estrutura de dados -
        //um espaço contínuo na memória para organizar e armazenar uma coleção de elementos

        //quando utilizar? pense em um programa que precisa recolher 5 idades por exemplo
        //ao invés de criar 5 variáveis de idade criamos um array

        //como declarar:
        int[] idades = new int[5]; // aqui declaramos um array com 5 espaços

        //como foi dito - são objetos
        System.out.println(idades);

        //neste caso são inicializados com 0 (valor padrão de int em objetos)
        //o primeiro indice de acesso é o 0
        //logo nesse array de 5 espaços os indices vão de 0 a 4
        System.out.println("valor no indice 0: " + idades[0]);

        //podemos acessar o tamanho do array
        System.out.println(idades.length);

        //muito comum a iteração através de um for
        for (int i = 0; i < idades.length; i++) {
            idades[i] = i*i;
        }
        for (int idade : idades) {
            System.out.println(idade);
        }

        //como vimos nosso array tem indices de 0 a 4
        //caso eu tente acessar um indice inexistente dará uma exceção
        //ArrayIndexOutOfBoundsException

        //podemos também inicializar o array de forma literal
        int[] array = {1,2,3,4,5};
        System.out.println(array[0]);

        //Arrays de referência
        ContaCorrente[] contas = new ContaCorrente[5];
        //criamos um objeto -> um array capaz de gravar 5 contas correntes
        //porém nenhuma conta corrente foi criada
        //valor inicial de uma referência em objeto é null
        System.out.println(contas[0]);

        ContaCorrente cc = new ContaCorrente(11,11);

        contas[0] = cc;

        //agora temos uma conta dentro do indice 0 do array
        //ou seja, contas[0] e cc são duas referencias distintas que apontam para o mesmo objeto
        System.out.println(cc.getAgencia());
        System.out.println(contas[0].getAgencia());

        //somente o indice 0 foi inicializado, caso haja uma tentativa de acessar algum método de conta
        //em alguma outra referencia ainda não inicializada tomaremos NullPointerException
        //System.out.println(contas[1].getConta());

        ContaCorrente cc1 = new ContaCorrente(11,11);
        ContaCorrente cc2 = new ContaCorrente(22,22);
        ContaCorrente cc3 = new ContaCorrente(33,33);
        ContaCorrente cc4 = new ContaCorrente(44,44);
        ContaCorrente cc5 = new ContaCorrente(55,55);

        ContaCorrente[] contas2 = {cc1,cc2,cc3,cc4,cc5};

        for (ContaCorrente c : contas2) {
            System.out.println(c.getConta());
        }
    }

}
