package br.com.alura.bytebank.domain.conta;

import br.com.alura.bytebank.domain.cliente.Cliente;

import java.math.BigDecimal;
import java.sql.*;

public class ContaDAO {

    //cada classe deve ter a sua responsabilidade única
    //para isso criamos uma classe DAO
    //(padrão DAO para acesso a objetos do banco de dados)
    //e dentro dessa classe trataremos as interações com o banco de dados
    //(para conta)
    private Connection conn;

    ContaDAO(Connection connection) {
        this.conn = connection;
    }

    public void salvar(DadosAberturaConta dadosDaConta) {
        var cliente = new Cliente(dadosDaConta.dadosCliente());
        var conta = new Conta(dadosDaConta.numero(), BigDecimal.ZERO, cliente);

        //para executarmos um sql precisamos de uma string com o comando
        //antes os parametros também eram concatenados (quando uttilizavamos o Statement)
        //mas com isso sofríamos com as SQL injections
        //agora podemos passar os parametros através do ?
        //(por que utilizamos o PreparedStatement)
        String sql = "INSERT INTO conta (numero, saldo, cliente_nome, cliente_cpf, cliente_email)" +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //setando os parametros
            preparedStatement.setInt(1, conta.getNumero());
            preparedStatement.setBigDecimal(2, BigDecimal.ZERO);
            preparedStatement.setString(3, dadosDaConta.dadosCliente().nome());
            preparedStatement.setString(4, dadosDaConta.dadosCliente().cpf());
            preparedStatement.setString(5, dadosDaConta.dadosCliente().email());

            //o execute nos retorna um boolean indicando se deu certo ou não o insert
            preparedStatement.execute();

            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}