package main.java.CBGui.LearnJavaFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 学会使用圆形的按钮
 * 学会使用Group
 * 学会使用叠加的方式调整颜色
 * 哈哈哈哈哈我真是个天才
 */
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


        HBox hBox = new HBox();

        Circle circle = new Circle();
        Button button = new Button();

        button.setStyle("-fx-border-radius: 40px;-fx-background-color: #4183C4");
        button.setMinWidth(100);
        Group group = new Group();

//        circle.setCenterX(200);
//        c/ircle.setCenterY(200);
        circle.setRadius(35);
        Circle circle1 = new Circle();
        circle1 = new Circle();
        circle1.setFill(Color.CHOCOLATE);

        circle1.setRadius(40);
        circle.setFill(Color.RED);
        circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                circle.setFill(Color.BLUE);
            }
        });
        group.getChildren().add(circle1);
        group.getChildren().add(circle);

        circle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                circle.setFill(Color.RED);
            }
        });
        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });


        hBox.getChildren().add(group);
        stage.setScene(new Scene(hBox));
        stage.show();
    }


    //

}

