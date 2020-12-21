package main.java.CBGui.SpecificStage;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Register extends Stage {

    /**
     * 这个界面从简设计
     */
    public Register() {
//        Label
        this.getIcons().add(new Image("file:src/Source/icon.jpg"));
        this.setTitle("欢迎来到登录页面");





        Label yourName = new Label();
        Label passWord = new Label();
        Label repeatPassWord = new Label();

        Button register = new Button();
        register.setText("注册");


        register.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
//        register.setOnMouseClicked();







        this.setResizable(false);
        this.initModality(Modality.APPLICATION_MODAL);
    }
}
