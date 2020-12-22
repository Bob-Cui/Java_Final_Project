package main.java.CBGui.SpecificStage;

import DataManager.Data.TitleManager;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.java.CBGui.SpecificStage.XCYBox.ProblemVBox;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

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
    public LearnStage(TitleManager newTitleManager) throws MalformedURLException {

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


    



}
