package view;

import controller.FormaPagamentoController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FormaPagamentoView {

    public void exibir() {
        Stage stage = new Stage();
        stage.setTitle("Formas de Pagamento");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));

        Label lblDescricao = new Label("Descrição (Ex: Pix, Cartão):");
        TextField txtDescricao = new TextField();

        Button btnSalvar = new Button("Salvar");

        grid.add(lblDescricao, 0, 0);
        grid.add(txtDescricao, 1, 0);
        grid.add(btnSalvar, 1, 1);

        FormaPagamentoController controller = new FormaPagamentoController();
        btnSalvar.setOnAction(e -> {
            controller.cadastrar(txtDescricao.getText());
            txtDescricao.clear();
        });

        stage.setScene(new Scene(grid, 400, 150));
        stage.show();
    }
}