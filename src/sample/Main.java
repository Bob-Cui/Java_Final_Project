package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL url = getClass().getClassLoader().getResource("sample.fxml");
        if (url == null) {
            System.out.println("找不到文件");
        } else {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));


            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 500, 500));
            primaryStage.show();
        }
    }


}
