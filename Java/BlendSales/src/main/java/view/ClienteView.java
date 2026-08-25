package view;

import controller.ClienteController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClienteView {

    public void exibir() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Cliente");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));

        Label lblNome = new Label("Nome:");
        TextField txtNome = new TextField();

        Label lblCpf = new Label("CPF:");
        TextField txtCpf = new TextField();

        Button btnSalvar = new Button("Salvar Cliente");

        grid.add(lblNome, 0, 0);
        grid.add(txtNome, 1, 0);
        grid.add(lblCpf, 0, 1);
        grid.add(txtCpf, 1, 1);
        grid.add(btnSalvar, 1, 2);

        // Supondo que você crie um ClienteController com este método
        ClienteController controller = new ClienteController();
        btnSalvar.setOnAction(e -> {
            controller.cadastrarCliente(txtNome.getText(), txtCpf.getText());
            txtNome.clear(); txtCpf.clear();
        });

        stage.setScene(new Scene(grid, 400, 200));
        stage.show();
    }
}