package br.com.alura.java.io.primeiraAula;

import java.io.*;

public class TesteLeitura {

    public static void main(String[] args) throws IOException {
        //Strems - bits e bytes
        //Readers - leitura de caracteres

        //leitura de arquivo
        //                fluxo de entrada de arquivos
        InputStream fis = new FileInputStream("lorem.txt");
        //Utilizando a variável fis, podemos utilizar uma série de métodos,
        //dentre eles, está o read(). O seu retorno é do tipo int, ou seja, um número.
        //Isso indica que ele é capaz de ler os bytes, o que não é interessante para nós,
        //não queremos as informações de bytes e binários, mas sim os caracteres.

        //Há uma classe capaz de transformar um int em caracteres, que se chama InputStreamReader.
        //A ideia é que ela é capaz de ler um InputStream.
        Reader isr = new InputStreamReader(fis);
        //A variável isr nos permite utilizar uma outra variedade de métodos, além do método read()
        //citado acima, há um segundo, que recebe como parâmetro um array de caracteres.
        //Ele também nos retorna um int, entretanto, neste caso ele corresponde ao número de caracteres
        //que foram lidos. Neste caso, conseguimos transformar bits e bytes em caracteres,
        //mas ainda não é a melhor solução para nosso problema.

        //A ideia é que sejamos capazes de ler as linhas inteiras do arquivo de texto, para isso,
        //temos que "guardar" cada um dos caracteres, até sermos capazes de completar uma linha,
        //e assim por diante. Para esta tarefa, há o que chamamos de BufferedReader
        BufferedReader br = new BufferedReader(isr);
        //não utilizei o polimorfismo com o Reader pois a classe mais genérica não possui
        //o método readLine que desejamos utilizar

        //obs: isso que acabamos de ver (um objeto sendo passado como parametro para outro objeto)
        //e 'administrando' suas funções é um padrão de projetos chamado decorator
        //"um objeto decora a funcionalidade de outro objeto (melhorando, adicionando um novo comportamento)"

        //porém aqui estamos lendo uma linha
        String linha = br.readLine();

        //quando não houver mais linhas o método nos retorna null
        //portanto para lermos o arquivo inteiro
        while (linha != null) {
            System.out.println(linha);
            linha = br.readLine();
        }

        //estabelecemos uma entrada em BufferedReader, mas não uma saída, assim, fecharemos com o
        br.close();
    }

}
