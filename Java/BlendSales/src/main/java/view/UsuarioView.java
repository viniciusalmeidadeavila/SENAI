package view;

import controller.UsuarioController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UsuarioView {

    public void exibir() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Usuários");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label lblNome = new Label("Nome Completo:");
        TextField txtNome = new TextField();

        Label lblLogin = new Label("Login:");
        TextField txtLogin = new TextField();

        Label lblSenha = new Label("Senha (Mín. 13 dígitos):");
        PasswordField txtSenha = new PasswordField();

        Button btnSalvar = new Button("Salvar Usuário");

        grid.add(lblNome, 0, 0);
        grid.add(txtNome, 1, 0);
        grid.add(lblLogin, 0, 1);
        grid.add(txtLogin, 1, 1);
        grid.add(lblSenha, 0, 2);
        grid.add(txtSenha, 1, 2);
        grid.add(btnSalvar, 1, 3);

        // Ação do Botão
        UsuarioController controller = new UsuarioController();
        btnSalvar.setOnAction(e -> {
            controller.cadastrarUsuario(txtNome.getText(), txtLogin.getText(), txtSenha.getText());
            txtNome.clear(); txtLogin.clear(); txtSenha.clear();
        });

        Scene scene = new Scene(grid, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
}