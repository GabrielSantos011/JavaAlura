package br.com.alura.java.io.terceiraAula;

import java.io.*;

public class TesteFileWriterEFileReader {

    public static void main(String[] args) throws IOException {
        //Trabalharemos com uma classe que é capaz de trabalhar diretamente com um arquivo
        //que já contém caracteres, em vez de os escrevermos diretamente no código
        //facilitando um pouco
        FileWriter fw = new FileWriter("arquivo-terceira-aula-fileWriter.txt");

        fw.write("arquivo teste arquivo teste arquivo teste arquivo teste arquivo teste ");
        //filewriter não tem um método newLine() então para isso usamos o \n
        //ou um método do java que retorna a quebra de linha para cada tipo de SO
        fw.write(System.lineSeparator());
        fw.write(System.lineSeparator());
        fw.write("arquivo teste arquivo teste arquivo teste arquivo teste ");

        //porém talvez ainda seja interessante utlilizar um buffer que tem o método
        //de mais alto nível de quebra de linha
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.newLine();
        bw.newLine();
        bw.newLine();
        bw.write("arquivo teste arquivo teste arquivo teste ");

        bw.close();

        FileReader fr = new FileReader("lorem.txt");
        BufferedReader br = new BufferedReader(fr);

        String linha = br.readLine();

        while (linha != null) {
            System.out.println(linha);
            linha = br.readLine();
        }

        br.close();
    }

}
