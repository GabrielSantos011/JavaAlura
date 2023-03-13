package segundaAula;

public class TestaArray {

    public static void main(String[] args) {
        //utilizando o polimorfismo podemos criar arrays mais genéricos

        //criando um array de Contas onde podemos colocar CC ou CP
        Conta[] contas = new Conta[3];

        contas[0] = new ContaCorrente(11,11);
        contas[1] = new ContaCorrente(22,22);
        contas[2] = new ContaPoupanca(33,33);

        //um pouco sobre cast
        //logo no ínicio vimos um pouco sobre cast em tipos primitivos
        int a = 3;
        double b = a; //ocorreu um cast implicito

        b = 3.5;
        a = (int) b; //cast explicito

        //podemos fazer cast com objetos também, por exemplo:
        //ContaCorrente cc = contas[0];
        //o código acima não compila pois o array de Conta permitiria que a referência fosse tanto de CP
        //como de CC, porém nós sabemos que em contas[0] há uma CC então fazemos um cast
        ContaCorrente cc = (ContaCorrente) contas[0];
        //este foi um cast possível
        //porém devemos tomar cuidado pois
        //ContaCorrente cc = (ContaCorrente) contas[2];
        //também é um cast possível (passa pelo compilador) mas ao executarmos tomaremos uma exceção
        //ClassCastException
        //já que em contas[2] temos uma CP e estamos fazer o cast para uma CC

        //existe cast impossível
        //Cliente c = new Cliente("Gabriel");
        //ContaCorrente cc1 = (ContaCorrente) c;
        //este seria um cast impossível, o compilador nem deixa passar
        //já que uma referencia do tipo conta em hipótese alguma aponta para um objeto do tipo cliente
    }

}
