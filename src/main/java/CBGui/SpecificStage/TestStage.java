package main.java.CBGui.SpecificStage;

import DataManager.Data.NewProblems;
import DataManager.Data.NewSelectProblem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

//import javax.swing.text.html.ListView;
import java.io.IOException;
import java.util.Map;

/**
 * 用于显示能够用来测试的界面
 * 这个界面可以复用
 */
public class TestStage extends Stage {
    private ListView<NewSelectProblem> mainListView;

    /**
     * 提交试卷
     */
    private Button submit;

    /**
     * @param title       这个参数的类型只能是 初 中 高
     * @param newProblems
     */
    public TestStage(String title, NewProblems newProblems) {

        {
            this.getIcons().add(new Image("file:src/Source/icon.jpg"));
            this.setTitle(String.format("欢迎参加这场激动人心的%s级考试", title));
        }
        {
            ObservableList<NewSelectProblem> newSelectProblemObservableList = FXCollections.observableArrayList();
            for (Map.Entry<Integer, NewSelectProblem> integerNewSelectProblemEntry : newProblems.getIntegerNewSelectProblemHashMap().entrySet()) {
                newSelectProblemObservableList.add(integerNewSelectProblemEntry.getValue());
            }
            mainListView = new ListView<>(newSelectProblemObservableList);

            mainListView.setCellFactory(new Callback<ListView<NewSelectProblem>, ListCell<NewSelectProblem>>() {
                @Override
                public ListCell<NewSelectProblem> call(ListView<NewSelectProblem> newSelectProblemListView) {
                    return new TestProblemCell();
                }
            });

            mainListView.setMinHeight(800);
            mainListView.setMinWidth(600);
        }

        submit = new Button("考试完成");
        submit.setAlignment(Pos.CENTER_RIGHT);


        Image image = new Image("file:src/Source/listcq.png", 25, 25, true, true);
        submit.setGraphic(new ImageView(image));

        submit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    for (Map.Entry<Integer, NewSelectProblem> integerNewSelectProblemEntry : newProblems.getIntegerNewSelectProblemHashMap().entrySet()) {
                        if (integerNewSelectProblemEntry.getValue().getYourAnswer() == ' ') {
                            Alert fail = new Alert(Alert.AlertType.WARNING);
                            Image image = new Image("file:src/Source/icon.jpg", 50, 50, true, true);
                            fail.setGraphic(new ImageView(image));
                            fail.setTitle("有未完成的题目");
                            fail.setHeaderText("请完成未完成的题目");
                            fail.setContentText("你有没有完成的题目吗,请完成后在提交");
                            fail.showAndWait();
                            return;
                        }

                    }


                    int right = 0;
                    try {
                        right = XCYMain.passOrNot(title);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                    if (right < 15) {
                        Alert fail = new Alert(Alert.AlertType.WARNING);
                        Image image = new Image("file:src/Source/icon.jpg", 50, 50, true, true);
                        fail.setGraphic(new ImageView(image));
                        fail.setTitle("未及格");
                        fail.setHeaderText("请完成未完成的题目");
                        fail.setContentText("错误的题目太多，请重新参加考试");
                        fail.showAndWait();

                    } else {
                        Alert success = new Alert(Alert.AlertType.WARNING);
                        Image image = new Image("file:src/Source/icon.jpg", 50, 50, true, true);
                        success.setGraphic(new ImageView(image));
                        success.setTitle("考试通过");
                        success.setHeaderText("恭喜");
                        success.setContentText("请继续下一章的学习吧");
                        success.showAndWait();
                    }
                }
            }
        });


        GridPane gridPane = new GridPane();
        gridPane.add(mainListView, 1, 1);
        gridPane.add(submit, 1, 2);
        gridPane.add(new Label(), 2, 1);
        GridPane.setHalignment(submit, HPos.CENTER);
        gridPane.setHgap(10);


        this.setScene(new Scene(gridPane));
        this.initModality(Modality.APPLICATION_MODAL);
    }

    private static class TestProblemCell extends ListCell<NewSelectProblem> {
        private VBox mainVBox;
        private HBox a, b, c, d, problem;
        private Label labelA, labelB, labelC, labelD, content, labelCount;
        private ToggleGroup select;
        private RadioButton radioButtonA, radioButtonB, radioButtonC, radioButtonD;

        public TestProblemCell() {
            mainVBox = new VBox();

            select = new ToggleGroup();
            {//无聊的初始化函数
                labelA = new Label();
                labelB = new Label();
                labelC = new Label();
                labelD = new Label();
                content = new Label();
                labelCount = new Label();//
            }
            {


                content.setStyle("-fx-font-size: 15px;-fx-font-weight: bold");
                labelCount.setStyle("-fx-font-size: 16px;-fx-font-weight: bold");
            }
            {//使得文本可以自动换行


                labelA.setWrapText(true);
                labelB.setWrapText(true);
                labelC.setWrapText(true);
                labelD.setWrapText(true);
                content.setWrapText(true);

            }


            radioButtonA = new RadioButton("A");
            radioButtonB = new RadioButton("B");
            radioButtonC = new RadioButton("C");
            radioButtonD = new RadioButton("D");

            radioButtonA.setToggleGroup(select);
            radioButtonB.setToggleGroup(select);
            radioButtonC.setToggleGroup(select);
            radioButtonD.setToggleGroup(select);


            {//四个使用VBox的选项布局初始化
                double space = 13;
                a = new HBox(radioButtonA, labelA);
                b = new HBox(radioButtonB, labelB);
                c = new HBox(radioButtonC, labelC);
                d = new HBox(radioButtonD, labelD);

                a.setSpacing(space);
                b.setSpacing(space);
                c.setSpacing(space);
                d.setSpacing(space);
            }
            //题目HBOX的左边是题目标号，右边是题目的内容
            problem = new HBox(labelCount, content);
            problem.setSpacing(10);
            labelCount.setStyle("-fx-border-radius: 30px;-fx-background-radius: 30px");

            {//主布局加入组件
                mainVBox = new VBox();
                mainVBox.getChildren().add(problem);
                mainVBox.getChildren().add(a);
                mainVBox.getChildren().add(b);
                mainVBox.getChildren().add(c);
                mainVBox.getChildren().add(d);
                mainVBox.setSpacing(10);
            }


        }

        @Override
        protected void updateItem(NewSelectProblem newSelectProblem, boolean b) {
            super.updateItem(newSelectProblem, b);
            if (newSelectProblem != null && !b) {
                {//每一个item的内容都是不同的
                    labelCount.setText(String.valueOf(newSelectProblem.getId()));
                    content.setText(newSelectProblem.getProblem());
                    labelA.setText(newSelectProblem.getA());
                    labelB.setText(newSelectProblem.getB());
                    labelC.setText(newSelectProblem.getC());
                    labelD.setText(newSelectProblem.getD());

                    setGraphic(mainVBox);
                }


                {

                    radioButtonA.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {

                            newSelectProblem.setYourAnswer('A');
                        }
                    });

                    radioButtonB.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {

                            newSelectProblem.setYourAnswer('B');
                        }
                    });
                    radioButtonC.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {

                            newSelectProblem.setYourAnswer('C');

                            System.out.println(newSelectProblem.getId());
                        }
                    });

                    radioButtonD.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {

                            newSelectProblem.setYourAnswer('D');
                        }
                    });

                }


            } else {
                setGraphic(null);
            }

        }
    }

}