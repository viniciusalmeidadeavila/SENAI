package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String URL = "jdbc:mysql://localhost:3306/todolist";
    private static final String USUARIO = "root";
    private static final String SENHA = "";


    public static Connection obterConexao() {
        try {
            // Tenta estabelecer e retornar a conexão
            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (SQLException e) {
            // Se algo der errado (senha errada, banco fora do ar, etc), ele avisa aqui
            System.out.println("Falha ao conectar com o banco: " + e.getMessage());
            return null;
        }
    }
}