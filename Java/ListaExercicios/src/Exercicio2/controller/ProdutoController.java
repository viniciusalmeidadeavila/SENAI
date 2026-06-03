package Exercicio2.controller;

import Exercicio2.models.Produto;
import Exercicio2.models.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    private Conexao conexao;

    public ProdutoController(Conexao conexao) {
        this.conexao = conexao;
    }

    // Salva o produto utilizando o ID da categoria como FK no banco de dados
    public boolean CadastrarProduto(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, categoria_id) VALUES (?, ?, ?)";

        try (Connection conn = Exercicio2.controller.Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());

            // Pega o ID do objeto Categoria que está associado ao Produto
            stmt.setInt(3, produto.getCategoria().getId());

            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar novo produto: " + e.getMessage());
            return false;
        }
    }

    // Consulta no MySQL trazendo os dados do Produto e da Categoria grudados (JOIN)
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();

        // SQL para o MySQL relacionar as tabelas
        String sql = "SELECT p.id AS prod_id, p.nome AS prod_nome, p.preco AS prod_preco, " +
                "c.id AS cat_id, c.nome AS cat_nome " +
                "FROM produto p " +
                "INNER JOIN categoria c ON p.categoria_id = c.id";

        try (Connection conn = Exercicio2.controller.Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // 1. Monta a categoria com os dados vindos do banco usando os ALIASES corretos do SQL
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("cat_id"));
                cat.setNome(rs.getString("cat_nome"));

                // 2. Monta o produto e anexa a categoria nele
                Produto prod = new Produto();
                prod.setNome(rs.getString("prod_nome"));
                prod.setPreco(rs.getDouble("prod_preco"));
                prod.setCategoria(cat);

                produtos.add(prod);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }
}