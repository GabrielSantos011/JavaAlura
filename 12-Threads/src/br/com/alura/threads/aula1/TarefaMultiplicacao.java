package br.com.alura.threads.aula1;

import java.util.Scanner;

public class TarefaMultiplicacao implements Runnable{
    //uma thread precisa de uma tarefa runnable (interface que nos obriga a implementar o
    //método run). É também possível que essa classe herdasse de threads, que ja implementa
    //runnable, e utilizar a propria classe porém este não é um bom exemplo de herança, visto
    //que não visaremos utilizar o polimorfismo e nem a maioria dos recursos, apenas reaproveitar o run,
    //Por isso sempre que possível evitar
    private int n1;
    private int n2;

    public TarefaMultiplicacao(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void run() {
        multiplicacao();
    }

    public void multiplicacao() {
        System.out.println("a multiplicação é: " + this.n1 * this.n2);
    }
}
