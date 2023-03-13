package segundaAula;

public abstract class Conta {

    private int agencia;
    private int conta;

    public Conta(int agencia, int conta) {
        this.agencia = agencia;
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

}
