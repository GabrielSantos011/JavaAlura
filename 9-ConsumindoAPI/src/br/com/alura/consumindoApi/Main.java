package br.com.alura.consumindoApi;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");

        //var - recurso do java 10
        //continua sendo fortemente tipado, porém n precisamos especificar
        var busca = leitura.nextLine();

        String endereco = "http://www.omdbapi.com/?apikey=76f9959e&t=" +
                busca.trim().replace(" ", "+");

        //protocolo http - cliente servidor
        //criar o cliente
        HttpClient client = HttpClient.newHttpClient();
        //a request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        //response - retorno da api ao mandar a request
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //ver o corpo da resposta
        String json = response.body();
        System.out.println(json);

        //transformar esse json retornado em um objeto - utilizar a dependencia Gson
        Gson gson = new Gson();
        //poderia ser um builder
        //new GsonBuilder()
        //      .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        //      .setPrettyPrinting()
        //      .create();

        //o nome do Json não é igual ao atributo do objeto então na classe fizemos o mapeamento
        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        System.out.println(meuTitulo);

        //objeto para json
        Titulo t = new Titulo("Filme", 2023);
        System.out.println(gson.toJson(t));

    }


}
