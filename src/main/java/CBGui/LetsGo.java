package main.java.CBGui;

import DataManager.Data.UserInformation;
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
import main.java.CBGui.MyStages.LoginStage;
import main.java.CBGui.MyStages.SuperCB;

import java.io.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class LetsGo extends Application {

    /**
     * 数据来源
     */
    public static UserInformation userInformation;

    static {

        userInformation = null;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        LoginStage loginStage = new LoginStage();
//
//        loginStage.showAndWait();

        primaryStage = new SuperCB();
        primaryStage.show();



    }



}
