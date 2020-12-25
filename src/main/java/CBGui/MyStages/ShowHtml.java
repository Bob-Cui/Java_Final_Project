package main.java.CBGui.MyStages;

import javafx.geometry.Pos;
import javafx.scene.LightBase;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 只显示数据结构的知识
 */
public class ShowHtml extends Stage {

    private WebView mainWebView;

    /**
     * 介绍java的最新进展
     */
    public ShowHtml(String titleName, String address) throws MalformedURLException {

        this.setTitle(titleName);
        mainWebView = new WebView();
        File file = new File(address);
        URL url = file.toURI().toURL();
        mainWebView.getEngine().load(url.toString());


        GridPane gridPane = new GridPane();
        gridPane.add(mainWebView, 1, 1);

        gridPane.add(new Label(), 2, 1);

        gridPane.setHgap(50);
        gridPane.setVgap(50);
        {
            Image image = new Image("file:src/Source/javafa.jpg", 40, 40, true, true);
            this.getIcons().add(image);
        }
        {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            //     mainWebView.setMinWidth(dimension.getWidth());
            this.setWidth(3 * dimension.getWidth() / 4);
            this.setHeight(5 * dimension.getHeight() / 6);
//          、、  this.setResizable(false);
        }
        //   gridPane.setStyle("-fx-background-image: url(" + "file:src/Source/javaback.png" + ")");
        HBox mainHBox = new HBox(mainWebView);

        mainHBox.setStyle("-fx-background-image: url(" + "file:src/Source/javaback.jpg" + ")");
        mainHBox.setAlignment(Pos.CENTER);


        this.setScene(new Scene(mainHBox));
    }
}
