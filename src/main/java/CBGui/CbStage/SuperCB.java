package main.java.CBGui.CbStage;


import DataManager.Data.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
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
import java.util.LinkedList;
import java.util.Map;

import static DataManager.DataProcess.JsonManager.getNewBigTitleManager;


/**
 * 随机调没学过的进行推荐功能
 * 笔记
 * 记录的功能
 */
public class SuperCB extends Stage {


    private static class TreeTitle {

        private int type;

        private String name;

        private NewTitleManager newTitleManager;

        public TreeTitle(int type, String name, NewTitleManager newTitleManager) {
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

        public NewTitleManager getNewTitleManager() {
            return newTitleManager;
        }

        public void setNewTitleManager(NewTitleManager newTitleManager) {
            this.newTitleManager = newTitleManager;
        }
    }

    private TreeView<TreeTitle> newTitleManagerTreeView;

    private TreeTableView<TreeTitle> treeTitleTreeTableView;

    /**
     * Java介绍网页的相对地址
     */
    private final String INTROJAVAPATH = "Resource/Javainfor.html";


    /**
     * 所有数据的来源
     */
    private static NewBigTitleManager newBigTitleManager;

    public static LinkedList<String> enableTitles;

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
            newBigTitleManager = getNewBigTitleManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用来展示有关Java的介绍
     */
    private WebView introJavaWebView;

    /**
     * 有趣的关于查看学习进度的按钮
     * 实际上这并不是一个严格意义上的按钮而是用两个圆叠加形成的效果
     */
    private Group checkProgress;
    private Circle checkProgressCircleButtom, checkProgressCircleUp;


    private Button priTest, Mid;

    private void initWebPage() throws MalformedURLException {
        introJavaWebView = new WebView();
        File file = new File(INTROJAVAPATH);
        URL url = file.toURI().toURL();
        introJavaWebView.getEngine().load(url.toString());
    }


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
            for (Map.Entry<Integer, NewTitleManager> stringNewTitleManagerEntry : newBigTitleManager.getStringNewSubTitleManagerHashMap().get(titleName).getIntegerNewTitleManagerHashMap().entrySet()) {
                TreeItem<TreeTitle> littleTitle = new TreeItem<>(new TreeTitle(3, stringNewTitleManagerEntry.getValue().getName(), stringNewTitleManagerEntry.getValue()));
                subTreeItem.getChildren().add(littleTitle);
            }
            rootItem.getChildren().add(subTreeItem);
        }
        newTitleManagerTreeView = new TreeView<>(rootItem);
        newTitleManagerTreeView.setCellFactory(new Callback<TreeView<TreeTitle>, TreeCell<TreeTitle>>() {
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
                                    Image image = new Image("file:src/Source/javasmall (2).jpg", 23, 23, true, true);
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
        newTitleManagerTreeView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                TreeTitle treeTitle = newTitleManagerTreeView.getTreeItem(t1.intValue()).getValue();
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
        newTitleManagerTreeView.setMinHeight(800);
        newTitleManagerTreeView.setMinWidth(400);
        newTitleManagerTreeView.setStyle("-fx-border-width: 10px;-fx-border-color: #4183C4;-fx-border-radius: 10px");
    }

    public SuperCB() throws IOException {
        closeAndWrite();
        setStageTitle();
        initWebPage();


        Image image = new Image("file:src/Source/javatx.png", 430, 430, false, false);
        ImageView imageView = new ImageView(image);


        /**
         * 这个地方可以添加一个线程
         */
//        imageView.setStyle("-fx-border-width: 15px;-fx-border-color: lightblue;-fx-border-radius: 10px");


        Text text2 = new Text("fd");

        GridPane mainGrid = new GridPane();


        initNewTreeView();


        VBox functionButtons = new VBox();
        Button checkProgress = new Button();
        Button upDateJava = new Button();
        Button myLearnHistory = new Button();
        Button changeRole = new Button();//更换角色
        Button seeMyNote = new Button();

        checkProgress.setText("检查进度");
        upDateJava.setText("Java最新");
        myLearnHistory.setText("学习记录");
        changeRole.setText("更换角色");
        seeMyNote.setText("查看笔记");


        checkProgress.setStyle("-fx-font-weight: bold;-fx-font-size: 20px;-fx-text-fill: blue;");
        upDateJava.setStyle("-fx-font-weight: bold;-fx-font-size: 20px");
        myLearnHistory.setStyle("-fx-font-weight: bold;-fx-font-size: 20px");
        changeRole.setStyle("-fx-font-weight: bold;-fx-font-size: 20px");
        seeMyNote.setStyle("-fx-font-weight: bold;-fx-font-size: 20px");




        checkProgress.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        checkProgress.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        checkProgress.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {

                }
            }
        });


        upDateJava.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        upDateJava.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        upDateJava.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {

                }
            }
        });

        myLearnHistory.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        myLearnHistory.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        myLearnHistory.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {

                }
            }
        });

        changeRole.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        changeRole.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        changeRole.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {

                }
            }
        });


        seeMyNote.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        seeMyNote.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        seeMyNote.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {

                }
            }
        });


        functionButtons.getChildren().addAll(checkProgress, upDateJava, seeMyNote, changeRole, myLearnHistory);

        mainGrid.add(imageView, 2, 1);
        mainGrid.add(newTitleManagerTreeView, 1, 1);
        mainGrid.add(functionButtons, 3, 1);

        mainGrid.setStyle("-fx-background-image: url(" + "file:src/Source/javaback.jpg" + ")");
        mainGrid.setHgap(30);

        mainGrid.setVgap(30);


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        introJavaWebView.setMinWidth(dimension.width / 2);
        Scene scene = new Scene(mainGrid, 3 * dimension.width / 4, 3 * dimension.height / 4);


        this.setScene(scene);
    }

    /**
     * 检查是否有需要复习的章节
     */
    private void reviewOrNot() {
        for (Map.Entry<String, NewSubTitleManager> item1 : newBigTitleManager.getStringNewSubTitleManagerHashMap().entrySet()) {


        }


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


                }
            }
        });
    }


}
