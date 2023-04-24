package br.com.alura.java.io.segundaAula.parteUm;

import java.io.*;

public class TesteEscrita {

    public static void main(String[] args) throws IOException {
        //para a escrita usamos a mesma lógica implementada na leitura
        //porém com clsses diferentes
        //OutputStream e Writer
        OutputStream fos = new FileOutputStream("arquivo-segunda-aula-parte1.txt");
        //obs: caso querira salvar em um diretório do Pc passamos junto o path
        //exemplo C:\\teste.txt (para funcionar na raiz C a IDE tem que estar executando como adm)
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("arquivo teste arquivo teste arquivo teste arquivo teste arquivo teste arquivo teste ");
        bw.newLine();
        bw.newLine();
        bw.write("arquivo teste arquivo teste arquivo teste arquivo teste ");

        bw.close();
    }

}
