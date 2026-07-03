package repository;

import models.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {

    // CREATE (Cadastrar)
    public void adicionar(Livro livro) {
        // Ajustado para a tabela 'Livro' e a coluna 'tipo'
        String sql = "INSERT INTO Livro (titulo, autor, tipo) VALUES (?, ?, ?)";

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());

            // Descobre qual é a classe filha e salva no ENUM correspondente
            if (livro instanceof models.LivroFisico) {
                stmt.setString(3, "FISICO");
            } else if (livro instanceof models.LivroDigital) {
                stmt.setString(3, "DIGITAL");
            } else {
                System.err.println("Tipo não suportado pelo banco!");
                return; // Cancela a operação se não for físico nem digital
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar livro: " + e.getMessage());
        }
    }

    // READ (Buscar todos)
    public List<Livro> buscarTodos() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Livro"; // Tabela ajustada

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Livro livro;
                String tipo = rs.getString("tipo");

                // Recria o objeto correto baseado no ENUM do banco
                if ("FISICO".equals(tipo)) {
                    livro = new models.LivroFisico();
                } else {
                    livro = new models.LivroDigital();
                }

                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar livros: " + e.getMessage());
        }
        return livros;
    }

    // UPDATE (Atualizar)
    public void atualizar(Livro livro) {
        String sql = "UPDATE Livro SET titulo = ?, autor = ? WHERE id = ?"; // Tabela ajustada

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar livro: " + e.getMessage());
        }
    }

    // DELETE (Deletar)
    public void deletar(int id) {
        String sql = "DELETE FROM Livro WHERE id = ?"; // Tabela ajustada

        try (Connection con = ConexaoBanco.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao deletar livro: " + e.getMessage());
        }
    }
}