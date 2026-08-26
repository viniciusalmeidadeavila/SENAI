package controller;

import dao.UsuarioDAO;
import javafx.scene.control.Alert;
import utils.SegurancaSenha;

public class LoginController {

    public boolean autenticar(String login, String senha) {
        if (login == null || login.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Aviso", "Preencha todos os campos!");
            return false;
        }

        String senhaCriptografada = SegurancaSenha.criptografar(senha);

        try {
            UsuarioDAO dao = new UsuarioDAO();
            boolean valido = dao.autenticar(login, senhaCriptografada);
            
            if (!valido) {
                mostrarAlerta(Alert.AlertType.ERROR, "Erro de Autenticacao", "Login ou senha invalidos!");
                return false;
            }
            return true;
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao conectar: " + e.getMessage());
            return false;
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