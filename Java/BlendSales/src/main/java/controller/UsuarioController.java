package controller;

import dao.UsuarioDAO;
import javafx.scene.control.Alert;
import models.Usuario;
import utils.SegurancaSenha;

public class UsuarioController {

    public void cadastrarUsuario(String nome, String login, String senha) {
        if (!SegurancaSenha.isSenhaValida(senha)) {
            mostrarAlerta("Erro", "A senha deve ter no mínimo 13 caracteres!");
            return;
        }

        String senhaCriptografada = SegurancaSenha.criptografar(senha);

        try {
            Usuario novoUsuario = new Usuario(0, nome, login, senhaCriptografada);
            UsuarioDAO dao = new UsuarioDAO();
            dao.salvar(novoUsuario);

            mostrarAlerta("Sucesso", "Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Erro ao salvar: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}