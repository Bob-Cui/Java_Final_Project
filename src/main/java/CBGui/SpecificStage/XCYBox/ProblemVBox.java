package main.java.CBGui.SpecificStage.XCYBox;

import DataManager.Data.NewSelectProblem;
import DataManager.Data.NewTitleManager;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于问题展示和按钮控制
 * 展示一个问题
 * 并且用圆形的按钮切换每一个问题
 */
public class ProblemVBox extends VBox {
    /**
     *放置四个选项的管理器 只能选择一个选项
     */
    private ToggleGroup toggleGroup;

    //用来存放选项按钮和选项对应的内容的 text的HBox
    //四个单选框



    private HBox aHBox, bHBox, cHBox, dHBox;

    private RadioButton a;
    private RadioButton b;
    private RadioButton c;
    private RadioButton d;
    //每一个选项对应的内容
    private Label textA;
    private Label textB;
    private Label textC;
    private Label textD;

    private VBox problemVBox;
    private Label problemContent;


    private VBox selectvBox;
    private FlowPane changeProblem;

    private Button submit;

    private final static int step = 25;
    /**
     * private Map<int, SelectProblem>这个东西会报错
     */
//    private Map<Integer, SelectProblem> selectProblemMap;
    private Button proID;
    /**
     * 决定你现在正在做哪一道题
     */
    private int nowQuestion;
    private HashMap<Integer, Character> answer;


    private NewTitleManager dataSource;

    /**
     * 修改题目的内容
     *
     * @param content 要被修改成的内容
     */
    public void setProblemContent(String content) {

        problemContent.setText(content);

    }


    /**
     * 实际运行需要调用的构造函数的
     *
     * @param newTitleManager
     */
    public ProblemVBox(NewTitleManager newTitleManager) {

/**
 *初始化属于这个页面的数据来源
 * 把titleManager变成这个类的成员，可以随便访问
 */
        dataSource = newTitleManager;


        /**
         * 默认正在回答第一题
         */
        {
            nowQuestion = 1;
        }

        {
            problemContent = new Label();
            problemContent.setText(dataSource.getIntegerSelectProblemHashMap().get(1).getProblem());
            problemContent.setWrapText(true);//换行
            problemContent.setStyle("-fx-font-size: 25px");
        }


        {
            proID = new Button();
            proID.setText("1");
            proID.setStyle("-fx-background-radius: 25px;-fx-border-radius: 25px;-fx-font-size: 18px");
            // proID.setDisable(true);
            problemVBox = new VBox(proID, problemContent);
            problemVBox.setStyle("-fx-spacing: 15px");
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
                    NewSelectProblem newSelectProblem = dataSource.getIntegerSelectProblemHashMap().get(nowQuestion);
                    newSelectProblem.setYourAnswer('A');
                }
            });
            b.setText("B");
            b.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    NewSelectProblem newSelectProblem = dataSource.getIntegerSelectProblemHashMap().get(nowQuestion);
                    newSelectProblem.setYourAnswer('B');

                }
            });

            c.setText("C");

            c.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    NewSelectProblem newSelectProblem = dataSource.getIntegerSelectProblemHashMap().get(nowQuestion);
                    newSelectProblem.setYourAnswer('C');
                }
            });

            d.setText("D");
            d.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    NewSelectProblem newSelectProblem = dataSource.getIntegerSelectProblemHashMap().get(nowQuestion);
                    newSelectProblem.setYourAnswer('D');
                }
            });
            {
                textA = new Label(dataSource.getIntegerSelectProblemHashMap().get(1).getA());
                textB = new Label(dataSource.getIntegerSelectProblemHashMap().get(1).getB());
                textC = new Label(dataSource.getIntegerSelectProblemHashMap().get(1).getC());
                textD = new Label(dataSource.getIntegerSelectProblemHashMap().get(1).getD());
                textA.setWrapText(true);
                textB.setWrapText(true);
                textC.setWrapText(true);
                textD.setWrapText(true);
            }


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

        selectvBox.setSpacing(5);




        selectvBox.setStyle("-fx-spacing: 20px;-fx-border-width: 5px;-fx-border-color: hotpink;-fx-border-radius: 10px");

        a.setToggleGroup(toggleGroup);
        b.setToggleGroup(toggleGroup);
        c.setToggleGroup(toggleGroup);
        d.setToggleGroup(toggleGroup);
        changeProblem = new FlowPane();

        /**
         * 加上按钮
         */
        for (Map.Entry<Integer, NewSelectProblem> item : dataSource.getIntegerSelectProblemHashMap().entrySet()) {
            NewSelectProblem newSelectProblem = item.getValue();
            Button button = new Button();
            button.setText(String.valueOf(newSelectProblem.getId()));

            button.setMinHeight(30);
            button.setMinWidth(30);



            button.setUserData(newSelectProblem.getId());




            button.setStyle("-fx-background-radius: 25px;-fx-border-radius: 25px;-fx-border-width: 2px;-fx-border-color: lightpink;-fx-font-size: 12px;-fx-font-weight: bold;fx-text-fill: hotpink");

            button.setOnMouseClicked(mouseEvent -> {
/**
 * 换题 点击后得到按钮的id然后进行切换
 */
                int id = (int) button.getUserData();
                proID.setText(String.valueOf(id));

                NewSelectProblem choosedOne = dataSource.getIntegerSelectProblemHashMap().get(id);
                problemContent.setText(choosedOne.getProblem());
                //  System.out.println(choosedOne.getProblem());
                textA.setText(choosedOne.getA());
                textB.setText(choosedOne.getB());
                textC.setText(choosedOne.getC());
                textD.setText(choosedOne.getD());


                /**
                 * 对新打开的题目进行初始化，否则选择选项后之后的每一道题都会被选择该选项
                 */
                a.setSelected(false);
                b.setSelected(false);
                c.setSelected(false);
                d.setSelected(false);
            });
            changeProblem.getChildren().add(button);

        }

        changeProblem.setHgap(12);
        changeProblem.setVgap(5);

        changeProblem.setStyle("-fx-border-width: 5px;-fx-border-color: hotpink;-fx-border-radius: 20px");
        initSubmitButton();
        VBox vBox = new VBox();

        vBox.getChildren().addAll(problemVBox, selectvBox);

        vBox.setSpacing(15);


        this.getChildren().addAll(vBox, changeProblem, submit);

        
        
        
        this.setMaxWidth(500);
        this.setStyle("-fx-spacing: 60px;-fx-padding: 15px;");
        
        
        
    }

    /**
     * 初始化submit按钮以及相关的点击动作
     */
    private void initSubmitButton() {


        submit = new Button();
        submit.setText("提交答案");

        submit.setStyle("-fx-text-fill: coral;-fx-font-size: 20px;-fx-font-weight: bold");


        Image image = new Image("file:src/Source/mlcq.jpg", 35, 35, true, true);
        submit.setGraphic(new ImageView(image));


        submit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //没有通过测试被视为没有完成学习任务
                int count = 0;
                int total = dataSource.getIntegerSelectProblemHashMap().size();

                for (Map.Entry<Integer, NewSelectProblem> item : dataSource.getIntegerSelectProblemHashMap().entrySet()) {
                    if (item.getValue().getYourAnswer() != item.getValue().getAnswer()) {
                        count++;
                    }
                }
                if (count > total/2) {


                    Alert fail = new Alert(Alert.AlertType.WARNING);
                    fail.setTitle("未通过");
                    fail.setHeaderText("错误过多");
                    fail.setContentText("你有超过一半的题目没有做对，请重新参与学习");
                    fail.showAndWait();

                    dataSource.setLearned(false);

                } else {

                    Alert success = new Alert(Alert.AlertType.INFORMATION);
                    success.setTitle("通过");
                    success.setHeaderText("通过测试");
                    success.setContentText("请参与下一章的学习");
                    success.showAndWait();
                    dataSource.setLearned(true);
                    dataSource.setDate(new Date());//设置一个时间


                }
            }
        });
    }


//    public ProblemVBox() {
//        problemContent = new Label();
//        problemContent.setText("这是一个问题");
//        problemContent.setStyle("-fx-font-size: 25px");
//
//
//        //设计关于题目的内容的content
//        {
//            Button button = new Button();
//            button.setText("1");
//            button.setStyle("-fx-background-radius: 25px;-fx-border-radius: 25px;-fx-font-size: 20px");
//            button.setDisable(true);
//            problemVBox = new VBox(button, problemContent);
//            problemVBox.setStyle("-fx-spacing: 15px");
//        }
//
//
//        {
//            toggleGroup = new ToggleGroup();
//
//
//            a = new RadioButton();
//            b = new RadioButton();
//            c = new RadioButton();
//            d = new RadioButton();
//
//
//            a.setText("A");
//
//            a.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent mouseEvent) {
//                    System.out.println(toggleGroup.getSelectedToggle().getUserData().toString());
//
//
//                }
//            });
//            b.setText("B");
//            b.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent mouseEvent) {
//
//                    System.out.println(toggleGroup.getSelectedToggle().getUserData().toString());
//
//                }
//            });
//
//            c.setText("C");
//            c.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent mouseEvent) {
//                    System.out.println(toggleGroup.getSelectedToggle().getUserData().toString());
//
//                }
//            });
//
//            d.setText("D");
//            d.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent mouseEvent) {
//                    System.out.println(toggleGroup.getSelectedToggle().getUserData().toString());
//
//                }
//            });
//            textA = new Text("选项dsfdsaf dsafsda fsdaf das f\nA");
//            textB = new Text("sad");
//            textC = new Text("选项C");
//            textD = new Text("选项D");
//
//
//            a.setStyle("-fx-font-size: 20px");
//            b.setStyle("-fx-font-size: 20px");
//            c.setStyle("-fx-font-size: 20px");
//            d.setStyle("-fx-font-size: 20px");
//
//
//            textA.setStyle("-fx-font-size: 18px;");
//            textB.setStyle("-fx-font-size: 18px;");
//            textC.setStyle("-fx-font-size: 18px;");
//            textD.setStyle("-fx-font-size: 18px;");
//
//            //构建四个水平盒子 左边是选项 右边是选项的内容
//            aHBox = new HBox(a, textA);
//            bHBox = new HBox(b, textB);
//            cHBox = new HBox(c, textC);
//            dHBox = new HBox(d, textD);
//
//
//            //设置单选按钮和选项内容的间隔
//            aHBox.setStyle("-fx-spacing: 25px");
//            bHBox.setStyle("-fx-spacing: 25px");
//            cHBox.setStyle("-fx-spacing: 25px");
//            dHBox.setStyle("-fx-spacing: 25px");
//        }
//
//
//}

}
