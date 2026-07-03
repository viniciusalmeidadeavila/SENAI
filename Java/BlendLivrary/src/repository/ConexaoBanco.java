package repository;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final Dotenv dotenv = Dotenv.configure().directory("./BlendLivrary").load();

    // Busca os valores diretamente do arquivo .env
    private static final String URL = dotenv.get("DB_URL");
    private static final String USUARIO = dotenv.get("DB_USER");
    private static final String SENHA = dotenv.get("DB_PASSWORD");

    public static Connection conectar() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão segura realizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar (verifique seu arquivo .env): " + e.getMessage());
        }
        return conexao;
    }
}