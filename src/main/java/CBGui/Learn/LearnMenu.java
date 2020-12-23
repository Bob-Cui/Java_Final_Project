package main.java.CBGui.Learn;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LearnMenu extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Menus");
        HBox hBox = new HBox();
        ProgressIndicator p1 = new ProgressIndicator();
        p1.setProgress(0.75F);
        hBox.getChildren().add(p1);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();

    }
}
