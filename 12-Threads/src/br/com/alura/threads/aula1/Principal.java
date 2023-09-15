package br.com.alura.threads.aula1;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        //a jvm já utiliza threads mesmo que a gente não soubesse do recurso.
        //para rodar a main, garbage colector e outras situações
        //a prova disso é que podemos fazer a nossa main "dormir" por alguns segundos
        System.out.println("olá!");
        //método tem uma exception checked
        Thread.sleep(10000);
        System.out.println("se passaram 10 segundos!");

        //criando a tarefa (que implementa runnable)
        TarefaMultiplicacao tarefaMultiplicacao = new TarefaMultiplicacao(2,2);
        //criando a thread
        Thread threadMultiplicacao = new Thread(tarefaMultiplicacao);
        //iniciando a Thread
        threadMultiplicacao.start();

    }

}
