package view;

import controller.VendaController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VendaView {
    public void exibir() {
        Stage stage = new Stage();
        stage.setTitle("Registrar Venda Rápida");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); grid.setVgap(10); grid.setPadding(new Insets(25));

        TextField txtCliente = new TextField();
        TextField txtUsuario = new TextField();
        TextField txtForma = new TextField();
        TextField txtProduto = new TextField();
        TextField txtQtd = new TextField();
        Button btnSalvar = new Button("Finalizar Venda");

        grid.add(new Label("ID do Cliente:"), 0, 0); grid.add(txtCliente, 1, 0);
        grid.add(new Label("ID do Usuário:"), 0, 1); grid.add(txtUsuario, 1, 1);
        grid.add(new Label("ID Forma Pagamento:"), 0, 2); grid.add(txtForma, 1, 2);
        grid.add(new Label("ID do Produto:"), 0, 3); grid.add(txtProduto, 1, 3);
        grid.add(new Label("Quantidade:"), 0, 4); grid.add(txtQtd, 1, 4);
        grid.add(btnSalvar, 1, 5);

        VendaController controller = new VendaController();
        btnSalvar.setOnAction(e -> controller.finalizarVenda(txtCliente.getText(), txtUsuario.getText(), txtForma.getText(), txtProduto.getText(), txtQtd.getText()));

        stage.setScene(new Scene(grid, 400, 300));
        stage.show();
    }
}