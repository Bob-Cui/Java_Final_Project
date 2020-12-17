package main.java.CBGui.SpecificStage;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

/**
 * 用于登录选角色的窗体
 */
public class LoginStage extends Stage {

    private GridPane mainGridPane;
    /**
     * 学校学习和业余学习
     */
    private Label XX, YY;

    public LoginStage() {


        Image image = new Image("file:src/Source/zy.png", 450, 450, true, true);

        double big = 1.1;

        {
            XX = new Label("学校学习", new ImageView(image));
            XX.setContentDisplay(ContentDisplay.TOP);
            XX.setStyle("-fx-font-size: 25px;-fx-font-weight: bold;-fx-text-fill: white");
            XX.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    XX.setScaleX(big);
                    XX.setScaleY(big);
                }
            });
            XX.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    XX.setScaleX(1);
                    XX.setScaleY(1);
                }
            });
            XX.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    if (mouseEvent.getClickCount() == 2) {


                    }

                }
            });
        }
        {
            YY = new Label("业余学习", new ImageView(image));
            YY.setContentDisplay(ContentDisplay.TOP);
            YY.setStyle("-fx-font-size: 25px;-fx-font-weight: bold;-fx-text-fill: white");
            YY.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    YY.setScaleX(big);
                    YY.setScaleY(big);
                }
            });
            YY.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    YY.setScaleX(1);
                    YY.setScaleY(1);
                }
            });
            YY.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getClickCount() == 2) {
                    }
                }
            });
        }
        {
            mainGridPane = new GridPane();
            mainGridPane.add(XX, 1, 1);
            mainGridPane.add(YY, 2, 1);
            mainGridPane.addColumn(3);
            mainGridPane.setVgap(20);
            mainGridPane.setHgap(100);

            mainGridPane.setStyle("-fx-background-color: linear-gradient(to top, hotpink, whitesmoke)");
//            mainGridPane.setStyle("-fx-background-image: url(" + "file:src/Source/loginjava.png" + ")");
            mainGridPane.setPadding(new Insets(10, 10, 10, 10));
        }


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();


        mainGridPane.setMinWidth(dimension.getWidth() / 2);
        mainGridPane.setMinHeight(dimension.getHeight() / 2);


        this.setScene(new Scene(mainGridPane, dimension.getWidth() / 2, dimension.getHeight() / 2));
    }


}
