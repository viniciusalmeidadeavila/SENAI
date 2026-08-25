package view;

import controller.ProdutoController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProdutoView {

    public void exibir() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Produtos");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Componentes da tela
        Label lblNome = new Label("Nome do Produto:");
        TextField txtNome = new TextField();

        Label lblPreco = new Label("Preço (R$):");
        TextField txtPreco = new TextField();

        Label lblEstoque = new Label("Quantidade em Estoque:");
        TextField txtEstoque = new TextField();

        Button btnSalvar = new Button("Salvar Produto");

        // Adicionando na tela (Coluna, Linha)
        grid.add(lblNome, 0, 0);
        grid.add(txtNome, 1, 0);
        grid.add(lblPreco, 0, 1);
        grid.add(txtPreco, 1, 1);
        grid.add(lblEstoque, 0, 2);
        grid.add(txtEstoque, 1, 2);
        grid.add(btnSalvar, 1, 3);

        // Ação do Botão (Chama o Controller)
        ProdutoController controller = new ProdutoController();
        btnSalvar.setOnAction(e -> {
            controller.cadastrarProduto(txtNome.getText(), txtPreco.getText(), txtEstoque.getText());
            // Limpa os campos após tentar salvar
            txtNome.clear(); txtPreco.clear(); txtEstoque.clear();
        });

        Scene scene = new Scene(grid, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
}