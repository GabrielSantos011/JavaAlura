package br.com.alura.threads.aula3;

public class Banheiro {

    public void fazNumero1() {

        //pega o nome da Thread atual
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        //bloco que faz com que ao estar sendo utilizado as outras threads esperem
        //sincroniza esse bloco (desse objeto)
        //executado de maneira atômica (sem interrupção)
        synchronized (this) {

            System.out.println(nome + " entrando no banheiro");
            System.out.println(nome + " fazendo coisa rapida");

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mao");
            System.out.println(nome + " saindo do banheiro");
        }
    }

    public void fazNumero2() {
        //pega o nome da Thread atual
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        //bloco que faz com que ao estar sendo utilizado as outras threads esperem
        synchronized (this) {

            System.out.println(nome + " entrando no banheiro");
            System.out.println(nome + " fazendo coisa demorada");

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mao");
            System.out.println(nome + " saindo do banheiro");
        }
    }

}