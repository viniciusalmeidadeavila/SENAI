package dao; // ou package database;

import database.Conexao; // Usa a sua classe de conexão
import models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar usuário no banco: " + e.getMessage(), e);
        }
    }
}