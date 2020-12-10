package main.java.CBGui.LearnJavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LearnTextS extends Application {


    @Override
    public void start(Stage stage)  {


        Text text = new Text();
        text.setText("fasdfd dfgvfdgdf fdgdf gdf \ndffsdfewfwaefsdfas");
        HBox hBox = new HBox(text);

        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();


    }
}
