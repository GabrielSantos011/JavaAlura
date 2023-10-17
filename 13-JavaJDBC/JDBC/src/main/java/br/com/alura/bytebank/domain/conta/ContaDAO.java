package br.com.alura.bytebank.domain.conta;

import br.com.alura.bytebank.domain.cliente.Cliente;
import br.com.alura.bytebank.domain.cliente.DadosCadastroCliente;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

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

    public Set<Conta> listar() {
        PreparedStatement ps;
        //no método anterior não havia um retorno da query
        //já em uma listagem precisamos pegar o conteúdo do select
        //para isso utilizamos um ResultSet
        ResultSet resultSet;
        Set<Conta> contas = new HashSet<>();

        String sql = "SELECT * FROM conta";

        try {
            ps = conn.prepareStatement(sql);
            //para retornar um ResultSet o método utilizado é o executeQuery()
            resultSet = ps.executeQuery();

            //pegando os dados (por linha)
            while (resultSet.next()) {
                Integer numero = resultSet.getInt(1);
                BigDecimal saldo = resultSet.getBigDecimal(2);
                String nome = resultSet.getString(3);
                String cpf = resultSet.getString(4);
                String email = resultSet.getString(5);

                DadosCadastroCliente dadosCadastroCliente =
                        new DadosCadastroCliente(nome, cpf, email);
                Cliente cliente = new Cliente(dadosCadastroCliente);

                contas.add(new Conta(numero, saldo, cliente));
            }
            resultSet.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contas;
    }

    public Conta listarPorNumero(Integer numero) {
        String sql = "SELECT * FROM conta WHERE numero = ?";

        PreparedStatement ps;
        ResultSet resultSet;
        Conta conta = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numero);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Integer numeroRecuperado = resultSet.getInt(1);
                BigDecimal saldo = resultSet.getBigDecimal(2);
                String nome = resultSet.getString(3);
                String cpf = resultSet.getString(4);
                String email = resultSet.getString(5);

                DadosCadastroCliente dadosCadastroCliente =
                        new DadosCadastroCliente(nome, cpf, email);
                Cliente cliente = new Cliente(dadosCadastroCliente);

                conta = new Conta(numeroRecuperado, saldo, cliente);
            }
            resultSet.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conta;
    }

    public void alterar(Integer numero, BigDecimal valor) {
        PreparedStatement ps;
        String sql = "UPDATE conta SET saldo = ? WHERE numero = ?";

        try {

            //nos defendendo para um possível erro
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql);

            ps.setBigDecimal(1, valor);
            ps.setInt(2, numero);

            ps.execute();
            ps.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public void deletar(Integer numeroDaConta) {
        String sql = "DELETE FROM conta WHERE numero = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, numeroDaConta);

            ps.execute();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}