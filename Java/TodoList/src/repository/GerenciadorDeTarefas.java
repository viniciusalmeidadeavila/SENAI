package repository;

import models.Tarefa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {

    // Método para Adicionar no Banco
    public boolean adicionarTarefa(String titulo) {
        // Atualizado: titulo_tarefa e data_hora
        String sql = "INSERT INTO tarefas (id, titulo_tarefa, concluida, data_hora) VALUES (?, ?, ?, ?)";
        Tarefa novaTarefa = new Tarefa(titulo);

        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novaTarefa.getId());
            stmt.setString(2, novaTarefa.getTitulo());
            stmt.setBoolean(3, novaTarefa.isConcluida());
            stmt.setTimestamp(4, Timestamp.valueOf(novaTarefa.getDataCriacao()));

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao adicionar tarefa no banco: " + e.getMessage());
            return false;
        }
    }

    // Método para Listar Todas do Banco
    public List<Tarefa> listarTodas() {
        List<Tarefa> lista = new ArrayList<>();
        String sql = "SELECT * FROM tarefas";

        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                // Atualizado para ler a coluna 'titulo_tarefa'
                String titulo = rs.getString("titulo_tarefa");
                boolean concluida = rs.getBoolean("concluida");
                // Atualizado para ler a coluna 'data_hora'
                LocalDateTime data = rs.getTimestamp("data_hora").toLocalDateTime();

                Tarefa t = new Tarefa(id, titulo, concluida, data);
                lista.add(t);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar tarefas: " + e.getMessage());
        }
        return lista;
    }

    // Método para Filtrar por Status no Banco
    public List<Tarefa> listarPorStatus(boolean concluida) {
        List<Tarefa> lista = new ArrayList<>();
        String sql = "SELECT * FROM tarefas WHERE concluida = ?";

        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBoolean(1, concluida);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    // Atualizado para ler a coluna 'titulo_tarefa'
                    String titulo = rs.getString("titulo_tarefa");
                    // Atualizado para ler a coluna 'data_hora'
                    LocalDateTime data = rs.getTimestamp("data_hora").toLocalDateTime();

                    Tarefa t = new Tarefa(id, titulo, concluida, data);
                    lista.add(t);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao filtrar tarefas: " + e.getMessage());
        }
        return lista;
    }

    // Método para Marcar como Concluída no Banco
    public boolean marcarComoConcluida(String id) {
        String sql = "UPDATE tarefas SET concluida = true WHERE id = ?";

        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (Exception e) {
            System.out.println("Erro ao concluir tarefa: " + e.getMessage());
            return false;
        }
    }

    // Método para Editar Título no Banco
    public boolean editarTitulo(String id, String novoTitulo) {
        // Atualizado para atualizar a coluna 'titulo_tarefa'
        String sql = "UPDATE tarefas SET titulo_tarefa = ? WHERE id = ?";

        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoTitulo);
            stmt.setString(2, id);
            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (Exception e) {
            System.out.println("Erro ao editar tarefa: " + e.getMessage());
            return false;
        }
    }

    // Método para Remover do Banco
    public boolean removerTarefa(String id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";

        try (Connection conn = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (Exception e) {
            System.out.println("Erro ao remover tarefa: " + e.getMessage());
            return false;
        }
    }
}