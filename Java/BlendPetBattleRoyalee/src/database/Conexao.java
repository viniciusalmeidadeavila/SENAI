package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/battlepet?serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection conectar() {
        Connection conexao = null;

        try {
            // Tenta estabelecer a conexão
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("✅ Conexão com o banco 'battlepet' realizada com sucesso!");

        } catch (SQLException e) {
            System.err.println("❌ Erro ao conectar com o banco de dados.");
            System.err.println("Detalhes do erro: " + e.getMessage());
        }

        return conexao;
    }
}
