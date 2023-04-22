package br.com.alura.java.io.sextaAula.parteDois;

import java.io.*;

public class Teste {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cliente cliente= new Cliente();
        cliente.setCpf("345543345560");
        cliente.setNome("Gabriel");
        cliente.setProfissao("Dev Java");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
        oos.writeObject(cliente);
        oos.close();

        cliente = null;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
        cliente = (Cliente) ois.readObject();
        ois.close();

        System.out.println(cliente.getNome());
    }

}
