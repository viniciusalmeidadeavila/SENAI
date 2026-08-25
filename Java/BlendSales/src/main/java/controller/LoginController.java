package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.SegurancaSenha;

public class LoginController {

    @FXML private TextField txtLogin;
    @FXML private PasswordField txtSenha;

    @FXML
    public void cadastrarUsuario() {
        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        // Validação exigida no trabalho (mínimo de 13 dígitos)
        if (!SegurancaSenha.isSenhaValida(senha)) {
            mostrarAlerta("Erro", "A senha deve ter no mínimo 13 caracteres!");
            return;
        }

        // Criptografa a senha antes de mandar para o banco (DAO)
        String senhaCriptografada = SegurancaSenha.criptografar(senha);

        // AQUI ENTRARIA O CÓDIGO DO DAO PARA SALVAR NO BANCO
        // Exemplo: usuarioDAO.salvar(new Usuario(0, "Nome", login, senhaCriptografada));

        mostrarAlerta("Sucesso", "Usuário cadastrado com sucesso!");
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}