package main.java.CBGui;

import javafx.application.Application;
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
import main.java.CBGui.SpecificStage.LoginStage;
import main.java.CBGui.SpecificStage.XCYMain;

import java.io.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class TestNewStage extends Application {


    /**
     * 运行时调用start
     * @param primaryStage
     * @throws Exception 异常
     */
    @Override
    public void start(Stage primaryStage) throws Exception {


//        LoginStage loginStage = new LoginStage();
//        loginStage.showAndWait();



        primaryStage = new XCYMain();
        primaryStage.show();
    }
}
