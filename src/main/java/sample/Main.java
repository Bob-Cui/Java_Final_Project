package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {
    private static Stage mainStage;
    @FXML
    private ListView<String> fucklistview;

    @FXML
    private TextField mytext;

    @FXML
    private Button find__build;

    @FXML
    private Button contentChange;
    @FXML
    private Button fuckbutton;

   // @//FXML
    //private ListView<?> fucklistview;

    @FXML
    void actionFuck(ActionEvent event) {
        initListView();
    }

    @FXML
    private TextArea content;

    @FXML
    void deal_text(ActionEvent event) {


    }

    @FXML
    private WebView test_View;

    @FXML
    private Button changeWeb;

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

        mainStage = primaryStage;
        URL url = getClass().getClassLoader().getResource("main.fxml");
        if (url == null) {
            System.out.println("找不到文件");
        } else {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("main.fxml")));

         //   initListView();

            mainStage.setTitle("Hello World");
            mainStage.setScene(new Scene(root, 600, 600));
            mainStage.show();
        }
    }

    private void initListView() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("姓名：杨先生	年龄：18	性别：男");
        list.add("姓名：杨女生1	年龄：18	性别：女");
        list.add("姓名：杨女生2	年龄：18	性别：女");
        list.add("姓名：杨女生3	年龄：18	性别：女");
        list.add("姓名：杨女生4	年龄：18	性别：女");
       fucklistview = new ListView<>(list);
        fucklistview.setItems(list);


    }

    public void change() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("main.fxml")));
        mainStage.setTitle("Hello World");
        mainStage.setScene(new Scene(root, 500, 500));
        mainStage.show();

    }


}
