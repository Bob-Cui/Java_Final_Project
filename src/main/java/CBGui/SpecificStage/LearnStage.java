package main.java.CBGui.SpecificStage;

import DataManager.Data.Problem;
import DataManager.Data.SelectItem;
import DataManager.Data.SelectProblem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.java.CBGui.LearnJavaFX.LearnListView;
import main.java.CBGui.SpecificStage.MyBox.ProblemVBox;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 专用于展示学习Java的内容用的页面
 */
public class LearnStage extends Stage {

    private Scene scene;
    //这个Stage用到的Scene
    private HBox hBox;
    private VBox rVbox;
    private VBox quest;
    //右侧用于题目展示








    private void init_questVbox() {






    }


    private ObservableList<Problem> problemObservableList;
    private ListView<Problem> problemListView;

    private void initProblemList() {
        problemObservableList = FXCollections.observableArrayList();

        for (int i = 0; i < 10; i++) {

            problemObservableList.add(new Problem("今天天气怎么样"));
        }

        problemListView = new ListView<>(problemObservableList);

        problemListView.setCellFactory(new Callback<ListView<Problem>, ListCell<Problem>>() {
            @Override
            public ListCell<Problem> call(ListView<Problem> problemListView) {
                return new ProCell();
            }
        });
    }

    /**
     * 先写一个默认的构造函数试一试
     *
     * @throws MalformedURLException
     */
    public LearnStage() throws MalformedURLException {
        WebView webView = new WebView();
        File file = new File("C:\\Users\\DELL\\Desktop\\Java.html");
        URL url = file.toURI().toURL();
        webView.getEngine().load(url.toString());
        initProblemList();
        Text text = new Text("请回答以下的问题");
        text.setStyle("-fx-font-size: 30px");



        HBox hBox = new HBox();
        ProblemVBox problemVBox = new ProblemVBox();
        rVbox = new VBox(text,problemVBox);
        hBox = new HBox(webView, rVbox);
        scene = new Scene(hBox);
        this.setScene(scene);
    }

    public LearnStage(String address) {


    }


    private class ProCell extends ListCell<Problem> {
        private HBox content;
        private VBox mainConten;
        private Text name;
        ToggleGroup select;


        public ProCell() {
            super();
            select = new ToggleGroup();
            RadioButton A = new RadioButton("A");
            RadioButton B = new RadioButton("B");
            RadioButton C = new RadioButton("C");
            RadioButton D = new RadioButton("D");
            A.setToggleGroup(select);
            B.setToggleGroup(select);
            C.setToggleGroup(select);
            D.setToggleGroup(select);

            A.setUserData("A");//这可真是神奇的获取数据的方式
            B.setUserData("A");
            C.setUserData("A");
            D.setUserData("A");


            select.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                    if (select.getSelectedToggle() != null) {


                        System.out.println(select.getSelectedToggle().getUserData());
                    }
                }
            });

            name = new Text("这是一道题");
            content = new HBox(A, B, C, D);
            content.setSpacing(20);
            mainConten = new VBox(name, content);
            mainConten.setPrefHeight(100);

        }

        @Override
        protected void updateItem(Problem problem, boolean b) {
            super.updateItem(problem, b);
            if (problem != null && !b) {

                name.setText(problem.getContent());
                content.applyCss();
                setGraphic(mainConten);

            } else {
                setGraphic(null);
            }


        }
    }

}
