package setimaAula;

public class Conta {

    public Conta(int agencia, int conta){
        this.agencia = agencia;
        this.conta = conta;
    }

    private int agencia;
    private int conta;

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Conta - agencia: " + agencia + " / número: " + conta;
    }

}
