package main.java.CBGui.SpecificStage;


import DataManager.Data.BigTitleManager;
import DataManager.Data.TitleManager;
import DataManager.PreProcessing.JsonManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class XCYMain extends Stage {

    /**
     * Java介绍网页的相对地址
     */
    private final String INTROJAVAPATH = "Resource/Javainfor.html";


    private TreeItem<String> treeItem;

    //三个listView使用的
    private ObservableList<TitleManager> priTitle, midTitle, senTitle;
    private ListView<TitleManager> priListView, midListView, senListView;

    private VBox leftTitles, right;


    private FlowPane leftFlowPane, mainFlowPane;

    /**
     * 用来展示有关Java的介绍
     */
    private WebView introJavaWebView;

    private void initWebPage() throws MalformedURLException {
        introJavaWebView = new WebView();
        File file = new File(INTROJAVAPATH);
        URL url = file.toURI().toURL();
        introJavaWebView.getEngine().load(url.toString());


    }

    /**
     * 初始化用于展示三个级别的listView
     */
    private void initTitleListView() throws IOException {

//        BigTitle bigTitle = JsonManager.getTitleData();
        BigTitleManager bigTitleManager = JsonManager.getBigTitleManager();
        priTitle = FXCollections.observableArrayList();
        midTitle = FXCollections.observableArrayList();
        senTitle = FXCollections.observableArrayList();

        priTitle.addAll(bigTitleManager.getPriSubTitleManager().getLinkedListTitle());
        midTitle.addAll(bigTitleManager.getMidSubTitleManager().getLinkedListTitle());
        senTitle.addAll(bigTitleManager.getSenSubTitleManager().getLinkedListTitle());


//priTitle.
//        priTitle.addAll(bigTitle.getPrimaryTitleList());
//        midTitle.addAll(bigTitle.getMidTitleList());
//        senTitle.addAll(bigTitle.getSenTitleList());


        priListView = new ListView<>(priTitle);
        midListView = new ListView<>(midTitle);
        senListView = new ListView<>(senTitle);

        midListView.setDisable(true);


        /**
         *        设置样式
         */
        priListView.setCellFactory(new Callback<ListView<TitleManager>, ListCell<TitleManager>>() {
            @Override
            public ListCell<TitleManager> call(ListView<TitleManager> titleListView) {
                return new TitleCell();
            }
        });
        midListView.setCellFactory(new Callback<ListView<TitleManager>, ListCell<TitleManager>>() {
            @Override
            public ListCell<TitleManager> call(ListView<TitleManager> titleListView) {
                return new TitleCell();
            }
        });
        senListView.setCellFactory(new Callback<ListView<TitleManager>, ListCell<TitleManager>>() {
            @Override
            public ListCell<TitleManager> call(ListView<TitleManager> titleListView) {
                return new TitleCell();
            }
        });

        priListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                try {
                    LearnStage learnStage = new LearnStage();

                    learnStage.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
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
    }

    public XCYMain() throws IOException {

        setStageTitle();
        initTitleListView();
        initWebPage();
        //初级教程题目的标签
        Label labelJavaPri = new Label(" Java  ");
        Label labelPri = new Label("初级教程");
        labelJavaPri.setTextFill(Color.WHITE);
        labelPri.setTextFill(Color.WHITE);


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
        {
            priAccordion.getPanes().addAll(priTitledPane);
            priAccordion.setExpandedPane(priTitledPane);

            midAccordion.getPanes().addAll(midTitlePane);
            midAccordion.setExpandedPane(midTitlePane);

            senAccordion.getPanes().addAll(senTitlePane);
            senAccordion.setExpandedPane(senTitlePane);
        }


        leftTitles = new VBox(priAccordion, midAccordion, senAccordion);
        leftTitles.setStyle("-fx-spacing: 50px;-fx-background-color: mediumspringgreen");


        Image image = new Image("file:Resource/JAVA.jpg", 250, 250.0, false, false);
        ImageView imageView = new ImageView(image);

        Text text2 = new Text("fd");

        GridPane mainGrid = new GridPane();


        Button button = new Button();
        button.setText("查看我的学习进度");

        Button button1 = new Button();
        button.setText("查看我的得分");

        Button button2 = new Button();
        button2.setText("查看我的笔记");

        //VBox vBox = new VBox(button);

        mainGrid.add(text2, 1, 0);
        //  mainGrid.add(vBox, 1, 2);
        mainGrid.add(button, 0, 2);
        mainGrid.add(button1, 1, 2);
        mainGrid.add(button2, 2, 2);


        mainGrid.add(imageView, 1, 1);


        mainGrid.setHgap(30);
        mainGrid.setVgap(40);

        leftFlowPane = new FlowPane(priAccordion, midAccordion, senAccordion);

        //HBox mainhBox = new HBox(leftTitles, mainGrid);

        HBox hBox = new HBox(mainGrid, introJavaWebView);
//        mainFlowPane = new FlowPane(leftFlowPane, hBox);
        HBox main = new HBox(leftFlowPane, hBox);


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        introJavaWebView.setMinWidth(dimension.width / 2);
//        mainFlowPane.setMinHeight(dimension.height);
////        mainGrid.setBackground(Color);
//        mainFlowPane.setStyle("-fx-background-color: #4183C4");


        Scene scene = new Scene(main, 3 * dimension.width / 4, dimension.height);

        //主窗体的大小是不可以更改的
        //  this.setResizable(false);


        this.setScene(scene);
    }

    /**
     * 设置listView的样式专用类
     */
    private class TitleCell extends ListCell<TitleManager> {
        private Text name;
        private HBox mainHBox;
        private CheckBox finished;
//        private Checkbox


        public TitleCell() {
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
        protected void updateItem(TitleManager title, boolean b) {
            super.updateItem(title, b);
            if (title != null && !b) {
                name.setText(title.getName());


                setGraphic(mainHBox);

            } else {
                setGraphic(null);
            }

        }
    }
}
