package XCYMain.SpecificStage;

import DataManager.Data.UserData;
import DataManager.JsonManager;
import DataManager.XcyDataBase;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

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
        Label secreteQuestion = new Label();


        yourName.setStyle("-fx-text-fill: #9400D3");
        passWord.setStyle("-fx-text-fill: #9400D3");
        repeatPassWord.setStyle("-fx-text-fill: #9400D3");
        secreteQuestion.setStyle("-fx-text-fill: #9400D3");


        yourName.setText("输入用户名");
        passWord.setText("输入密码");
        repeatPassWord.setText("再次输入密码");

        secreteQuestion.setText("输入你的密保问题");
        secreteQuestion.setWrapText(true);


        VBox leftVBox = new VBox();
        VBox rightVBox = new VBox();


        leftVBox.getChildren().addAll(yourName, passWord, repeatPassWord, secreteQuestion);


        TextField inputName = new TextField();
        PasswordField passWordInput1 = new PasswordField();
        PasswordField passWordInput2 = new PasswordField();
        TextField secreQusetion = new TextField();


        rightVBox.getChildren().addAll(inputName, passWordInput1, passWordInput2, secreQusetion);
        GridPane mainGridPane = new GridPane();


        mainGridPane.add(leftVBox, 1, 1);
        mainGridPane.add(rightVBox, 2, 1);


        leftVBox.setSpacing(8);

        leftVBox.setStyle("-fx-font-size: 15px;-fx-text-fill: #9400D3;-fx-font-weight: bolder");

        rightVBox.setSpacing(5);

        mainGridPane.setHgap(10);

        Button register = new Button();

        register.setText("注册");


        register.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (inputName.getText().equals("") || passWordInput1.getText().equals("") || passWordInput2.getText().equals("")) {
                    double len = 40;
                    Alert fail = new Alert(Alert.AlertType.WARNING);


                    Image image = new Image("file:src/Source/icon.jpg", len, len, true, true);
                    fail.setGraphic(new ImageView(image));
                    // fail.setGraphic();
                    fail.setTitle("注册失败");
                    fail.setHeaderText("信息输入不全");
                    fail.setContentText("请输入完整的个人信息");

                    fail.showAndWait();
                    inputName.setText("");
                    passWordInput2.setText("");
                    passWordInput1.setText("");
                    return;
                } else if (!passWordInput1.getText().equals(passWordInput2.getText())) {
                    double len = 40;
                    Alert fail = new Alert(Alert.AlertType.WARNING);


                    Image image = new Image("file:src/Source/icon.jpg", len, len, true, true);
                    fail.setGraphic(new ImageView(image));
                    // fail.setGraphic();
                    fail.setTitle("注册失败");
                    fail.setHeaderText("密码输入有误");
                    fail.setContentText("第一次密码输入与第二次密码输入不相同");
                    fail.showAndWait();
                    inputName.setText("");
                    passWordInput2.setText("");
                    passWordInput1.setText("");
                    return;

                } else {

                    double len = 40;
                    Alert success = new Alert(Alert.AlertType.WARNING);

                    try {
                        UserData userData = new UserData(inputName.getText(), passWordInput1.getText(), 0);
                        userData.setUserData(JsonManager.createNewUser());
                        XcyDataBase.register(userData);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Image image = new Image("file:src/Source/sencq.png", len, len, true, true);
                    success.setGraphic(new ImageView(image));
                    // fail.setGraphic();
                    success.setTitle("注册成功");
                    success.setHeaderText("新用户注册成功");
                    success.setContentText("请返回登录页面开始你的学习吧");
                    success.showAndWait();
                    inputName.setText("");
                    passWordInput2.setText("");
                    passWordInput1.setText("");
                    secreQusetion.setText("");
                    return;


                }

            }
        });


        register.setStyle("-fx-background-radius: 20px;-fx-text-fill: hotpink;-fx-font-size: 15px;-fx-border-radius: 20px;");
        mainGridPane.add(register, 1, 2);


        mainGridPane.setStyle("-fx-background-image: url(" + "file:src/Source/loginbg.png" + ")");
        this.setScene(new Scene(mainGridPane));
        this.setResizable(false);
        this.initModality(Modality.APPLICATION_MODAL);
    }
}
