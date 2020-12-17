package main.java.CBGui.SpecificStage;


import DataManager.Data.*;
import DataManager.Data.OldData.BigTitleManager;
import DataManager.DataProcess.JsonManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
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

    private TreeView<String> newTitleManagerTreeView;
    /**
     * Java介绍网页的相对地址
     */
    private final String INTROJAVAPATH = "Resource/Javainfor.html";


    /**
     * 所有数据的来源
     */
    private static NewBigTitleManager newBigTitleManager;

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


    private void initTreeView() {
        Image image = new Image("file:src/Source/rootItem.jpg", 25, 25, true, true);

        TreeItem<String> rootItem = new TreeItem<>("快乐的Java快乐学");
        rootItem.setGraphic(new ImageView(image));


        for (Map.Entry<String, NewSubTitleManager> stringNewSubTitleManagerEntry : newBigTitleManager.getStringNewSubTitleManagerHashMap().entrySet()) {
            TreeItem<String> item = new TreeItem<>(stringNewSubTitleManagerEntry.getKey());


            for (Map.Entry<Integer, NewTitleManager> integerNewTitleManagerEntry : stringNewSubTitleManagerEntry.getValue().getIntegerNewTitleManagerHashMap().entrySet()) {
                TreeItem<String> item1 = new TreeItem<>(integerNewTitleManagerEntry.getValue().getName());
                item.getChildren().add(item1);
            }
            rootItem.getChildren().add(item);
        }
        newTitleManagerTreeView = new TreeView<>(rootItem);
    }

    public SuperCB() throws IOException {
        closeAndWrite();
        setStageTitle();
        initWebPage();


        Image image = new Image("file:Resource/JAVA.jpg", 250, 250.0, false, false);
        ImageView imageView = new ImageView(image);

        Text text2 = new Text("fd");

        GridPane mainGrid = new GridPane();


        Button button = new Button();
        button.setText("更新我的学习进度");
        button.setStyle("-fx-font-size: 30px");

        Button button1 = new Button();
        //  button.setText("查看我的得分");

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


        //HBox mainhBox = new HBox(leftTitles, mainGrid);
        initTreeView();
        HBox hBox = new HBox(mainGrid, newTitleManagerTreeView);
//        mainFlowPane = new FlowPane(leftFlowPane, hBox);
        HBox main = new HBox(hBox);


        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        introJavaWebView.setMinWidth(dimension.width / 2);


        Scene scene = new Scene(main, 3 * dimension.width / 4, dimension.height);

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
     * 检查是否有需要复习的章节
     */
    private void reviewOrNot() {
        for (Map.Entry<String, NewSubTitleManager> item1 : newBigTitleManager.getStringNewSubTitleManagerHashMap().entrySet()) {

//            for ()


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
