package br.com.alura.java.io.quintaAula;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TesteEncodingLeituraEEscrita {

    public static void main(String[] args) throws IOException {
        InputStream fis = new FileInputStream("lorem.txt");
        Reader      isr = new InputStreamReader(fis, "UTF-8");

        OutputStream fos = new FileOutputStream("a.txt");
        Writer       osw = new OutputStreamWriter(fos, "UTF-8");

        FileReader fr = new FileReader("lorem.tx", StandardCharsets.UTF_8);

        //assim por diante

    }

}
