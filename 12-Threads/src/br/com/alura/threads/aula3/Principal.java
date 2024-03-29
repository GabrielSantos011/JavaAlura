package br.com.alura.threads.aula3;

public class Principal {

    public static void main(String[] args) {
        //aula que mostrará sincronização na execução
        //como vimos não há como determinar a ordem
        //mas podemos sincronizar, neste exemplo usamos um banheiro,
        //que apenas um por vez pode usar
        Banheiro banheiro = new Banheiro();

        //Passando a tarefa e o nome do Thread
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
        Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
        Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");

        convidado1.start();
        convidado2.start();
        convidado3.start();
        convidado4.start();

    }
}
