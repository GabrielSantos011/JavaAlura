package br.com.alura.testes.aula1;

public class Calculadora {

    public double somar(double a, double b) {
        return a+b;
    }

    //método para teste com exception
    public double subtrai(double a, double b) {
        if (a == 0.0 || b == 0.0) {
            throw new IllegalArgumentException("Não pode 0");
        }
        return a-b;
    }
}
