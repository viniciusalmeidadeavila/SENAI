package Exercicio1.controller;

import Exercicio1.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    // 1. CADASTRAR UM NOVO CLIENTE
    public boolean cadastrar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());

            stmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
            return false;
        }
    }

    // 2. LISTAR TODOS OS CLIENTES
    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));

                // Converte o TIMESTAMP do banco para LocalDateTime do Java
                if (rs.getTimestamp("data_cadastro") != null) {
                    cliente.setData_cadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
                }

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }

        return clientes;
    }

    // 3. BUSCAR POR CPF
    public Cliente buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM Cliente WHERE cpf = ?";
        Cliente cliente = null;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));

                    if (rs.getTimestamp("data_cadastro") != null) {
                        cliente.setData_cadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente por CPF: " + e.getMessage());
        }

        return cliente;
    }

    // 4. ATUALIZAR E-MAIL E TELEFONE (Através do CPF)
    public boolean atualizarContato(String cpf, String novoEmail, String novoTelefone) {
        String sql = "UPDATE Cliente SET email = ?, telefone = ? WHERE cpf = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoEmail);
            stmt.setString(2, novoTelefone);
            stmt.setString(3, cpf);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Dados de contato atualizados com sucesso!");
                return true;
            } else {
                System.out.println("Nenhum cliente encontrado com o CPF informado.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // 5. REMOVER UM CLIENTE (Através do CPF)
    public boolean remover(String cpf) {
        String sql = "DELETE FROM Cliente WHERE cpf = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Cliente removido com sucesso!");
                return true;
            } else {
                System.out.println("Nenhum cliente encontrado com o CPF: "+ cpf);
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao remover cliente: " + e.getMessage());
            return false;
        }
    }
}