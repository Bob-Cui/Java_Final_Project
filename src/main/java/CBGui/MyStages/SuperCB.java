package main.java.CBGui.MyStages;


import DataManager.Data.*;
import DataManager.DataProcess.JsonManager;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.Map;


/**
 * 随机调没学过的进行推荐功能
 * 笔记
 * 记录的功能
 */
public class SuperCB extends Stage {


    private static class TreeTitle {

        private int type;

        private String name;

        private Title newTitleManager;

        public TreeTitle(int type, String name, Title newTitleManager) {
            this.type = type;
            this.name = name;
            this.newTitleManager = newTitleManager;
        }


        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Title getNewTitleManager() {
            return newTitleManager;
        }

        public void setNewTitleManager(Title newTitleManager) {
            this.newTitleManager = newTitleManager;
        }
    }

    private TreeView<TreeTitle> mainTreeView;


    /**
     * 所有数据的来源
     */
    private static BigTitle bigTitle;

    public static LinkedList<String> enableTitles;

    private VBox mainVBox;


    /**
     * 确定这个人要学的功能
     *
     * @param dataStructure 是否需要学数据结构
     */
    public static void initEnableTitles(boolean dataStructure) {
        enableTitles = new LinkedList<>();
        enableTitles.add("Java初级教程");
        enableTitles.add("Java中级教程");
        enableTitles.add("Java高级教程");
        if (dataStructure) {
            enableTitles.add("数据结构");
        }
    }


    static {
        try {
            bigTitle = JsonManager.getBigTitle();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用来展示有关Java的介绍
     */
    private WebView introJavaWebView;


    /**
     * 修改窗体的图标
     */
    private void setStageTitle() {
        this.setTitle("崔哥学Java");
        this.getIcons().add(new Image("file:Resource/icon.jpg"));
    }

    private void initNewTreeView() {
        initEnableTitles(false);

        TreeItem<TreeTitle> rootItem = new TreeItem<>(new TreeTitle(1, "快乐学Java", null));


        for (String titleName : enableTitles) {


            TreeItem<TreeTitle> subTreeItem = new TreeItem<>(new TreeTitle(2, titleName, null));
            for (Map.Entry<Integer, Title> stringNewTitleManagerEntry : bigTitle.getStringNewSubTitleManagerHashMap().get(titleName).getIntegerNewTitleManagerHashMap().entrySet()) {
                TreeItem<TreeTitle> littleTitle = new TreeItem<>(new TreeTitle(3, stringNewTitleManagerEntry.getValue().getName(), stringNewTitleManagerEntry.getValue()));
                subTreeItem.getChildren().add(littleTitle);
            }
            rootItem.getChildren().add(subTreeItem);
        }
        mainTreeView = new TreeView<>(rootItem);
        mainTreeView.setCellFactory(new Callback<TreeView<TreeTitle>, TreeCell<TreeTitle>>() {
            @Override
            public TreeCell<TreeTitle> call(TreeView<TreeTitle> treeTitleTreeView) {

                TreeCell<TreeTitle> treeTitleTreeCell = new TreeCell<>() {

                    private HBox mainHBox;

                    @Override
                    protected void updateItem(TreeTitle treeTitle, boolean b) {
                        super.updateItem(treeTitle, b);

                        if (treeTitle != null && !b) {
                            Label label = new Label();
                            label.setText(treeTitle.getName());

                            /**
                             * 设置一下label的类型
                             */
                            switch (treeTitle.getType()) {
                                case 1: {
                                    Image image = new Image("file:src/Source/javafa.jpg", 45, 45, true, true);
                                    label.setGraphic(new ImageView(image));
                                    label.setStyle("-fx-font-size: 28px;-fx-font-weight: bold;-fx-text-fill: mediumpurple");

                                    break;
                                }
                                case 2:
                                    label.setStyle("-fx-font-size: 23px");
                                    break;
                                case 3: {
                                    Image image = new Image("file:src/Source/javaRed.jpg", 23, 23, true, true);
                                    label.setGraphic(new ImageView(image));
                                    label.setStyle("-fx-font-weight: bold;-fx-font-size: 17px;-fx-text-fill: lightskyblue");

                                    double big = 1.2;
                                    label.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            label.setScaleY(big);
                                            label.setScaleX(big);

                                        }
                                    });

                                    label.setOnMouseExited(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            label.setScaleX(1);
                                            label.setScaleY(1);

                                        }
                                    });
                                    label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent mouseEvent) {

                                            //双击两次进去
                                            if (mouseEvent.getClickCount() == 2) {


                                            }
                                        }
                                    });

                                    break;
                                }
                                default:
                                    break;

                            }
                            mainHBox = new HBox();
                            mainHBox.getChildren().add(label);
                            setGraphic(mainHBox);
                        } else {
                            setGraphic(null);
                        }

                    }
                };


                return treeTitleTreeCell;
            }


        });

/**
 * 设置一下点击事件
 */
        mainTreeView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                TreeTitle treeTitle = mainTreeView.getTreeItem(t1.intValue()).getValue();
                System.out.println(treeTitle.getName());
                if (treeTitle.getType() == 3) {
                    try {
                        LearnStage learnStage = new LearnStage(treeTitle.getNewTitleManager());
                        learnStage.showAndWait();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        mainTreeView.setMinHeight(800);
        mainTreeView.setMinWidth(400);
        mainTreeView.setStyle("-fx-border-width: 10px;-fx-border-color: #4183C4;-fx-border-radius: 10px");
    }

    public SuperCB() throws IOException {

        setStageTitle();
        Image imageIcon = new Image("file:src/Source/javasmall.jpg", 20, 20, true, true);
        this.getIcons().add(imageIcon);

        Image image = new Image("file:src/Source/javatx.png", 430, 430, false, false);
        ImageView imageView = new ImageView(image);


        /**
         * 这个地方可以添加一个线程
         */


        GridPane mainGrid = new GridPane();


        initNewTreeView();


        mainGrid.setStyle("-fx-background-image: url(" + "file:src/Source/javaback.jpg" + ")");
        mainGrid.setHgap(30);

        mainGrid.setVgap(30);
        mainVBox = new VBox();


        MenuBar mainMenuBar = new MenuBar();

        mainMenuBar.prefWidthProperty().bind(this.widthProperty());//竟然会有这样的语句真是让我大吃一惊


        Menu project = new Menu("项目");

        Menu date = new Menu("日期");
        MenuItem dateShower = new MenuItem();
        DatePicker checkInDatePicker = new DatePicker();
        dateShower.setGraphic(checkInDatePicker);

        date.getItems().add(dateShower);

        Menu progress = new Menu("我的进度");
        MenuItem menuItem = new MenuItem();
        progress.getItems().add(menuItem);
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setProgress(.5f);




        progressIndicator.setMinWidth(300);
        progressIndicator.setMinHeight(300);
        menuItem.setGraphic(progressIndicator);


        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem exit = new MenuItem("退出");

        exit.setOnAction(actionEvent -> Platform.exit());


        project.getItems().addAll(date, progress, separatorMenuItem, exit);
        mainMenuBar.getMenus().add(project);


        Menu lastJava = new Menu("Java技术最新进展");
        MenuItem java11 = new MenuItem("Java11");
        java11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                ShowHtml showHtml = null;
                try {
                    showHtml = new ShowHtml("Java11新特性", "src/pages/Java11最新特性.html");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                showHtml.showAndWait();
            }
        });
        MenuItem java13 = new MenuItem("Java13");
        java13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ShowHtml showHtml = new ShowHtml("Java13新特性", "src/pages/Java13最新特性.html");
                    showHtml.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }


            }
        });
        MenuItem java15 = new MenuItem("Java15");
        java15.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ShowHtml showHtml = new ShowHtml("Java15新特性", "src/pages/Java15最新特性.html");
                    showHtml.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        MenuItem lambda = new MenuItem("Lambda 表达式");
        lambda.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ShowHtml showHtml = new ShowHtml("Lambda 表达式", "src/pages/Lambda 表达式.html");
                    showHtml.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        lastJava.getItems().addAll(java11, java13, java15, lambda);

        Menu professionalLearning = new Menu("专业学习");


        Menu ds = new Menu("数据结构");
        MenuItem ds1 = new MenuItem("Java Bitset类");
        ds1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    ShowHtml showHtml = new ShowHtml("Java Bitset类", "src/pages/DS/Java Bitset类.html");
                    showHtml.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            }
        });

        MenuItem ds2 = new MenuItem("Java BitSet类");
        ds2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ShowHtml showHtml = new ShowHtml("Java BitSet类", "src/pages/DS/Java Bitset类.html");
                    showHtml.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });


        MenuItem ds3 = new MenuItem("Java LinkedList");
        ds3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ShowHtml showHtml = new ShowHtml("Java LinkedList", "src/pages/DS/Java集合 LinkedList的原理及使用.html");
                    showHtml.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });


        MenuItem ds4 = new MenuItem("Java HashTable类");
        ds4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ShowHtml showHtml = new ShowHtml("Java HashTable类", "src/pages/DS/Java Hashtable 类.html");
                    showHtml.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });

        MenuItem ds5 = new MenuItem("Java Stack类");
        ds5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ShowHtml showHtml = new ShowHtml("Java Stack类", "src/pages/DS/Java Stack类.html");
                    showHtml.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        MenuItem ds6 = new MenuItem("Java Vector类");
        ds6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ShowHtml showHtml = new ShowHtml("Java Vector类", "src/pages/DS/Java Vector 类.html");
                    showHtml.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        MenuItem ds7 = new MenuItem("Java Sort方法");
        ds7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ShowHtml showHtml = new ShowHtml("Java Sort方法", "src/pages/DS/JavaSort.html");
                    showHtml.showAndWait();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });


        ds.getItems().addAll(ds1, ds2, ds3, ds4, ds5, ds6, ds7);
        professionalLearning.getItems().add(ds);
        mainMenuBar.getMenus().add(professionalLearning);


        Menu learningRecord = new Menu("学习数据");
        MenuItem timeRecord = new MenuItem("历史记录");//这个人一共在软件上用时多少
        MenuItem review = new MenuItem("我的复习");
        MenuItem errorCount = new MenuItem("错题统计");
        MenuItem myNote = new MenuItem("我的笔记");


        timeRecord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    LearningRecordStage learningRecordStage = new LearningRecordStage(JsonManager.getLearnRecord());

                    learningRecordStage.showAndWait();

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });


        errorCount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                ErrorStatistic errorStatistic = new ErrorStatistic();
                errorStatistic.showAndWait();


            }
        });


        learningRecord.getItems().addAll(timeRecord, review, errorCount, myNote);


        mainMenuBar.getMenus().add(learningRecord);
        mainMenuBar.getMenus().add(lastJava);


        mainGrid.add(mainTreeView, 1, 1);

        mainVBox.getChildren().addAll(mainMenuBar, mainGrid);


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        Scene scene = new Scene(mainVBox, 3 * dimension.width / 4, 3 * dimension.height / 4);


        this.setScene(scene);
    }


}