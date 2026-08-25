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
        String sqlVenda = "INSERT INTO venda (id_cliente, id_usuario, id_forma_pagamento, data_venda) VALUES (?, ?, ?, NOW())";
        String sqlItem = "INSERT INTO `item venda` (id_venda, id_produto, quantidade, preco_unitario) VALUES (?, ?, ?, 0.0)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmtVenda = conn.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS)) {

            // 1. Salva a Venda
            stmtVenda.setInt(1, idCliente);
            stmtVenda.setInt(2, idUsuario);
            stmtVenda.setInt(3, idFormaPagamento);
            stmtVenda.executeUpdate();

            // 2. Pega o ID da Venda que acabou de ser criada
            ResultSet rs = stmtVenda.getGeneratedKeys();
            if (rs.next()) {
                int idVendaGerado = rs.getInt(1);

                // 3. Salva o Item da Venda
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