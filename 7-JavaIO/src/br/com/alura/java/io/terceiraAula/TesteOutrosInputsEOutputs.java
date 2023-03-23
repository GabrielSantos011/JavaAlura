package br.com.alura.java.io.terceiraAula;

import java.io.*;
import java.net.Socket;

public class TesteOutrosInputsEOutputs {

    public static void main(String[] args) throws IOException {
        //até agora, apesa de já usarmos o polimorfismo com o input e o output
        //fizemos apenas para arquivos
        //porém podemos fazer inputs com teclado, com a rede
        //e consequentemente outputs no console e com a rede
        //(com a rede não temos como demonstrar, mas deixar explicado o conceitual)

        //para entrada de dados no console
        InputStream fis = System.in;
        Reader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        //não é pq a entrada é teclado que a saída tem que ser feita via console, podemos
        //usar qualquer uma, mas apenas para demonstrarmos como funciona a saída do console
        OutputStream fos = System.out;
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        String linha = br.readLine();

        //ao mandarmos uma linha vazia via console  ela não vem null e sim vazia
        //portanto temos que adicionar uma condição
        while (linha != null && !linha.isEmpty()) {
            bw.write(linha);
            bw.newLine();
            //aqui mostraremos um novo método que pode ser interessante
            //flush()
            //Enquanto escrevemos no arquivo com o método write essas alterações não estão
            //realmente no arquivo (ou na saída) ainda. Essas alterações só vão quando o flush é invocado
            //o flush já é invocado pelo close() porém neste exemplo que a cada linha
            //já saia no console
            bw.flush();
            linha = br.readLine();
        }

        br.close();
        bw.close();

        //para rede temos o socket
        //não há como simular pois não temos outro computador na rede
        //mas seria algo como isso
        //Socket socket = new Socket();
        //
        //InputStream fis1 = socket.getInputStream();
        //Reader isr1 = new InputStreamReader(fis);
        //BufferedReader br1 = new BufferedReader(isr);
        //
        //OutputStream fos2 = socket.getOutputStream();
        //Writer osw2 = new OutputStreamWriter(fos);
        //BufferedWriter bw2 = new BufferedWriter(osw);
    }

}
