package main.java.CBGui.SpecificStage;

import DataManager.Data.BigTitle;
import DataManager.Data.Title;
import DataManager.JsonManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
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
    private ObservableList<Title> priTitle, midTitle, senTitle;
    private ListView<Title> priListView, midListView, senListView;

    /**
     * 初始化用于展示三个级别的listView
     */
    private void initTitleListView() throws IOException {

        BigTitle bigTitle = JsonManager.getTitleData();

        priTitle = FXCollections.observableArrayList();
        midTitle = FXCollections.observableArrayList();
        senTitle = FXCollections.observableArrayList();


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
    }


    public CBMain() throws IOException {


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

        VBox titlePri = new VBox(hBoxPri, priListView);
        VBox titleMid = new VBox(hBoxMid, midListView);
        VBox titleSenior = new VBox(hBoxSen, senListView);

        //手风琴布局尝试
        TitledPane priTitledPane = new TitledPane("Java", priListView);
        TitledPane midTitlePane = new TitledPane("Java", midListView);
        TitledPane senTitlePane = new TitledPane("Java", senListView);


        Accordion accordion = new Accordion();

        accordion.getPanes().addAll(priTitledPane, midTitlePane, senTitlePane);




        VBox leftTitles = new VBox(accordion);

        leftTitles.setMinWidth(300);
        HBox mainhBox = new HBox(leftTitles);
        Scene scene = new Scene(mainhBox, 800, 800);

        this.setScene(scene);
    }

    /**
     * 设置listView的样式专用类
     */
    private class TitleCell extends ListCell<Title> {
        private Text name;
        private HBox mainHBox;
        private RadioButton finished;

        public TitleCell() {
            super();
            name = new Text();
            name.setFont(new Font("黑体", 20));
            finished = new RadioButton();
            finished.setText("已完成");
          //  finished.setBorder(new Border(10,10,10,10));
//            finished.setAlignment();
            //    finished.setMinWidth(50);
            //     finished.setMinHeight(50);
            //  finished.setMaxWidth(30);

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
