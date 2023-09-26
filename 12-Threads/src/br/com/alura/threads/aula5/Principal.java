package br.com.alura.threads.aula5;

public class Principal {

    public static void main(String[] args) {
        //aula que mostrará o estado wait
        //e como retirar a thread deste estado com o notify

        Banheiro banheiro = new Banheiro();

        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
        Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
        Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");
        Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
        //a limpeza é ativada a cada 20 segundos porém quando os convidados terminarem as suas necessidades
        //ela continuará eternamente...
        //para que isso não ocorra setamos que é uma tarefa Daemon, como se ela rodasse em background,
        //assim quando as outras threads pararem ela para também (como o garbage collector)
        //Threads daemon são como prestadores de serviços para outras threads.
        //Elas são usadas para dar apoio à tarefas e só são necessárias rodar quando as
        //threads "normais" ainda estão sendo executadas.
        limpeza.setDaemon(true);
        //podemos também setar que uma thread tem maior prioridade
        //até agora não setamos nada então elas tem prioridade normal
        limpeza.setPriority(Thread.MAX_PRIORITY);

        convidado1.start();
        convidado2.start();
        convidado3.start();
        convidado4.start();
        limpeza.start();

    }
}
