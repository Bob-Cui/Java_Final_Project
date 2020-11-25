package main.java.CBGui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

        gridPane.add(text, 2, 2);
        gridPane.add(text1, 0, 1);
        Scene scene = new Scene(gridPane);

        ObservableList<Problem> fuck = FXCollections.observableArrayList();

        fuck.addAll(new Problem("张三", "问我", "张辉"), new Problem("张三", "问我", "张辉"), new Problem("张三", "问我", "张辉"), new Problem("李四", "问我", "张辉"));

        ListView<Problem> listView = new ListView<>(fuck);

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
                    }
                }
        );
        gridPane.add(listView, 2, 3);

        // gridPane.getChildren().addAll(text, text1);//可以增加多参数果然是有趣的紧
        stage.setTitle("learn listview");

        stage.setScene(scene);
        stage.show();


    }

    private class ProCell extends ListCell<Problem> {
        private HBox content;
        private Text name;
        private Text price;

        public ProCell() {
            super();
            name = new Text();
            price = new Text();
            VBox vBox = new VBox(name, price);
            content = new HBox(new Label("fuck"), vBox);
            content.setSpacing(10);

        }

        @Override
        protected void updateItem(Problem problem, boolean b) {
            super.updateItem(problem, b);
            if (problem != null && !b) {

                //Color.web()
                name.setText(problem.getName());
                price.setText(problem.getQues());
                setGraphic(content);

            } else {
                setGraphic(null);
            }


        }
    }

    private static class Problem {
        private String name;
        private String answer;
        private String ques;

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

        public Problem(String name, String answer, String ques) {
            this.name = name;
            this.answer = answer;
            this.ques = ques;
        }

        @Override
        public String toString() {
            return name + "  " + answer + "   " + ques;


        }
    }


}
