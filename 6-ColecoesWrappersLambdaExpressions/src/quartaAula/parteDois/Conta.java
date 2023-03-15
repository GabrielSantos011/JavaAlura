package quartaAula.parteDois;

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
    
    @Override
    public boolean equals( Object obj )
    {
        Conta c = (Conta) obj;
        
        if( !(this.conta == c.getConta()) && !(this.agencia == c.getAgencia()) )
            return false;

        return true;
    }
    
}