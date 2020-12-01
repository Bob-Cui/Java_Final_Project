package main.java.CBGui.LearnJavaFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LearnCircleButton extends Application {

    private Scene scene;
    private Text questionContent;



    private class Test {
        private int i;

        public Test(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
//        text = new Text();
//        text.setText("需要修改");
//        text.setStyle("-fx-font-size: 30px");
//
//
//        HBox hBox = new HBox(text);
//
//        for (int i = 0; i < 10; i++) {
//            Button button = new Button();
//
//            button.setUserData(new Test(i));
//
//            button.setText("1");
//            button.setStyle("-fx-background-radius: 25;-fx-border-radius: 25");
//            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent mouseEvent) {
//
//                    text.setText(String.format("%d", ((Test) button.getUserData()).getI()));
//                }
//            });
//
//
//            hBox.getChildren().add(button);
//        }


     //

    }
}
