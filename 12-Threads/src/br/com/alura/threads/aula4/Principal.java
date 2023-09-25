package br.com.alura.threads.aula4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        //na aula anterior simulamos uma sincronização em um banheiro
        //porém em um exemplo mais realista temos nossas listas
        //que causam problemas se acessadas ao mesmo tempo
        //para isso usamos o vector ou um método da classe collections
        List<String> lista = Collections.synchronizedList(new ArrayList<String>());
        //ou
        List<String> vector = new Vector<String>();

        for (int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }

        Thread.sleep(4000);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i)); //utilizando get(i)
        }
    }

}
