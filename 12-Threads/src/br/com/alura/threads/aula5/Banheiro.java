package br.com.alura.threads.aula5;

public class Banheiro {

    private boolean sujo = true;

    public void fazNumero1() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            while (this.sujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa rapida");

            dormeUmPouco(7000);

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mao");
            System.out.println(nome + " saindo do banheiro");

            this.sujo = true;
        }
    }

    public void fazNumero2() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            while (this.sujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa demorada");

            dormeUmPouco(10000);

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mao");
            System.out.println(nome + " saindo do banheiro");

            this.sujo = true;
        }
    }

    //método que devolve a chave e faz com que o thread entre em modo de espera
    private void esperaLaFora(String nome) {
        System.out.println(nome + ", eca, banheiro está sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void limpa() {

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {

            System.out.println(nome + " entrando no banheiro");

            if (!this.sujo) {
                System.out.println(nome + ", não está sujo, vou sair");
                return;
            }

            System.out.println(nome + " limpando o banheiro");
            this.sujo = false;

            dormeUmPouco(13000);

            //só pode ser chamado entro do synchronized
            this.notifyAll();

            System.out.println(nome + " saindo do banheiro");
        }
    }

    private void dormeUmPouco(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}