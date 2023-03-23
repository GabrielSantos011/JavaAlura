package br.com.alura.java.io.terceiraAula;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TestePrintStreamEPrintWriter {

    public static void main(String[] args) throws IOException {
        //os readers e writer surgiram no java 1.1
        //na versão 1.0 só existia entrada e saída de streams
        //então para um códico trabalhar com caracteres era utilizado
        //o PrintStream
        PrintStream ps = new PrintStream("teste-PrintStream.txt");
        ps.println("testetestetestetesteteste");
        ps.println();
        ps.println();
        ps.println("testetestetestetesteteste");
        ps.close();

        //ao criar os writers
        //criaram um PrintWriter que é similar ao PrintStream
        PrintWriter pw = new PrintWriter("testePrintWriter.txt");
        pw.println("testetestetestetesteteste");
        pw.println();
        pw.println();
        pw.println("testetestetestetesteteste");
        pw.close();
    }

}
