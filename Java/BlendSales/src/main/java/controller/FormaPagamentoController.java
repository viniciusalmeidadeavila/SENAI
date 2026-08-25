package controller;

import dao.FormaPagamentoDAO; // Lembre-se de criar este DAO se ainda não tiver!
import javafx.scene.control.Alert;
import models.FormaPagamento;

public class FormaPagamentoController {

    public void cadastrar(String descricao) {
        if (descricao.trim().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Atenção", "A descrição não pode estar vazia!");
            return;
        }

        try {
            FormaPagamento novaForma = new FormaPagamento(0, descricao);

            FormaPagamentoDAO dao = new FormaPagamentoDAO();
            dao.salvar(novaForma);

            mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Forma de pagamento cadastrada com sucesso!");
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