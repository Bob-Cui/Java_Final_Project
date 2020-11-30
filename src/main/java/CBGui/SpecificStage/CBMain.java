package main.java.CBGui.SpecificStage;

import DataManager.Data.BigTitle;
import DataManager.Data.Title;
import DataManager.JsonManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class CBMain extends Stage {

    /**
     *
     */
    public static void main(String[] args) throws IOException {
        BigTitle bigTitle = JsonManager.getTitleData();
        for (Title title : bigTitle.getPrimaryTitleList()) {
            System.out.println(title.getName());
        }

    }

    private TreeItem<String> treeItem;

    //三个listView使用的
    private ObservableList<Title> priTitle, midTitle, senTitle;
    private ListView<Title> priListView, midListView, senListView;

    private VBox leftTitles, right;
    //容纳左侧列表的VBox

    private GridPane mainGrid;


    /**
     * 初始化用于展示三个级别的listView
     */
    private void initTitleListView() throws IOException {

        BigTitle bigTitle = JsonManager.getTitleData();

        priTitle = FXCollections.observableArrayList();
        midTitle = FXCollections.observableArrayList();
        senTitle = FXCollections.observableArrayList();

//priTitle.
        priTitle.addAll(bigTitle.getPrimaryTitleList());
        midTitle.addAll(bigTitle.getMidTitleList());
        senTitle.addAll(bigTitle.getSenTitleList());


        priListView = new ListView<>(priTitle);
        midListView = new ListView<>(midTitle);
        senListView = new ListView<>(senTitle);

        /**
         *        设置样式
         */
        priListView.setCellFactory(new Callback<ListView<Title>, ListCell<Title>>() {
            @Override
            public ListCell<Title> call(ListView<Title> titleListView) {
                return new TitleCell();
            }
        });
        midListView.setCellFactory(new Callback<ListView<Title>, ListCell<Title>>() {
            @Override
            public ListCell<Title> call(ListView<Title> titleListView) {
                return new TitleCell();
            }
        });
        senListView.setCellFactory(new Callback<ListView<Title>, ListCell<Title>>() {
            @Override
            public ListCell<Title> call(ListView<Title> titleListView) {
                return new TitleCell();
            }
        });

        midListView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {


                System.out.println(midListView.getSelectionModel().getSelectedIndex());

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

    public CBMain() throws IOException {

        setStageTitle();
        initTitleListView();
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


        priAccordion.getPanes().addAll(priTitledPane);
        midAccordion.getPanes().addAll(midTitlePane);
        senAccordion.getPanes().addAll(senTitlePane);
        leftTitles = new VBox(priAccordion, midAccordion, senAccordion);
        leftTitles.setMinWidth(350);
        leftTitles.setStyle("-fx-background-color: mediumspringgreen");

        Image image = new Image("file:Resource/slcj.png", 300, 300.0, false, false);
        ImageView imageView = new ImageView(image);
        mainGrid = new GridPane();

        Text text = new Text("fd");
        Text text1 = new Text("fd");
        Text text2 = new Text("fd");
        Text text3 = new Text("fd");
        Text text4 = new Text("fd");
        Text text5 = new Text("fd");
        mainGrid.add(imageView, 2, 2);

        mainGrid.add(text, 1, 1);
        mainGrid.add(text2, 3, 3);


        mainGrid.setStyle("-fx-background-color: blue");
        mainGrid.setScaleShape(true);
        HBox mainhBox = new HBox(leftTitles, mainGrid);
        // mainhBox.setStyle("-fx-background-color: red");

        Scene scene = new Scene(mainhBox, 1000, 500);

        this.setScene(scene);
    }

    /**
     * 设置listView的样式专用类
     */
    private class TitleCell extends ListCell<Title> {
        private Text name;
        private HBox mainHBox;
        private CheckBox finished;


        public TitleCell() {
            super();
            name = new Text();
            name.setFont(new Font("黑体", 20));

            {//实现字体放大 变小的特效
                name.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {

//鼠标进入的特效
                        name.setFont(new Font("黑体", 25));

                    }
                });
                name.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        name.setFont(new Font("黑体", 20));

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
        protected void updateItem(Title title, boolean b) {
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
