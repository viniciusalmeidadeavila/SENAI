package controller;

import dao.VendaDAO;
import javafx.scene.control.Alert;

public class VendaController {
    public void finalizarVenda(String idCliente, String idUsuario, String idForma, String idProduto, String qtd) {
        try {
            int cliente = Integer.parseInt(idCliente);
            int usuario = Integer.parseInt(idUsuario);
            int formaPagamento = Integer.parseInt(idForma);
            int produto = Integer.parseInt(idProduto);
            int quantidade = Integer.parseInt(qtd);

            VendaDAO dao = new VendaDAO();
            dao.registrarVenda(cliente, usuario, formaPagamento, produto, quantidade);

            mostrarAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Venda finalizada com sucesso!");
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Verifique os dados numéricos: " + e.getMessage());
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