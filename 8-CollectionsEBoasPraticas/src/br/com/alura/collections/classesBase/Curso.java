package br.com.alura.collections.classesBase;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Curso {

    private String nome;
    private String instrutor;

    //outra implementação da list é o vector
    //utiliza arrays porém é threadsafe
    private List<Aula> aulas = new Vector<Aula>();

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public void adiciona(Aula aula) {
        this.aulas.add(aula);
    }

    //sintaxe será explicada em outro curso
    public int getTempoTotal() {
        return this.aulas.stream().mapToInt(Aula::getTempo).sum();
    }

    @Override
    public String toString() {
        return "[Curso: " + this.getNome() + ", tempo total: " + this.getTempoTotal()
                + ", aulas: + " + this.aulas + "]";
    }

}
