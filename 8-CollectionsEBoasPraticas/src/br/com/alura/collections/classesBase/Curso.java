package br.com.alura.collections.classesBase;

import java.util.*;

public class Curso {

    private String nome;
    private String instrutor;
    private  Set<Aluno> alunos = new HashSet<>();

    //outra implementação da list é o vector
    //utiliza arrays porém é threadsafe
    private List<Aula> aulas = new Vector<Aula>();
    private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public void matricula(Aluno aluno) {
        // adiciona no Set de alunos
        this.alunos.add(aluno);
        // cria a relação no Map
        this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
    }

    public Aluno buscaMatriculado(int numero) {
        return this.matriculaParaAluno.get(numero);
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
