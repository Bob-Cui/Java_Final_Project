package main.java.CBGui.LearnJavaFX;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * 学习如何使用网格布局以及使用listview
 */
public class LearnListView extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Text text = new Text("fuck");
        Text text1 = new Text("fucknew");


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500, 500);
//        GridPane.setRowIndex();头一次见这么奇怪的方法
//        gridPane.setStyle("-fx-font-size: 20px");
        gridPane.add(text, 2, 2);
        gridPane.add(text1, 0, 1);
        Scene scene = new Scene(gridPane);

        ObservableList<Problem> fuck = FXCollections.observableArrayList();

        fuck.addAll(new Problem("张三", "问我", "张辉"), new Problem("张三", "问我", "张辉"), new Problem("张三", "问我", "张辉"), new Problem("李四", "问我", "张辉"));

        ListView<Problem> listView = new ListView<>(fuck);

//        listView.setCellFactory(new Callback<ListView<Problem>, ListCell<Problem>>() {
//            @Override
//            public ListCell<Problem> call(ListView<Problem> problemListView) {
//
//
//                return new ProCell();
//            }
//        });

        listView.setCellFactory(new Callback<ListView<Problem>, ListCell<Problem>>() {
            @Override
            public ListCell<Problem> call(ListView<Problem> problemListView) {
                return new ProCell();
            }
        });

        listView.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number last, Number t1) {
                        System.out.println(listView.getItems().get(t1.intValue()).toString());
                        System.out.println("dafsd ");

                    }
                }
        );
        gridPane.add(listView, 2, 3);

        // gridPane.getChildren().addAll(text, text1);//可以增加多参数果然是有趣的紧
        stage.setTitle("learn listview");
        stage.setScene(scene);
        stage.show();


        Problem c = new Problem("fdsa", "fdas", "dsfa");


        c.getAnswer();
    }

    private class ProCell extends ListCell<Problem> {
        private HBox content;
        private VBox mainConten;
        private Text name;
        ToggleGroup select;


        public ProCell() {
            super();
            select = new ToggleGroup();
            RadioButton A = new RadioButton("Afasdfsadf");
            RadioButton B = new RadioButton("B");
            RadioButton C = new RadioButton("C");
            RadioButton D = new RadioButton("D");
            A.setToggleGroup(select);
            B.setToggleGroup(select);
            C.setToggleGroup(select);
            D.setToggleGroup(select);

            A.setUserData("Afgdsdfgsdf gddsald");//这可真是神奇的获取数据的方式
            B.setUserData("B");
            C.setUserData("C");
            D.setUserData("D");


//            select.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//                @Override
//                public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
//                    if (select.getSelectedToggle() != null) {
//
//
//                        System.out.println(select.getSelectedToggle().getUserData());
//                    }
//                }
//            });
            select.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                    System.out.println(select.getSelectedToggle().getUserData());
                }
            });


            name = new Text("这是一道题");
            content = new HBox(A, B, C, D);
            content.setSpacing(20);
            mainConten = new VBox(name, content);
            mainConten.setPrefHeight(100);

        }

        @Override
        protected void updateItem(Problem problem, boolean b) {
//            super.updateItem(problem, b);
            if (problem != null && !b) {

                name.setText(problem.getName());
                content.applyCss();
                setGraphic(mainConten);

            } else {
                setGraphic(null);
            }


        }
    }

    private static class Problem {
        private String name;
        private String answer;
        private String ques;

        public Problem(String name, String answer, String ques) {
            this.name = name;
            this.answer = answer;
            this.ques = ques;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getQues() {
            return ques;
        }

        public void setQues(String ques) {
            this.ques = ques;
        }

        @Override
        public String toString() {
            return name + "  " + answer + "   " + ques;


        }
    }


}
