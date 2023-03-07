package quintaAula;
//falaremos sobre construtores e sobre static

public class Conta {

    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    //imagine que fosse interessante saber o número total de contas criadas
    //para isso deveríamos criar um atributo total, porém este atributo seria de instância
    //e a cada vez que fosse dado o new seria um novo atributo (cada objeto teria um atributo total),
    //esse não é nosso objetivo. Para conseguirmos um total de contas precisamos de um atributo que
    //não é do objeto e sim da classe e para isso usamos o static
    private static int total;

    //construtores:
    /*
    Os construtores não são métodos (não tem retorno em sua assinatura), mas sim uma rotina de inicialização.
    Eles são chamados de maneira única ao se inicializar um objeto.
    Por padrão o java já nos fornece o construtor padrão (caso não deixe ele explícito), que seria o:
    public Conta(){}, porém ao definirmos um construtor diferente o java deixa de nos fornecer.
    Podemos ter quantos construtores quisermos. Podemos fazer diversas ações mas de maneira geral utilizamos
    para inicialização de atributos primordiais, que não poderiam estar vazios.
    No caso da Conta é interessante que tenhamos uma agência e conta logo ao inicializar o objeto
     */
    public Conta(int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;

        total++;

        //para acessarmos um atributo da classe usamos o nome dela,
        //até funcionaria chamando através de um objeto mas não faria sentido
        System.out.println("Esta é a  " + Conta.total + "° conta");
    }

    public void deposita(double valor) {
        if ( valor > 0 )
            this.saldo += valor;
    }

    public boolean saca(double valor){
        if ( valor <= this.saldo && valor > 0 ) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transfere(double valor, Conta destino){
        if ( valor <= this.saldo && valor > 0 ) {
            this.saldo -= valor;
            destino.deposita(valor);
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    //como estamos falando de um atributo estático, devemos dar acesso nele através da classe e não
    //de uma instancia, logo o método também será static
    public static int getTotal() {
        return total;
    }

}
