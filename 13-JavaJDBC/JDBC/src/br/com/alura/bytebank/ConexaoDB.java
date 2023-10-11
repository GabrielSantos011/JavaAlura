package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    public static void main(String[] args) {
        try {
            //para pegarmos uma conexão utilizamos o DiverManager
            //a string de conexão segue o padrão
            //jdbc:banco://server/nomeDoBanco?user=usuario&password=senha
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/byte_bank?user=root&password=123456");

            System.out.println("Recuperei a conexão");

            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
