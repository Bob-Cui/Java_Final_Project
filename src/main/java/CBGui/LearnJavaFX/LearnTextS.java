package main.java.CBGui.LearnJavaFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;

public class LearnTextS extends Application {


    @Override
    public void start(Stage stage) {


        Text text = new Text();
        text.setText("fasdfd dfgvfdgdf fdgdf gdf \ndffsdfewfwaefsdfas");


        ImageView imageView = new ImageView(new Image("file:src/source/timg.jpg", 50, 50, true, true));


        Label label = new Label("", imageView);


        Group group = new Group();

        Circle checkProgressCircleButtom = new Circle();
        checkProgressCircleButtom.setRadius(28);
        checkProgressCircleButtom.setFill(Color.BLUE);



        label.setWrapText(true);


        label.setStyle("-fx-background-radius: 50px;-fx-border-radius: 100px;-fx-background-color: cadetblue;-fx-border-width: 10px;-fx-border-color: red");

        label.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {


                label.setScaleX(1.5);
                label.setScaleY(1.5);

            }
        });
        label.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label.setScaleX(1);
                label.setScaleY(1);
            }
        });
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Image image = new Image("file:src/Source/icon.jpg", 100, 100, true, true);


                Label dog = new Label("", new ImageView(image));
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setGraphic(dog);


                alert.showAndWait();

            }
        });

        Button button = new Button();
        Image image = new Image("file:src/Source/icon.jpg", 100, 100, true, true);

        button.setGraphic(new ImageView(image));

        button.setStyle("-fx-background-radius: 50px;-fx-border-radius: 50px");




        HBox hBox = new HBox(button);

        Scene scene = new Scene(hBox);


//        scene.getStylesheets().add();
        stage.setScene(scene);
        stage.show();


    }
}
