package main.java.CBGui.SpecificStage;

import DataManager.Data.NewTitleManager;
import DataManager.Data.OldData.Problem;
import DataManager.Data.OldData.SelectProblem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import main.java.CBGui.SpecificStage.XCYBox.ProblemVBox;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import static main.java.CBGui.SpecificStage.XCYMain.checkProgress;

/**
 * 专用于展示学习Java的内容用的页面
 */
public class LearnStage extends Stage {

    private Scene scene;
    //这个Stage用到的Scene
    private HBox mainHBox;
    private VBox rVbox;
    private VBox quest;
    //右侧用于题目展示


    private void init_questVbox() {


    }


    private ObservableList<Problem> problemObservableList;
    private ListView<Problem> problemListView;
    private ObservableList<SelectProblem> selectProblems;
    private ListView<SelectProblem> selectProblemListView;



    /**
     * 根据传来的题目来构建相应的 listview
     *
     * @param selectProblemLinkedList
     */
    private void initSelectList(LinkedList<SelectProblem> selectProblemLinkedList) {
        selectProblems = FXCollections.observableArrayList();
        selectProblems.addAll(selectProblemLinkedList);


        selectProblemListView = new ListView<>(selectProblems);


        selectProblemListView.setCellFactory(new Callback<ListView<SelectProblem>, ListCell<SelectProblem>>() {
            @Override
            public ListCell<SelectProblem> call(ListView<SelectProblem> selectProblemListView) {
                return null;
            }

        });

    }

    /**
     * 修改窗体的名字，设置窗体的图标
     *
     * @param titleName 窗体的名字
     */
    private void setStageTitle(String titleName) {
        this.setTitle(titleName);
        this.getIcons().add(new Image("file:src/Source/sencq.png"));
    }

    /**
     * 新的构造函数，构造函数传入了数据
     *
     * @param newTitleManager 这个窗体在建立的时候所需要的数据
     * @throws MalformedURLException 不需要知道原因的异常
     */
    public LearnStage(NewTitleManager newTitleManager) throws MalformedURLException {

        WebView webView = new WebView();
        File file = new File(newTitleManager.getResource() + ".html");
        System.out.println(newTitleManager.getResource());
        URL url = file.toURI().toURL();
        webView.getEngine().load(url.toString());





        Image image = new Image("file:src/Source/sencq.png",50,50,true,true);
        Label text = new Label("请回答以下的问题",new ImageView(image));
        text.setStyle("-fx-font-size: 30px");



        setStageTitle(newTitleManager.getName());

        ProblemVBox problemVBox = new ProblemVBox(newTitleManager);


        rVbox = new VBox(text, problemVBox);
        mainHBox = new HBox(webView, rVbox);

        scene = new Scene(mainHBox);
        // problemVBox.setMinWidth(scene.getWidth()/2);
        //problemVBox.setMaxWidth(scene.getWidth()/2);
        this.setScene(scene);

        /**
         *每一个学习界面在关闭的时候都要调用checkProgress函数来更新这个人自己的学习进度
         */
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
//                System.out.println("页面关闭了");
                checkProgress();
            }
        });

    
    }


    

    private class SelectProblemCell extends ListCell<SelectProblem> {
        private HBox content;
        private VBox mainConten;
        private Text name;
        ToggleGroup select;

        public SelectProblemCell() {
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
        protected void updateItem(SelectProblem selectProblem, boolean b) {
            super.updateItem(selectProblem, b);
            if (selectProblem != null && !b) {

                name.setText(selectProblem.getContent());
                content.applyCss();
                setGraphic(mainConten);

            } else {
                setGraphic(null);
            }

        }
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
