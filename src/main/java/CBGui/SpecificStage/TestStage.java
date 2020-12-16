package main.java.CBGui.SpecificStage;

import DataManager.Data.NewProblems;
import DataManager.Data.NewSelectProblem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//import javax.swing.text.html.ListView;
import java.util.Map;

/**
 * 用于显示能够用来测试的界面
 * 这个界面可以复用
 */
public class TestStage extends Stage {
    private ListView<NewSelectProblem> mainListView;

    /**
     *
     * @param title
     * @param newProblems
     */
    public TestStage(String title, NewProblems newProblems) {
        VBox mainVBox = new VBox();
        Text text = new Text();
        ObservableList<NewSelectProblem>newSelectProblemObservableList=FXCollections.observableArrayList();
        for (Map.Entry<Integer, NewSelectProblem> integerNewSelectProblemEntry : newProblems.getIntegerNewSelectProblemHashMap().entrySet()) {
            newSelectProblemObservableList.add(integerNewSelectProblemEntry.getValue());
        }
        mainListView = new ListView<>(newSelectProblemObservableList);
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
                double space = 20;
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
            labelCount.setStyle("-fx-border-radius: 30px;-fx-background-radius: 30px");

            {//主布局加入组件
                mainVBox = new VBox();
                mainVBox.getChildren().add(problem);
                mainVBox.getChildren().add(a);
                mainVBox.getChildren().add(b);
                mainVBox.getChildren().add(c);
                mainVBox.getChildren().add(d);
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
                }


            } else {
                setGraphic(null);
            }

        }
    }

}
