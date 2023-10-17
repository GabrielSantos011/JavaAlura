package br.com.alura.bytebank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

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
//            Connection connection = DriverManager
//                    .getConnection("jdbc:mysql://localhost:3306/byte_bank?user=root&password=123456");
//
//            System.out.println("Conexão Recuperada");
//
//            return connection;

            //a partir de agora temos um pool de conexões
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //antes tínhamos para cada operação uma abertura de uma nova conexão,
    //sua utilização e o encerramento da mesma.
    //porém em uma aplicação com diversos usuários essa não é a melhor abordagem,
    //para tal utilizamos um poll de conexão, nele conseguimos setar uma quantidade de conexões que ficarão abertas
    //isso não faz com que dentro da classe DAO tenhamos que parar de dar o close()
    //porém agora o close faz com que a conexão volte ao pool
    //
    //*para o pool utilizamos a biblioteca HikariCP (existem diversas outras)
    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/byte_bank");
        config.setUsername("root");
        config.setPassword("123456");
        //aqui setamos a quantidade de conexões que ficarão aberta
        config.setMaximumPoolSize(10);
        //com isso temos 10 conexões, porém o que acontece se tivermos 11 requisições simultanes?
        //10 serão selecionadas e uma ficara aguardando até que alguma conexão volte ao pool

        return new HikariDataSource(config);
    }

}
