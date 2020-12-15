package main.java.CBGui.SpecificStage;


import DataManager.Data.*;
import DataManager.DataProcess.JsonManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

public class XCYMain extends Stage {

    /**
     * 注意这个地方计算的是毫秒数，所以还要乘上1000
     */
    private static final int DAY = 24 * 60 * 60 * 1000;
    /**
     * Java介绍网页的相对地址
     */
    private static final String INTROJAVAPATH = "Resource/Javainfor.html";
    private static final String PRIMARY = "Java初级教程", MIDDLE = "Java中级教程", SENIOR = "Java高级教程";


    private TreeItem<String> treeItem;

    //三个listView使用的
    private ObservableList<NewTitleManager> priTitle, midTitle, senTitle;
    private ListView<NewTitleManager> priListView, midListView, senListView;

    private VBox leftTitles, right;


    private FlowPane leftFlowPane, mainFlowPane;

    /**
     * 所有数据的来源
     * 我们将这个变量变成静态变量其目的就是为了能在不同的类中自由的访问这个变量，并进行数据的修改
     */
    public static NewBigTitleManager newBigTitleManager;

    /**
     * 用来展示有关Java的介绍
     */
    private WebView introJavaWebView;


    /**
     * 有关三个考试的按钮
     */
    private Button priTest, midTest, senTest;


    /**
     * 有趣的关于查看学习进度的按钮
     * 实际上这并不是一个严格意义上的按钮而是用两个圆叠加形成的效果
     */
    private Group checkProgress;
    private Circle checkProgressCircleButtom, checkProgressCircleUp;
    /**
     *
     */
    private Group remainYouLearn;
    private Circle remainYouCircleButtom, remainYouCircleUp;


    /**
     * 初始化所有的数据来源
     */
    static {
        try {
            newBigTitleManager = JsonManager.getNewBigTitleManager();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 目前还没有什么用
     *
     * @throws MalformedURLException
     */
    private void initWebPage() throws MalformedURLException {
        introJavaWebView = new WebView();
        File file = new File(INTROJAVAPATH);
        URL url = file.toURI().toURL();
        introJavaWebView.getEngine().load(url.toString());


    }


    /**
     *
     */


    /**
     * 初始化用于展示三个级别的listView
     */
    private void initTitleListView() throws IOException {


        // newBigTitleManager = JsonManager.getNewBigTitleManager();
        priTitle = FXCollections.observableArrayList();
        midTitle = FXCollections.observableArrayList();
        senTitle = FXCollections.observableArrayList();


        for (Map.Entry<Integer, NewTitleManager> integerNewTitleManagerEntry : newBigTitleManager.getStringNewSubTitleManagerHashMap().get("Java初级教程").getIntegerNewTitleManagerTreeMap().entrySet()) {
            priTitle.add(integerNewTitleManagerEntry.getValue());
            System.out.println(integerNewTitleManagerEntry.getValue().getName());
        }

        for (Map.Entry<Integer, NewTitleManager> integerNewTitleManagerEntry : newBigTitleManager.getStringNewSubTitleManagerHashMap().get("Java中级教程").getIntegerNewTitleManagerTreeMap().entrySet()) {
            midTitle.add(integerNewTitleManagerEntry.getValue());
        }
        for (Map.Entry<Integer, NewTitleManager> integerNewTitleManagerEntry : newBigTitleManager.getStringNewSubTitleManagerHashMap().get("Java高级教程").getIntegerNewTitleManagerTreeMap().entrySet()) {
            senTitle.add(integerNewTitleManagerEntry.getValue());
        }


        priListView = new ListView<>(priTitle);
        midListView = new ListView<>(midTitle);
        senListView = new ListView<>(senTitle);

//        midListView.setDisable(true);


        /**
         *        设置样式
         */
        priListView.setCellFactory(new Callback<ListView<NewTitleManager>, ListCell<NewTitleManager>>() {
            @Override
            public ListCell<NewTitleManager> call(ListView<NewTitleManager> newTitleManagerListView) {
                return new NewTitleCell();
            }
        });

        midListView.setCellFactory(new Callback<ListView<NewTitleManager>, ListCell<NewTitleManager>>() {
            @Override
            public ListCell<NewTitleManager> call(ListView<NewTitleManager> newTitleManagerListView) {
                return new NewTitleCell();
            }
        });
        senListView.setCellFactory(new Callback<ListView<NewTitleManager>, ListCell<NewTitleManager>>() {
            @Override
            public ListCell<NewTitleManager> call(ListView<NewTitleManager> newTitleManagerListView) {
                return new NewTitleCell();
            }
        });
//
        priListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            //@SneakyThrows
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                if (newBigTitleManager.getStringNewSubTitleManagerHashMap().get("Java初级教程").isAbleToLearn()) {
                    try {


                        NewTitleManager newTitleManager = priListView.getItems().get(t1.intValue());


                        LearnStage learnStage = new LearnStage(newTitleManager);
                        learnStage.showAndWait();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {

                    Alert fail = new Alert(Alert.AlertType.WARNING);
                    fail.setTitle("没有权限");
                    fail.setHeaderText("请学习之前的章节");
                    fail.setContentText("你没有完成之前章节的学习,不能学习这一章");
                    fail.showAndWait();
                }
            }
        });
        midListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                if (newBigTitleManager.getStringNewSubTitleManagerHashMap().get("Java中级教程").isAbleToLearn()) {
                    try {


                        NewTitleManager newTitleManager = priListView.getItems().get(t1.intValue());


                        LearnStage learnStage = new LearnStage(newTitleManager);
                        learnStage.showAndWait();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {

                    Alert fail = new Alert(Alert.AlertType.WARNING);
                    fail.setTitle("没有权限");
                    fail.setHeaderText("请学习之前的章节");
                    fail.setContentText("你没有完成之前章节的学习,不能学习这一章");
                    fail.showAndWait();
                }
            }
        });

        senListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (newBigTitleManager.getStringNewSubTitleManagerHashMap().get("Java高级教程").isAbleToLearn()) {
                    try {


                        NewTitleManager newTitleManager = priListView.getItems().get(t1.intValue());


                        LearnStage learnStage = new LearnStage(newTitleManager);
                        learnStage.showAndWait();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert fail = new Alert(Alert.AlertType.WARNING);
                    fail.setTitle("没有权限");
                    fail.setHeaderText("请学习之前的章节");
                    fail.setContentText("你没有完成之前章节的学习,不能学习这一章");
                    fail.showAndWait();
                }
            }
        });
    }

    /**
     * 修改窗体的图标
     */
    private void setStageTitle() {
        this.setTitle("谢哈哈的Java学习网站");
        this.getIcons().add(new Image("file:Resource/icon.jpg"));
        ImageView imageView = new ImageView(new Image("file:Resource/icon.jpg"));
    }

    public XCYMain() throws IOException {
        //提醒学习


        closeAndWrite();
        setStageTitle();
        initTitleListView();
        initWebPage();
        //初级教程题目的标签
        Label labelJavaPri = new Label(" Java  ");
        Label labelPri = new Label("初级教程");
        labelJavaPri.setTextFill(Color.WHITE);
        labelPri.setTextFill(Color.WHITE);


        reviewTheLearner();

        labelJavaPri.setStyle("-fx-font-size: 30px;-fx-font-family: '黑体';-fx-font-weight: bolder");
        labelPri.setStyle("-fx-font-size: 30px;-fx-font-family: '黑体';-fx-font-weight: bolder");
        HBox hBoxPri = new HBox(labelJavaPri, labelPri);
        hBoxPri.setStyle("-fx-background-color: darkolivegreen");
        //


        //中级教程题目的标签
        Label labelJavaMid = new Label(" Java  ");
        Label labelMid = new Label("中级教程");

        labelJavaMid.setTextFill(Color.WHITE);
        labelMid.setTextFill(Color.WHITE);
        labelJavaMid.setStyle("-fx-font-size: 30px;-fx-font-family: '黑体';-fx-font-weight: bolder");
        labelMid.setStyle("-fx-font-size: 30px;-fx-font-family: '黑体';-fx-font-weight: bolder");
        HBox hBoxMid = new HBox(labelJavaMid, labelMid);
        hBoxMid.setStyle("-fx-background-color: darkolivegreen");
        //


        //高级教程题目的标签
        Label labelJavaSen = new Label(" Java  ");
        Label labelSen = new Label("高级教程");

        labelJavaSen.setTextFill(Color.WHITE);
        labelSen.setTextFill(Color.WHITE);

        labelJavaSen.setStyle("-fx-font-size: 30px;-fx-font-family: '黑体';-fx-font-weight: bolder");
        labelSen.setStyle("-fx-font-size: 30px;-fx-font-family: '黑体';-fx-font-weight: bolder");
        HBox hBoxSen = new HBox(labelJavaSen, labelSen);

        hBoxSen.setStyle("-fx-background-color: darkolivegreen");
        //


        //手风琴布局尝试
        TitledPane priTitledPane = new TitledPane("Java  初级教程", priListView);
        priTitledPane.setStyle("-fx-font-size: 18px;-fx-font-weight: bolder;-fx-text-fill: blueviolet");

        TitledPane midTitlePane = new TitledPane("Java   中级教程", midListView);
        midTitlePane.setStyle("-fx-font-size: 18px;-fx-font-weight: bolder;-fx-text-fill: blueviolet");

        TitledPane senTitlePane = new TitledPane("Java   高级教程", senListView);
        senTitlePane.setStyle("-fx-font-size: 18px;-fx-font-weight: bolder;-fx-text-fill: blueviolet");


        Accordion priAccordion = new Accordion();
        Accordion midAccordion = new Accordion();
        Accordion senAccordion = new Accordion();


        /**
         *设置手风琴布局的样式
         */

        priAccordion.getPanes().addAll(priTitledPane);
        priAccordion.setExpandedPane(priTitledPane);

        midAccordion.getPanes().addAll(midTitlePane);
//        midAccordion.setExpandedPane(midTitlePane);

        senAccordion.getPanes().addAll(senTitlePane);
//        senAccordion.setExpandedPane(senTitlePane);


        {
            priTest = new Button();
            priTest.setText("初级考核测试");
            priTest.setStyle("-fx-font-size: 15px");

            midTest = new Button();
            midTest.setText("中级考核测试");
            midTest.setStyle("-fx-font-size: 15px");

            senTest = new Button();
            senTest.setText("高级考核测试");
            senTest.setStyle("-fx-font-size: 15px");
        }
        leftTitles = new VBox(priAccordion, priTest, midAccordion, midTest, senAccordion, senTest);
        leftTitles.setStyle("-fx-spacing: 5px;-fx-background-color: mediumspringgreen");


        Image image = new Image("file:Resource/JAVA.jpg", 250, 250.0, false, false);
        ImageView imageView = new ImageView(image);
//        imageView.setStyle("-fx-border-radius: 40px;-fx-background-radius:40px");


        Text text2 = new Text("fd");

        GridPane mainGrid = new GridPane();


        Button button = new Button();
        button.setText("更新我的学习进度");
        button.setStyle("-fx-font-size: 30px");

        Button button1 = new Button();
        //  button.setText("查看我的得分");

        Button button2 = new Button();
        button2.setText("查看我的笔记");

        //加一个环形按钮，关于检查进度
        {

            checkProgress = new Group();
            checkProgressCircleButtom = new Circle();
            checkProgressCircleButtom.setRadius(28);
            checkProgressCircleButtom.setFill(Color.CORAL);

            checkProgressCircleUp = new Circle();
            checkProgressCircleUp.setRadius(25);
            // checkProgressCircleUp.setFill(Color.BLUEVIOLET);
            Text text = new Text();
            text.setText("更新进度");
            text.setStyle("-fx-font-size: 15;");

            //checkProgressCircleUp.setStyle("-fx-background-image:url('file:Resource/icon.jpg') ");
            checkProgressCircleUp.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    checkProgressCircleUp.setFill(Color.WHITE);
                }
            });

            checkProgressCircleUp.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    checkProgressCircleUp.setFill(Color.BLUEVIOLET);

                }
            });
            checkProgressCircleUp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    checkProgress();
                }
            });

            text.setX(-45);
            text.setY(2);
            checkProgress.getChildren().add(checkProgressCircleButtom);
            checkProgress.getChildren().add(checkProgressCircleUp);
            //  checkProgress.getChildren().add(new ImageView(new Image("file:Resource/icon.jpg")));
            checkProgress.getChildren().add(text);
        }
        //再加一个圆形按钮，用于提醒这个人学习
        {


        }

        mainGrid.add(text2, 1, 0);
        mainGrid.add(checkProgress, 1, 2);
        mainGrid.add(button2, 2, 2);


        mainGrid.add(imageView, 1, 1);


        mainGrid.setHgap(30);
        mainGrid.setVgap(40);


        //HBox mainhBox = new HBox(leftTitles, mainGrid);

        HBox hBox = new HBox(mainGrid);
//        mainFlowPane = new FlowPane(leftFlowPane, hBox);
        HBox main = new HBox(leftTitles, hBox);


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        introJavaWebView.setMinWidth(dimension.width / 2);


        main.setStyle("-fx-background-color: cadetblue");
        Scene scene = new Scene(main, dimension.width / 2, dimension.height);

        //主窗体的大小是不可以更改的
        //  this.setResizable(false);


        this.setScene(scene);
    }


    /**
     * 设置新的listView的样式专用类
     */

    private class NewTitleCell extends ListCell<NewTitleManager> {
        private Text name;
        private HBox mainHBox;
        private CheckBox finished;

        //        private Checkbox
        public NewTitleCell() {
            super();
            name = new Text();
            name.setStyle("-fx-font-size: 18;-fx-font-family: '黑体';-fx-text-fill: blue");


            {//实现字体放大 变小的特效
                name.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {

                        //鼠标进入的特效
                        name.setStyle("-fx-font-family: '黑体';-fx-font-size: 20;");
                        name.setFill(Color.RED);
                    }
                });
                name.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        name.setStyle("-fx-font-size: 18;-fx-font-family: '黑体';");
                        name.setFill(Color.BLACK);
                    }
                });
            }

            finished = new CheckBox();
            finished.setStyle("-fx-background-color:red");//这个红色体现不出来
            finished.setText("已完成");


            finished.setSelected(true);
            finished.setStyle("-fx-font-size: 15;-fx-text-fill: blue");


            finished.setDisable(true);


            mainHBox = new HBox(name, finished);

        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }

        @Override
        protected void updateItem(NewTitleManager newTitleManager, boolean b) {
            super.updateItem(newTitleManager, b);
            if (newTitleManager != null && !b) {

                if (newTitleManager.isLearned()) {
                    finished.setSelected(true);
                } else {
                    finished.setSelected(false);
                }
                name.setText(newTitleManager.getName());
                setGraphic(mainHBox);
            } else {
                setGraphic(null);
            }
        }
    }


    /**
     * 更新我目前学习进度
     */
    public static void checkProgress() {


        boolean priFinished = checkFinishedTitle(PRIMARY);
        boolean midFinished = checkFinishedTitle(MIDDLE);
        boolean senFinished = checkFinishedTitle(SENIOR);

//        if (checkFinishedTitle(PRIMARY) && checkFinishedTitle(MIDDLE))

        if (priFinished && midFinished) {
            newBigTitleManager.getStringNewSubTitleManagerHashMap().get(SENIOR).setAbleToLearn(true);
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("进度更新");
            success.setHeaderText("解锁新的权限");
            success.setContentText("你可以学习Java高级教程了");
            success.showAndWait();


        } else if (priFinished) {
            newBigTitleManager.getStringNewSubTitleManagerHashMap().get(MIDDLE).setAbleToLearn(true);
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("进度更新");
            success.setHeaderText("解锁新的权限");
            success.setContentText("你可以学习Java中级教程了");
            success.showAndWait();
        } else {

            Alert fail = new Alert(Alert.AlertType.INFORMATION);
            fail.setTitle("没有进展");

            String unFininshTitle = null;

            if (!priFinished) {
                unFininshTitle = "Java初级教程";
            } else if (!midFinished) {
                unFininshTitle = "Java中级教程";
            }
            fail.setHeaderText("未能解锁新的权限");
            fail.setContentText("请继续认真学习" + unFininshTitle + "内的其他章节");
            fail.showAndWait();
        }
    }

    /**
     * 检查是否有需要复习的章节
     */
    private int reviewTheLearner() {
        boolean flag = false;

        LinkedList<NewTitleManager> remainList = new LinkedList<>();


        for (Map.Entry<String, NewSubTitleManager> stringNewSubTitleManagerEntry : newBigTitleManager.getStringNewSubTitleManagerHashMap().entrySet()) {
            if (!stringNewSubTitleManagerEntry.getValue().isAbleToLearn()) {
                continue;
            }
            for (Map.Entry<String, NewTitleManager> stringNewTitleManagerEntry : stringNewSubTitleManagerEntry.getValue().getStringNewTitleManagerTreeMap().entrySet()) {

                /**
                 * 如果这个人没有学的话是不需要提醒的
                 */

                if (!stringNewTitleManagerEntry.getValue().isLearned()) {
                    continue;
                }
                Date now = new Date();
                long span = now.getTime() - stringNewTitleManagerEntry.getValue().getDate().getTime();
//                System.out.println(c/DAY);
//if()


            }
        }
        /**
         * 经过遍历之后仍然是负值
         */
        if (!flag) {
            Alert nothing = new Alert(Alert.AlertType.INFORMATION);
            nothing.setTitle("无需复习");
            nothing.setHeaderText("");
            nothing.setContentText("请开始进一步的学习");
            nothing.showAndWait();
            return 0;
        }
        return 0;
    }

    /**
     * 关闭的时候将内容写入配置文件中
     */
    private void closeAndWrite() {
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                if (windowEvent.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
                    //               System.out.println("窗口关闭了");
/**
 * 这里需要有一个函数将我们对NewBigTitleManager的修改写回到配置文件里，这一点很重要
 */
                }
            }
        });
    }

    /**
     * @param name 检查这个章节的内容是否学完了
     * @return
     */
    public static boolean checkFinishedTitle(String name) {
        for (Map.Entry<Integer, NewTitleManager> integerNewTitleManagerEntry : newBigTitleManager.getStringNewSubTitleManagerHashMap().get(name).getIntegerNewTitleManagerTreeMap().entrySet()) {
            if (!integerNewTitleManagerEntry.getValue().isLearned())
                return false;
        }
        return true;
    }


}
