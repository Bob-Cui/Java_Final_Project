package main.java.CBGui.CbStage;

import DataManager.Data.NewProblems;
import DataManager.Data.NewTitleManager;
import DataManager.Data.OldData.Problem;
import DataManager.Data.OldData.SelectProblem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

/**
 * 专用于展示学习Java的内容用的页面
 */
public class LearnStage extends Stage {

    private Scene scene;
    private HBox hBox;


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
     * 新的构造函数，真是有趣的紧
     *
     * @param newTitleManager
     * @throws MalformedURLException
     */
    public LearnStage(NewTitleManager newTitleManager) throws MalformedURLException {
        this.getIcons().add(new Image("file:src/Source/javafa.jpg"));
        this.setTitle("快乐学" + newTitleManager.getName());


        WebView webView = new WebView();
        File file = new File(newTitleManager.getResource() + ".html");
        System.out.println(newTitleManager.getResource());
        URL url = file.toURI().toURL();
        webView.getEngine().load(url.toString());
        Text text = new Text("请回答以下的问题");
        text.setStyle("-fx-font-size: 30px");
        hBox = new HBox(webView);
        scene = new Scene(hBox);


        GridPane bottomHBox = new GridPane();

        Button myNote = new Button();
        myNote.setText("查看笔记");

        myNote.setStyle("-fx-text-fill: #4183C4;-fx-font-size: 20px;-fx-font-weight: bold;-fx-background-radius: 20px;-fx-border-width: 3px;-fx-border-color: #B5D6FC;-fx-border-radius: 20px");

        {
            double big = 1.3;
            myNote.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    myNote.setScaleX(big);
                    myNote.setScaleY(big);
                }
            });
            myNote.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    myNote.setScaleX(1);
                    myNote.setScaleY(1);
                }
            });
            myNote.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                }
            });
        }

        Button myTest = new Button();
        myTest.setText("参加检测");

        myTest.setStyle("-fx-text-fill: #4183C4;-fx-font-size: 20px;-fx-font-weight: bold;-fx-background-radius: 20px;-fx-border-width: 3px;-fx-border-color: #B5D6FC;-fx-border-radius: 20px");

        {
            double big = 1.3;
            myTest.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    myTest.setScaleX(big);
                    myTest.setScaleY(big);
                }
            });
            myTest.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    myTest.setScaleX(1);
                    myTest.setScaleY(1);
                }
            });


            myTest.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getClickCount() == 2) {
                        CBQuizStage cbQuizStage = new CBQuizStage(newTitleManager.getName(), new NewProblems(newTitleManager.getIntegerSelectProblemHashMap()));
                        cbQuizStage.showAndWait();
                    }
                }
            });
        }

        //bottomHBox.getChildren().addAll(myNote, myTest);

        bottomHBox.add(new Label(), 0, 0);
        bottomHBox.add(myNote, 1, 0);
        bottomHBox.add(myTest, 2, 0);
        bottomHBox.add(new Label(), 3, 0);

        bottomHBox.setHgap(180);
        GridPane gridPane = new GridPane();

        GridPane.setHalignment(bottomHBox, HPos.CENTER);
        //  GridPane.setValignment(bottomHBox, VPos.CENTER);
        gridPane.add(webView, 1, 1);
        gridPane.add(bottomHBox, 1, 2);
        gridPane.add(new Label(), 1, 3);
        gridPane.add(new Label(), 2, 1);

        gridPane.setStyle("-fx-background-image: url(" + "file:src/Source/javaback.jpg" + ")");


        gridPane.setHgap(10);
        gridPane.setVgap(30);

        this.setScene(new Scene(gridPane));
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
