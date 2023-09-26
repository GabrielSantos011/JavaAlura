package br.com.alura.threads.aula5;

public class TarefaLimpeza implements Runnable {

    private Banheiro banheiro;

    public TarefaLimpeza(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    public void run() {
        while (true) {
            this.banheiro.limpa();

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}