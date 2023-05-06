package br.com.alura.novidadesImportantes.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreams {

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        //compare cursos comparando o getAlunos
        cursos.sort(Comparator.comparingInt(Curso::getAlunos));

        //agora streams
        //foram criados para trabalharmos melhor com collections
        //toda colection tem um método stream
        //devolve um "fluxo de objetos", "uma maneira de se trabalhar com objetos"
        //e com ele tesmos vários métodos que podem nos ajudar

        //exemplo de filtro
        cursos.stream().filter(c -> c.getAlunos() >=100);

        //ao darmos um print esperamos 2 cursos

        cursos.forEach(c -> System.out.println(c.getNome()));

        //porém aparentemente não funcionou, retornou todos os cursos

        //os streams trabalham em cima do fluxo e não alteram a collection
        //então para fazer o foreach
        cursos.stream().filter(c -> c.getAlunos() >=100).forEach(c -> System.out.println(c.getNome()));

        //dados esses cursos filtrados no nosso fluxo (Stream) de objetos
        //pegar um novo fluxo apenas com a quantidade de alunos de cada um deles
        //para isso temos o map
        //dado um stream de curso eu quero um strem de Integer (quantidade de alunos)
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        //Quando fizemos o map(Curso::getAlunos), recebemos de volta um Stream<Integer>,
        //que acaba fazendo o autoboxing dos ints. Isto é, utilizará mais recursos da JVM.
        //Claro que, se sua coleção é pequena, o impacto será irrisório.
        //Mas é possível trabalhar só com ints, invocando o método mapToInt
        //Ele devolve um IntStream, que não vai gerar autoboxing e
        //possui novos métodos específicos para trabalhar com inteiros
        int soma = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println(soma);

        //pegar algum qualquer
        cursos.stream().filter(c -> c.getAlunos() > 100).findAny();
        //isso retorna um novo tipo do java 8
        //o optional, que nos ajuda principalmente com o null

        Optional<Curso> cursoOptional = cursos.stream().filter(c -> c.getAlunos() > 100).findAny();

        //faça caso não seja nulo
        cursoOptional.ifPresent(c -> System.out.println(c.getNome()));

        //se estiver nulo
        System.out.println(cursoOptional.isPresent());

        //aqui foi feito separado
        //mas na pratica é tudo junto
        cursos.stream().filter(c -> c.getAlunos() > 100).findAny().ifPresent(c -> System.out.println(c.getNome()));

        //como visto acima ao mexer com o Stream não auleramos a Collection
        //para guardarmos uma lista com base em um stream fazemos
        cursos = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());
        //agora cursos guarda nossa lista filtrada
        cursos.forEach(c -> System.out.println(c.getNome()));
    }

}
