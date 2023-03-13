package primeiraAula;

public class ContaCorrente {
    //classe para utilizarmos arrays de referência

    private int conta;
    private int agencia;

    public ContaCorrente(int agencia, int conta) {
        this.agencia = agencia;
        this.conta = conta;
    }

    public int getConta() {
        return this.conta;
    }

    public int getAgencia() {
        return this.agencia;
    }

}
