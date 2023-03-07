package terceiraAula;

public class Conta {

    double saldo;
    int agencia;
    int numero;
    //embora String já fosse uma váriavel do tipo referência, não havíamos explorado muito até agora.
    //Da maneira que estava toda conta teria referencia a uma String titular, ou seja, um nome
    //mas para uma conta seria mais interessante ter outras informações do nosso titular além do nome, como
    //por exemplo o cpf.
    //Porém não é legal colocarmos este campo cpf na classe conta pq uma conta tem cpf? não!!
    //logo é melhor criarmos uma classe cliente e aqui em conta termos uma variavel de referencia para ela
    Cliente titular;

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public boolean saca(double valor){
        if (valor <= this.saldo){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transfere(double valor, Conta destino){
        if (valor <= this.saldo) {
            this.saldo -= valor;
            destino.deposita(valor);
            return true;
        }
        return false;
    }

}