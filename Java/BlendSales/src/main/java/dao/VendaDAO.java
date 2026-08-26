package dao;

import database.Conexao;
import models.Venda;
import models.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class VendaDAO {

    public void registrarVenda(int idCliente, int idUsuario, int idFormaPagamento, int idProduto, int quantidade) {
        String sqlVenda = "INSERT INTO venda (cliente_id, usuario_id, forma_pagamento_id, data_venda, valor_total, status) VALUES (?, ?, ?, NOW(), 0.0, 'PENDENTE')";
        String sqlItem = "INSERT INTO item_venda (venda_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, 0.0)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmtVenda = conn.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS)) {

            stmtVenda.setInt(1, idCliente);
            stmtVenda.setInt(2, idUsuario);
            stmtVenda.setInt(3, idFormaPagamento);
            stmtVenda.executeUpdate();

            ResultSet rs = stmtVenda.getGeneratedKeys();
            if (rs.next()) {
                int idVendaGerado = rs.getInt(1);

                try (PreparedStatement stmtItem = conn.prepareStatement(sqlItem)) {
                    stmtItem.setInt(1, idVendaGerado);
                    stmtItem.setInt(2, idProduto);
                    stmtItem.setInt(3, quantidade);
                    stmtItem.executeUpdate();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao registrar venda: " + e.getMessage());
        }
    }
}