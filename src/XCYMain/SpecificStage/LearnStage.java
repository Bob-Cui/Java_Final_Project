package XCYMain.SpecificStage;

import DataManager.Data.TitleManager;
import XCYMain.SpecificStage.XCYBox.ProblemVBox;
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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * 专用于展示学习Java的内容用的页面
 */
public class LearnStage extends Stage {

    private Scene scene;
    //这个Stage用到的Scene
    private HBox mainHBox;
    private VBox rVbox;
    private VBox quest;


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
    public LearnStage(String subtitleName, TitleManager newTitleManager) throws MalformedURLException {

        WebView webView = new WebView();
        File file = new File(newTitleManager.getResource() + ".html");
        System.out.println(newTitleManager.getResource());
        URL url = file.toURI().toURL();
        webView.getEngine().load(url.toString());


        Image image = new Image("file:src/Source/sencq.png", 50, 50, true, true);
        Label text = new Label("请回答以下的问题", new ImageView(image));
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
                recommend(subtitleName);
            }
        });


    }

    /**
     *
     */

    private void recommend(String name) {
        for (Map.Entry<Integer, TitleManager> integerTitleManagerEntry : XCYMain.allData.getStringNewSubTitleManagerHashMap().get(name).getIntegerNewTitleManagerTreeMap().entrySet()) {
            if (integerTitleManagerEntry.getValue().isLearned() == false) {
                String title = integerTitleManagerEntry.getValue().getName();
                double len = 40;
                Alert success = new Alert(Alert.AlertType.INFORMATION);
                Image image = new Image("file:src/Source/icon.jpg", len, len, true, true);
                success.setGraphic(new ImageView(image));
                success.setTitle("进度更新");
                success.setHeaderText("请继续下一步的学习");
                success.setContentText(String.format("推荐你学习%s这一章", title));
                success.showAndWait();
                break;
            }
        }
    }
}
