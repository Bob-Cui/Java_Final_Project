package main.java.CBGui.SpecificStage;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static DataManager.DataProcess.JsonManager.MIDTEST;
import static DataManager.DataProcess.JsonManager.getNewProblems;

public class HaveTest extends Stage {

    /**
     * 有关三个考试的按钮
     */
    private Button priTest, midTest, senTest;

    public HaveTest() {
        this.getIcons().add(new Image("file:src/Source/cqyj.png"));
        this.setTitle("欢迎参加测试");

        VBox mainVBox = new VBox();
        {
/**
 * 有趣的是三个按钮不能只用一个图，必须用三张图
 */
            double len = 38;
            Image image1 = new Image("file:src/Source/test.png", len, len, false, false);
            ImageView imageView1 = new ImageView(image1);
            priTest = new Button();
            priTest.setText("初级考核测试");
            priTest.setStyle("-fx-font-size: 23px;-fx-background-radius:25px ");
            priTest.setGraphic(imageView1);
            priTest.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //双击会显示
                    if (mouseEvent.getClickCount() == 2) {
                        try {
                            TestStage testStage = new TestStage("初", getNewProblems(MIDTEST));
                            testStage.showAndWait();


                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }
            });


            Image image2 = new Image("file:src/Source/test.png", len, len, false, false);
            ImageView imageView2 = new ImageView(image2);
            midTest = new Button();
            midTest.setText("中级考核测试");
            midTest.setStyle("-fx-font-size: 23px;-fx-background-radius:25px");
            midTest.setGraphic(imageView2);
            midTest.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getClickCount() == 2) {
                        try {
                            TestStage testStage = new TestStage("中", getNewProblems(MIDTEST));
                            testStage.showAndWait();


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                }
            });
            Image image3 = new Image("file:src/Source/test.png", len, len, false, false);
            ImageView imageView3 = new ImageView(image3);
            senTest = new Button();
            senTest.setText("高级考核测试");
            senTest.setStyle("-fx-font-size: 23px;-fx-background-radius:25px");
            senTest.setGraphic(imageView3);
            senTest.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getClickCount() == 2) {
                        try {
                            TestStage testStage = new TestStage("高", getNewProblems(MIDTEST));
                            testStage.showAndWait();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            mainVBox.getChildren().addAll(priTest, midTest, senTest);
            mainVBox.setSpacing(20);

            mainVBox.setStyle("-fx-background-image: url("+"file:src/Source/leftback.png"+")");


            this.initModality(Modality.APPLICATION_MODAL);
            this.setResizable(false);
            this.setScene(new Scene(mainVBox));

        }
    }
}
