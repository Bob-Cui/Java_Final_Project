package main.java.CBGui.SpecificStage;

import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegisterStage extends Stage {

    /**
     * 这个界面从简设计
     */
    public RegisterStage() {
//        Label
        this.getIcons().add(new Image("file:src/Source/icon.jpg"));
        this.setTitle("欢迎来到登录页面");


        Label yourName = new Label();
        Label passWord = new Label();
        Label repeatPassWord = new Label();


        TextField inputName = new TextField();
        PasswordField inputPassWord1 = new PasswordField();
        PasswordField inputPassWord2 = new PasswordField();


        Button register = new Button();
        register.setText("注册");


        register.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {








            }
        });




        this.setResizable(false);
        this.initModality(Modality.APPLICATION_MODAL);
    }
}
