package br.com.alura.testes.aula1;

public class CalculadoraTeste {

    public static void main(String[] args) {
        //testes automatizados
        //velocidade, diminui falhas, induz melhoria

        Calculadora c = new Calculadora();

        //verificação se o método tem o comportamento esperado em todas as situações

        //dois inteiros
        if (c.somar(1,1) == 2) {
            System.out.println("Correto");
        } else {
            System.out.println("incorreto");
        }

        //um ponto flutuante
        if (c.somar(1,1.1) == 2.1) {
            System.out.println("Correto");
        } else {
            System.out.println("incorreto");
        }

        //um negativo
        if (c.somar(-1,2) == 1) {
            System.out.println("Correto");
        } else {
            System.out.println("incorreto");
        }

        //dois negativos
        if (c.somar(-1,-1) == -2) {
            System.out.println("Correto");
        } else {
            System.out.println("incorreto");
        }
    }

}
