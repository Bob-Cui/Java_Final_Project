package main.java.CBGui.LearnJavaFX;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * 学习使用手风琴布局以及警告弹出框
 */
public class LearnAccordion extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group g = new Group();
        Scene scene = new Scene(g, 550, 250);
        Button button = new Button();


        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("警告对话框");
                alert.setHeaderText("头部内容");
                alert.setContentText("文本内容");
                alert.showAndWait();
            }
        });
        button.setText("测试");
        TitledPane t1 = new TitledPane("T1", button);
        TitledPane t2 = new TitledPane("T2", new Button("B2"));
        TitledPane t3 = new TitledPane("T3", new Button("B3"));
        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(t1, t2, t3);


        accordion.expandedPaneProperty().addListener(
                (ObservableValue<? extends TitledPane> ov, TitledPane old_val,
                 TitledPane new_val) -> {
                    if (new_val != null) {
                        System.out.println(accordion.getExpandedPane().getText());
                    }
                });


        g.getChildren().add(accordion);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
