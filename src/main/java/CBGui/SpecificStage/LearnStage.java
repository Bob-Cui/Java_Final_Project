package main.java.CBGui.SpecificStage;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 专用于展示学习Java用的页面
 */
public class LearnStage extends Stage {

    private Scene scene;
    private HBox hBox;


    public LearnStage() throws MalformedURLException {
        WebView webView = new WebView();

        File file = new File("C:\\Users\\DELL\\Desktop\\fuck.html");
        URL url = file.toURI().toURL();
        webView.getEngine().load(url.toString());

        hBox = new HBox(webView);
        scene = new Scene(hBox);
        this.setScene(scene);
    }
    public LearnStage(String address)
    {

    }

}
