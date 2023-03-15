package quartaAula.parteUm;

import java.util.ArrayList;

public class TestaEquals
{
    
    public static void main( String[] args )
    {
        ArrayList<Conta> lista = new ArrayList<>();
        
        lista.add( new Conta(11, 11) );
        lista.add( new Conta(22, 22) );
        lista.add( new Conta(33, 33) );
        
        //temos o método contains para perguntar se a 
        //lista contém determinado parametro
        //internamente este método chama o equals 
        //(sobrescrito na classe Conta)
        System.out.println( lista.contains( new Conta(22, 22) ) );
        //caso não houvesse a sobrescrita o método compararia as referencias
        //e no caso são duas referencias diferentes retornando assim false
    }
    
}
