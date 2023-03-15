package terceiraAula;

import java.util.ArrayList;

public class TestaArrayList {

    public static void main(String[] args) {
        //java.util -pacote muito importante
        //listas
        //arraylist internamente trabalha com um array porém facilita o uso

        //array generico (Object)
        //arrays podem ter passagem de parametros no construtor
        //ex: um int defineindo o tamanho inicial do array
        //ou uma outra lista
        ArrayList arrayGenerico = new ArrayList();

        //adicionar
        //listas guardam oredem - sempre adicionados ao final da lista
        arrayGenerico.add("oi");
        arrayGenerico.add(1);
        arrayGenerico.add(2);
        arrayGenerico.add(3);
        arrayGenerico.add("tchau");

        //pegar um objeto
        String s = (String) arrayGenerico.get(0);

        //                   tamanho
        for (int i = 0; i < arrayGenerico.size(); i++) {
            System.out.println(arrayGenerico.get(i));
        }

        //remover (indíce)
        arrayGenerico.remove(1);

        for (Object o : arrayGenerico) {
            System.out.println(o);
        }

        //generics
        //listas com tipo definido
        ArrayList<String> lista = new ArrayList<String>();
        //a linha de cima também pode ser representada como:
        //ArrayList<String> lista = new ArrayList<>();

        //a partir desse momento o add só recebe strings e nem compila caso passe outro tipo de parametro
        //o get retorna uma string, tudo se baseria em torno do generics
    }

}
