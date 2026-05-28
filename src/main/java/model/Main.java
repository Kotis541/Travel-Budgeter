package model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    @Override
    public void start(Stage primarystage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 800, 800);

        primarystage.setTitle("Nomad Budget Manager");
        primarystage.setScene(scene);
        primarystage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
