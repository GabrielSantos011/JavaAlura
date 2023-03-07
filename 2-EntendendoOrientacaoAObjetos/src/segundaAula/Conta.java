package segundaAula;

public class Conta {

    double saldo;
    int agencia;
    int numero;
    String titular;

    //vamos aos métodos
    //métodos são oque o objeto faz

    //estrutura de um método
    //ignorar public por enquanto
    //o que o método retorna nomeMetodo(Parametros)
    //podemos retornar tipos primitivos, de referência
    //e podemos retornar 'nada'-> neste caso seria void

    //não retorna nada
    public void deposita(double valor) {
        //a classe é um molde para um objeto como já vimos, porém a partir dela
        //podemos gerar mais de um objeto, então nos métodos
        //é comum para acessar os atributos usarmos o this, dizendo assim que o atributo
        //do objeto instanciado que está sendo alterado

        this.saldo += valor;
        //this.saldo = this.saldo + valor
    }

    //retorna um boolean
    public boolean saca(double valor){
        if (valor <= this.saldo){
            this.saldo -= valor;
            //this.saldo = this.saldo + valor

            //retornando o boolean
            return true;
        }
        //caso ele não tenha saldo suficiente ele não entrará no if,
        //e assim não passará pelo return,
        //então devemos colocar um return aqui para a negativa
        //(poderia ser num else)
        return false;
    }

    //mais de um parametro
    public boolean transfere(double valor, Conta destino){
        if (valor <= this.saldo) {
            this.saldo -= valor;
            destino.deposita(valor);
            return true;
        }
        return false;
    }

}
