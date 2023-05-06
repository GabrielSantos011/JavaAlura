package br.com.alura.novidadesImportantes.java8.datas;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestDatas {

    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadasParis = LocalDate.of(2024, Month.JULY, 26);

        int anos = olimpiadasParis.getYear() - hoje.getYear();
        System.out.println(anos);

        Period periodo = Period.between(hoje, olimpiadasParis);
        System.out.println(periodo);
        System.out.println(periodo.getYears());
        System.out.println(periodo.getMonths());
        System.out.println(periodo.getDays());

        System.out.println(hoje.minusYears(1));
        System.out.println(hoje.minusMonths(4));
        System.out.println(hoje.minusDays(2));
        System.out.println(hoje.plusYears(1));
        System.out.println(hoje.plusMonths(4));
        System.out.println(hoje.plusDays(2));

        //imutavel
        olimpiadasParis.plusYears(4);
        System.out.println(olimpiadasParis);
        //porém retorna um LocalDate logo isso funciona
        LocalDate olimpiadas2028 = olimpiadasParis.plusYears(1);

        //formatar datas
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String valorFormatado = olimpiadas2028.format(formatador);
        System.out.println(valorFormatado);

        //medida de tempo
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        System.out.println(agora.format(formatadorComHoras));

        LocalTime intervalo = LocalTime.of(12, 30);
        System.out.println(intervalo);
    }

}
