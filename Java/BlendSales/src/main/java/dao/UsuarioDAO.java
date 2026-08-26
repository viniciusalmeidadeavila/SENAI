package dao;

import database.Conexao;
import models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            throw new RuntimeException("Erro ao salvar usuario no banco: " + e.getMessage(), e);
        }
    }

    public boolean autenticar(String login, String senhaCriptografada) {
        String sql = "SELECT id FROM usuario WHERE login = ? AND senha = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, login);
            stmt.setString(2, senhaCriptografada);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao autenticar usuario: " + e.getMessage(), e);
        }
    }
}