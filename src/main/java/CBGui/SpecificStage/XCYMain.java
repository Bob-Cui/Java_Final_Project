package main.java.CBGui.SpecificStage;

import DataManager.Data.BigTitle;
import DataManager.Data.Title;
import DataManager.JsonManager;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class XCYMain extends Stage {

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

        priListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                try {
                    LearnStage learnStage=new LearnStage();

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

//        priAccordion.setStyle("-fx-padding: 20px");
        midAccordion.getPanes().addAll(midTitlePane);

//        midAccordion.setStyle("-fx-padding: 20px");

        senAccordion.getPanes().addAll(senTitlePane);
//        senAccordion.setStyle("-fx-padding: 20px");
        leftTitles = new VBox(priAccordion, midAccordion, senAccordion);


        leftTitles.setMinWidth(400);
        leftTitles.setStyle("-fx-spacing: 50px;-fx-background-color: mediumspringgreen");


        Image image = new Image("file:Resource/JAVA.jpg", 250, 250.0, false, false);
        ImageView imageView = new ImageView(image);
//        mainGrid = new GridPane();

        Text text = new Text("fd");
        Text text1 = new Text("fd");
        Text text2 = new Text("fd");
        Text text3 = new Text("fd");
        Text text4 = new Text("fd");
        Text text5 = new Text("fd");

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


        HBox mainhBox = new HBox(leftTitles, mainGrid);
        // mainhBox.setStyle("-fx-background-color: red");


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        Scene scene = new Scene(mainhBox, dimension.width / 2, dimension.height / 2);

        this.setScene(scene);
    }

    /**
     * 设置listView的样式专用类
     */
    private class TitleCell extends ListCell<Title> {
        private Text name;
        private HBox mainHBox;
        private CheckBox finished;
//        private Checkbox

        
        
        public TitleCell() {
            super();
            name = new Text();
            name.setStyle("-fx-font-size: 20;-fx-font-family: '黑体';-fx-text-fill: blue");



            {//实现字体放大 变小的特效
                name.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {

                        //鼠标进入的特效
                        name.setStyle("-fx-font-family: '黑体';-fx-font-size: 21;");
                        name.setFill(Color.RED);
                    }
                });
                name.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        name.setStyle("-fx-font-size: 20;-fx-font-family: '黑体';");
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
