package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        HomePage tela = new HomePage();
        tela.iniciar(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}