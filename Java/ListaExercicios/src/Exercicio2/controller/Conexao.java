package Exercicio2.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // Configurações do Banco de Dados
    private static final String URL = "jdbc:mysql://localhost:3306/Exercicio2?useTimezone=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "@Viniciusv9742003";

    public static Connection getConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException e) {
            System.err.println("Erro: O Driver do MySQL não foi encontrado nas bibliotecas do projeto!");
            e.printStackTrace();
            return null;

        } catch (SQLException e) {
            System.err.println("Erro: Não foi possível conectar ao banco de dados. Verifique a URL, usuário ou senha.");
            e.printStackTrace();
            return null;
        }
    }
}