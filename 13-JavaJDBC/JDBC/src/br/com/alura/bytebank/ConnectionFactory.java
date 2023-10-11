package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    //classe no padrão Factory
    //somente por essa classe liberamos a conexão com BD para outras clasess
    public Connection recuperarConexao() {
        try {
            //para pegarmos uma conexão utilizamos o DiverManager
            //a string de conexão segue o padrão
            //jdbc:banco://server/nomeDoBanco?user=usuario&password=senha
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/byte_bank?user=root&password=123456");

            System.out.println("Conexão Recuperada");

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
