package Exercicio2.controller;

import Exercicio2.models.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaController {
    private Conexao conexao;

    public CategoriaController(Conexao conexao) {
        this.conexao = conexao;
    }

    public boolean CadastrarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome) VALUES (?)";

        // Adicionado Statement.RETURN_GENERATED_KEYS para o MySQL devolver o ID gerado
        try (Connection conn = Exercicio2.controller.Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();

            // Recupera o ID que o MySQL gerou automaticamente e salva no objeto categoria
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    categoria.setId(generatedKeys.getInt(1));
                }
            }

            System.out.println("Categoria cadastrada com sucesso!");
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar nova categoria: " + e.getMessage());
            return false;
        }
    }

    // Busca todas as categorias do banco de dados
    public List<Categoria> listarTodos() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT id, nome FROM categoria";

        try (Connection conn = Exercicio2.controller.Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                // Capturando o ID do banco e colocando no objeto
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));

                categorias.add(categoria);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar categorias: " + e.getMessage());
        }
        return categorias;
    }
}