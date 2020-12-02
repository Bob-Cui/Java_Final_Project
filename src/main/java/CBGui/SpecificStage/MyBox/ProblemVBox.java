package main.java.CBGui.SpecificStage.MyBox;

import DataManager.Data.SelectProblem;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Map;

public class ProblemVBox extends VBox {


    private ToggleGroup toggleGroup;

    //用来存放选项按钮和选项对应的内容的 text的HBox
    //四个单选框


    private HBox aHBox, bHBox, cHBox, dHBox;

    private final RadioButton a;
    private final RadioButton b;
    private final RadioButton c;
    private final RadioButton d;
    //每一个选项对应的内容
    private final Text textA;
    private final Text textB;
    private final Text textC;
    private final Text textD;

    private HBox problemHBox;
    private final Text problemContent;


    private VBox selectvBox;
    private FlowPane changeProblem;

    //   private Map<int, SelectProblem>这个东西会报错
    private Map<Integer, SelectProblem> selectProblemMap;


    /**
     * 修改题目的内容
     *
     * @param content 要被修改成的内容
     */
    public void setProblemContent(String content) {

        problemContent.setText(content);

    }

    /**
     * 修改四个选项的内容
     *
     * @param A
     * @param B
     * @param C
     * @param D
     */
    public void setSelectItemText(String A, String B, String C, String D) {


    }


    public ProblemVBox() {
        problemContent = new Text();
        problemContent.setText("这是一个问题");
        problemContent.setStyle("-fx-font-size: 25px");


        //设计关于题目的内容的content
        {
            Button button = new Button();
            button.setText("1");
            button.setStyle("-fx-background-radius: 25px;-fx-border-radius: 25px;-fx-font-size: 20px");
            button.setDisable(true);
            problemHBox = new HBox(button, problemContent);
            problemHBox.setStyle("-fx-spacing: 15px");
        }


        {
            toggleGroup = new ToggleGroup();


            a = new RadioButton();
            b = new RadioButton();
            c = new RadioButton();
            d = new RadioButton();


            a.setText("A");

            a.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println(toggleGroup.getSelectedToggle().getUserData().toString());


                }
            });
            b.setText("B");
            b.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    System.out.println(toggleGroup.getSelectedToggle().getUserData().toString());

                }
            });

            c.setText("C");
            c.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println(toggleGroup.getSelectedToggle().getUserData().toString());

                }
            });

            d.setText("D");
            d.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println(toggleGroup.getSelectedToggle().getUserData().toString());

                }
            });
            textA = new Text("选项dsfdsaf dsafsda fsdaf das f\nA");
            textB = new Text("sad");
            textC = new Text("选项C");
            textD = new Text("选项D");


            a.setStyle("-fx-font-size: 20px");
            b.setStyle("-fx-font-size: 20px");
            c.setStyle("-fx-font-size: 20px");
            d.setStyle("-fx-font-size: 20px");


            textA.setStyle("-fx-font-size: 18px;");
            textB.setStyle("-fx-font-size: 18px;");
            textC.setStyle("-fx-font-size: 18px;");
            textD.setStyle("-fx-font-size: 18px;");

            //构建四个水平盒子 左边是选项 右边是选项的内容
            aHBox = new HBox(a, textA);
            bHBox = new HBox(b, textB);
            cHBox = new HBox(c, textC);
            dHBox = new HBox(d, textD);


            //设置单选按钮和选项内容的间隔
            aHBox.setStyle("-fx-spacing: 25px");
            bHBox.setStyle("-fx-spacing: 25px");
            cHBox.setStyle("-fx-spacing: 25px");
            dHBox.setStyle("-fx-spacing: 25px");
        }

        selectvBox = new VBox(aHBox, bHBox, cHBox, dHBox);
        selectvBox.setStyle("-fx-spacing: 20px");

        a.setToggleGroup(toggleGroup);
        b.setToggleGroup(toggleGroup);
        c.setToggleGroup(toggleGroup);
        d.setToggleGroup(toggleGroup);


        changeProblem = new FlowPane();

        for (int i = 0; i < 20; i++) {
            Button button = new Button();
            button.setText(String.valueOf(i));
            button.setMinHeight(35);
            button.setMinWidth(35);
            button.setUserData(String.valueOf(i));
            button.setStyle("-fx-background-radius: 30px;-fx-border-radius: 30px;");

            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    problemContent.setText(button.getUserData().toString());
//                    if(toggleGroup.getSelectedToggle()!=null)
                    a.setUserData("第" + button.getUserData().toString() + "题 A");
                    b.setUserData("第" + button.getUserData().toString() + "题 B");
                    c.setUserData("第" + button.getUserData().toString() + "题 C");
                    d.setUserData("第" + button.getUserData().toString() + "题 D");
                    a.setUserData(2);
                }
            });
            changeProblem.getChildren().add(button);


        }


        this.getChildren().addAll(problemHBox, selectvBox, changeProblem);


        this.setStyle("-fx-spacing: 60px;-fx-padding: 15px");
        /**
         * Spacing 定义Box中不同元素的间隔
         * Padding（填充）属性定义元素边框与元素内容之间的空间。padding 简写属性在一个声明中设置所有内边距属性。
         */

    }
}
