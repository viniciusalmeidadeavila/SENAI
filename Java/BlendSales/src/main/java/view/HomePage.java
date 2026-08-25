package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage {

    public void iniciar(Stage stage) {
        stage.setTitle("Sistema de Vendas Online");

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label("Menu Principal - Sistema de Vendas");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button btnUsuarios = new Button("Cadastrar Usuários");
        Button btnProdutos = new Button("Cadastrar Produtos");
        Button btnClientes = new Button("Cadastrar Clientes");
        Button btnFormaPagamento = new Button("Formas de Pagamento");
        Button btnVendas = new Button("Registrar Venda"); // <- Novo botão!

        btnUsuarios.setPrefWidth(200);
        btnProdutos.setPrefWidth(200);
        btnClientes.setPrefWidth(200);
        btnFormaPagamento.setPrefWidth(200);
        btnVendas.setPrefWidth(200);

        btnUsuarios.setOnAction(e -> new UsuarioView().exibir());
        btnProdutos.setOnAction(e -> new ProdutoView().exibir());
        btnClientes.setOnAction(e -> new ClienteView().exibir());
        btnFormaPagamento.setOnAction(e -> new FormaPagamentoView().exibir());
        btnVendas.setOnAction(e -> new VendaView().exibir());

        layout.getChildren().addAll(lblTitulo, btnUsuarios, btnProdutos, btnClientes, btnFormaPagamento, btnVendas);

        Scene scene = new Scene(layout, 500, 450);
        stage.setScene(scene);
        stage.show();
    }
}