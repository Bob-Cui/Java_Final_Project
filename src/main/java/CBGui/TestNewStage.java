package main.java.CBGui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.java.CBGui.SpecificStage.CBMain;

import java.io.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class TestNewStage extends Application {
    private static Stage mainStage;

    @FXML
    private VBox leftScene;

    @FXML
    private TreeView<?> leftTree;

    @FXML
    private BorderPane mainScene;


    @FXML
    void deal_text(ActionEvent event) {


    }

    @FXML
    private WebView test_View;


    @FXML
    void changeWebView(ActionEvent event) throws MalformedURLException {
        String html = "<html><h1>Hello</h1><h2>Hello</h2></html>";
        File file = new File("C:\\Users\\DELL\\Desktop\\fuck.html");
        URL url = file.toURI().toURL();
        test_View.getEngine().load(url.toString());
    }


    @FXML
    void a46df7ec(ActionEvent event) {

    }

    @FXML
    void fileManager(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("张辉");
        fileChooser.showOpenDialog(mainStage);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        mainStage = primaryStage;

        primaryStage = new CBMain();
        primaryStage.show();


        //        URL url = getClass().getClassLoader().getResource("main.fxml");
//        if (url == null) {
//            System.out.println("找不到文件");
//        } else {
//            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("main.fxml")));
//
//
//            Scene scene = new Scene(root, 700, 700);
//
//
//
//
//            mainStage.setTitle("Hello World");
//            mainStage.setScene(new Scene(root, 600, 600));
//            mainStage.show();
//        }
    }

    public void change() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("main.fxml")));
        mainStage.setTitle("Hello World");
        mainStage.setScene(new Scene(root, 500, 500));
        mainStage.show();

    }


}
