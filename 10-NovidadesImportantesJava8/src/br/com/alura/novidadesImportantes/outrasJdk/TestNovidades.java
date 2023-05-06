package br.com.alura.novidadesImportantes.outrasJdk;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestNovidades {

    public static void main(String[] args) throws Exception {
        //java 9 factory method collection
        //criando coleções imutaveis
        List<String> a = List.of("oi");
        //daria erro
        //a.add("oi");
        System.out.println(a);

        System.out.println("-------------------------------");

        //java 10 inferencia de variavel
        var nome = "String"; //só pode em métodos e não em classes
        System.out.println(nome);
        //cuidado com generics do lado direito (na instancia)
        //não é obrigatório
        //List<String> lista = new ArrayList<>();
        //se fizer
        //var lista = new ArrayList<>();
        //teremos uma lista de Object
        //então nesses casos sempre passar o generics

        System.out.println("-------------------------------");

        //java 11 - nova maneira de lidar com HTTP (API HTTP/2 Client)

        //como era feito antes do java 11 com HTTP1

        URL url = new URL("http://www.omdbapi.com/?apikey=76f9959e&t=matrix");
        URLConnection uc = url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));

        String line = br.readLine();

        while (line == null) {
            line = line.concat(br.readLine()).concat(System.lineSeparator());
            line = br.readLine();
        }

        System.out.println(line);

        //com java 11 HTTP2
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(
                                    new URI("http://www.omdbapi.com/?apikey=76f9959e&t=matrix"))
                                        .GET().build();
        HttpResponse<String> resp = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(resp.statusCode());
        System.out.println(resp.body());
        System.out.println(resp.version());
    }

}
