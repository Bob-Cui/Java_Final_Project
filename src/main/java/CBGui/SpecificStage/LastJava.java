package main.java.CBGui.SpecificStage;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LastJava extends Stage {

    private WebView introJavaWebView;


    /**
     * 介绍java的最新进展
     */
    public LastJava() throws MalformedURLException {

        introJavaWebView = new WebView();
        File file = new File("src/pages/lastestJava.html");
        URL url = file.toURI().toURL();
        introJavaWebView.getEngine().load(url.toString());


        GridPane gridPane = new GridPane();

        gridPane.add(introJavaWebView, 1, 1);
        gridPane.setHgap(100);
        gridPane.setVgap(50);


        {
            Image image = new Image("file:src/Source/pricq.png", 40, 40, true, true);
            this.getIcons().add(image);
            this.setTitle("Java最新特性");
        }
        {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            this.setWidth(dimension.getWidth());
            this.setHeight(dimension.getHeight() );
            this.setResizable(false);
        }

        gridPane.setStyle("-fx-background-image: url(" + "file:src/Source/leftback.png" + ")");
        this.setScene(new Scene(gridPane));
    }
}
