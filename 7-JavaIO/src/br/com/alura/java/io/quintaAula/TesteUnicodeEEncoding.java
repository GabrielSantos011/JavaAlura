package br.com.alura.java.io.quintaAula;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEEncoding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "ç";
        //codepoint no Unicode
        System.out.println(s.codePointAt(0));

        //qual o encoding padrão
        Charset charset = Charset.defaultCharset();
        System.out.println(charset.displayName());

        //encoding das strings usando o parametro (sem parametro usa o padrão)
        byte[] bytes = s.getBytes("windows-1252");
        System.out.print(bytes.length + ", windows-1252, ");
        //nova string baseada em um fluxo de bytes com encoding passado via parametro
        //(caso não seja passado utiliza o padrão)
        String sNovo = new String(bytes, "windows-1252");
        System.out.println(sNovo);
        //caso o enconding desejado fosse diferente do fluxo de bytes passados
        //poderíamos ter problemas de encoding

        bytes = s.getBytes("UTF-16");
        System.out.print(bytes.length + ", UTF-16, ");
        sNovo = new String(bytes, "UTF-16");
        System.out.println(sNovo);

        bytes = s.getBytes(StandardCharsets.US_ASCII);
        System.out.print(bytes.length + ", US-ASCII, ");
        sNovo = new String(bytes, "US-ASCII");
        System.out.println(sNovo);

    }
}