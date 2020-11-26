package main.java.CBGui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

/**
 * 测试学习如何使用FXML
 */
public class LearnFXML extends Application {
    public static Stage mainStage;
    public Stage stage;
    @FXML
    private VBox leftScene;

    @FXML
    private Button fuckButtom;

    @FXML
    private BorderPane mainScene;

    /**
     * 这种方式修改界面让我很吃惊
     * @param event
     * @throws Exception
     */
    @FXML
    void learnButton(ActionEvent event) throws Exception {
        URL url = getClass().getResource("sample.fxml");


        Text text = new Text("fuck");
        Text text1 = new Text("fucknew");


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500, 500);
//        GridPane.setRowIndex();头一次见这么奇怪的方法
        gridPane.setStyle("-fx-font-size: 20px");
        gridPane.add(text, 2, 2);
        gridPane.add(text1, 0, 1);
        Scene scene = new Scene(gridPane);
        mainStage.setTitle("Hello World");
        mainStage.setScene(scene);
        mainStage.show();

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        mainStage = primaryStage;
        URL url = getClass().getResource("main.fxml");


        if (url == null) {
            System.out.println("找不到文件");
        } else {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));


            //    Scene scene = new Scene(root, 700, 700);


            mainStage.setTitle("Hello World");
            mainStage.setScene(new Scene(root, 600, 600));
            mainStage.show();
        }


    }
}
