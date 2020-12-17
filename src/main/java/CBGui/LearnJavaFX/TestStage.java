package main.java.CBGui.LearnJavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.CBGui.SpecificStage.LoginStage;

public class TestStage extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        stage = new LoginStage();


        stage.show();



    }
}
