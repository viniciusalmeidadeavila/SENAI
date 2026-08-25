package controller;

import dao.ClienteDAO;
import javafx.scene.control.Alert;
import models.Cliente;

public class ClienteController {

    public void cadastrarCliente(String nome, String cpf) {
        if (nome.trim().isEmpty() || cpf.trim().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Atenção", "Preencha todos os campos!");
            return;
        }

        try {
            Cliente novoCliente = new Cliente(0, nome, cpf);

            ClienteDAO dao = new ClienteDAO();
            dao.salvar(novoCliente);

            mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao salvar cliente: " + e.getMessage());
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