package dao;

import database.Conexao;
import models.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormaPagamentoDAO {

    public void salvar(FormaPagamento formaPagamento) {
        String sql = "INSERT INTO forma_pagamento (descricao) VALUES (?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, formaPagamento.getDescricao());

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar forma de pagamento no banco: " + e.getMessage(), e);
        }
    }
}