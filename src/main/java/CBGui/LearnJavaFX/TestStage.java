package main.java.CBGui.LearnJavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.CBGui.SpecificStage.AfterLoginStage;

public class TestStage extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        stage = new AfterLoginStage();


        stage.show();



    }
}
