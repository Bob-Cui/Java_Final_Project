package main.java.CBGui.SpecificStage;

import DataManager.Data.UserData;
import DataManager.XcyDataBase;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.CBGui.XCYApplication;

import java.awt.*;
import java.sql.SQLException;


public class LoginStage extends Stage {


    public LoginStage() {


        this.getIcons().add(new Image("file:src/Source/icon.jpg"));


        Label l_name = new Label("账号");
        Label l_password = new Label("密码");


        TextField userName = new TextField();

        PasswordField password = new PasswordField();

        Button login = new Button("登录");
        Button clear = new Button("注册");

        login.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (userName.getText().equals("") || password.getText().equals("")) {
                    double len = 40;
                    Alert fail = new Alert(Alert.AlertType.WARNING);


                    Image image = new Image("file:src/Source/icon.jpg", len, len, true, true);
                    fail.setGraphic(new ImageView(image));
                    // fail.setGraphic();
                    fail.setTitle("登陆失败");
                    fail.setHeaderText("信息输入不全");
                    fail.setContentText("请输入完整的个人信息");

                    fail.showAndWait();
                } else {
                    String name = userName.getText();
                    String passWord = password.getText();


                    System.out.println(name);
                    System.out.println(passWord);
                    try {
                        UserData userData = XcyDataBase.searchUser(name, passWord);
                        if (userData == null) {
                            double len = 40;
                            Alert fail = new Alert(Alert.AlertType.WARNING);
/**
 * 没必要在这个地方过于精细
 */
                            Image image = new Image("file:src/Source/icon.jpg", len, len, true, true);
                            fail.setGraphic(new ImageView(image));
                            // fail.setGraphic();
                            fail.setTitle("登陆失败");
                            fail.setHeaderText("用户不存在或密码错误");
                            fail.setContentText("请输入完整、正确的个人信息");
                            fail.showAndWait();
                        } else {
                            XCYApplication.setUserData(userData);
/**
 * 关掉页面
 */
                            close();
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }

            }
        });


        //网格布局
        GridPane gr = new GridPane();


        gr.add(l_name, 0, 0);
        gr.add(userName, 1, 0);
        gr.add(l_password, 0, 1);
        gr.add(password, 1, 1);
        gr.add(clear, 0, 2);
        gr.add(login, 1, 2);


        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);


        Label welcome = new Label();
        welcome.setText("欢迎来到小谢的Java学习网站");

        welcome.setStyle("");

        Image image = new Image("file:src/Source/smy1.png", 220, 220, true, true);
        welcome.setGraphic(new ImageView(image));


        welcome.setContentDisplay(ContentDisplay.BOTTOM);
        welcome.setStyle("-fx-text-fill: hotpink;-fx-font-size: 25px;-fx-font-weight: bold");

        //全部居中
        gr.setAlignment(Pos.CENTER);
        //水平间距
        gr.setHgap(5);
        //垂直间距
        gr.setVgap(15);
        //设置登录左边外边距
        GridPane.setMargin(login, new Insets(0, 0, 0, 120));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();


        VBox mainVBox = new VBox();

        mainVBox.setAlignment(Pos.CENTER);


        mainVBox.setSpacing(30);
        mainVBox.getChildren().add(welcome);
        mainVBox.getChildren().add(gr);

        mainVBox.setStyle("-fx-background-image: url(" + "file:src/Source/loginbg.png" + ")");


        Scene s = new Scene(mainVBox, dimension.getWidth() / 2, dimension.getHeight() / 2);


        this.setScene(s);
    }
}
