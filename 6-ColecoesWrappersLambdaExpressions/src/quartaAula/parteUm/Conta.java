package quartaAula.parteUm;

public class Conta
{
    
    private int agencia;
    private int conta;
    
    public Conta(int agencia, int conta) {
        this.agencia = agencia;
        this.conta = conta;
    }
    
    public int getAgencia( )
    {
        return agencia;
    }
    
    public int getConta( )
    {
        return conta;
    }
    
    //sobrescrevendo o método equals
    //método utilizado para comparar os objetos
    //o padrão vem de Object - compara somente as referencias
    //alterando para que caso a agencia e conta sejam iguais retorne true
    //ou seja, podemos ter dois objetos distintos no meio do código
    //porém caso eles se enquadrem nessa condição estamos 
    //falando da mesma conta!
    @Override
    public boolean equals( Object obj )
    {
        Conta c = (Conta) obj;
        
        if( !(this.conta == c.getConta()) && !(this.agencia == c.getAgencia()) )
            return false;

        return true;
    }
    
}