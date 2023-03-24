package br.com.alura.java.io.quartaAula;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeituraScanner {

    public static void main(String[] args) throws IOException {
        //construtores comuns - file e inputStream
        Scanner scan = new Scanner(new File("lorem.txt"));

        String linha = "";
        while (scan.hasNextLine()) {
            linha = scan.nextLine();
            System.out.println(linha);
        }
        scan.close();

        System.out.println("--------------------------");

        //exemplo com arquivos csv
        //para arquivos csv podemos pegar item por item
        //no caso
        //1,2,3,4,5
        //pegar um item a cada vírgula
        //para isso podemos usar o split
        scan = new Scanner(new File("teste.csv"));

        while (scan.hasNextLine()) {
            linha = scan.nextLine();
            String[] itens = linha.split(",");
            System.out.println(linha);
            System.out.println(Arrays.toString(itens));
        }
        scan.close();

        System.out.println("----------------------");

        //porém há uma outra forma de fazer isso com Scanner que nos ajuda também
        scan = new Scanner(new File("teste.csv"));

        while (scan.hasNextLine()) {
            linha = scan.nextLine();
            Scanner linhaScanner = new Scanner(linha);
            linhaScanner.useDelimiter(",");
            //defineindo Locale como Us - para que as configurações sejam as americadas
            //decimal com . por exemplo
            linhaScanner.useLocale(Locale.US);

            //os tipos de next - parse dos campos
            //nextline não é útil nesse caso pq não queromos a linha inteira
            //porém a todos os nexts podem ser usado mesmo sem essa questão do
            //delimiter
            String valor1 = linhaScanner.next();
            Integer valor2 = linhaScanner.nextInt();
            BigDecimal valor3 = linhaScanner.nextBigDecimal();
            Float valor4 = linhaScanner.nextFloat();
            Double valor5 = linhaScanner.nextDouble();

            System.out.println(
                    "valor 1 -> " + valor1 + "\n" +
                    "valor 2 -> " + valor2 + "\n" +
                    "valor 3 -> " + valor3 + "\n" +
                    "valor 4 -> " + valor4 + "\n" +
                    "valor 5 -> " + valor5 + "\n"
            );

            linhaScanner.close();
        }
        scan.close();
    }

}
