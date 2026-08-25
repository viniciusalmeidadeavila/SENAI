package controller;

import dao.ProdutoDAO;
import javafx.scene.control.Alert;
import models.Produto;

public class ProdutoController {

    public void cadastrarProduto(String nome, String precoStr, String estoqueStr) {
        try {
            double preco = Double.parseDouble(precoStr);
            int estoque = Integer.parseInt(estoqueStr);

            Produto novoProduto = new Produto(0, nome, preco, estoque);
            ProdutoDAO dao = new ProdutoDAO();
            dao.salvar(novoProduto);

            mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Produto cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Preço e Estoque devem ser números válidos!");
        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.WARNING, "Regra de Negócio", e.getMessage());
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao salvar: " + e.getMessage());
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}