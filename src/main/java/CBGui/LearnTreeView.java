package main.java.CBGui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LearnTreeView extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // TreeView
//        GridPane gridPane = new GridPane();
        TreeItem<String> rootItem = new TreeItem<>("Inbox");
        rootItem.setExpanded(true);
        // 每个Item下又可以添加新的Item
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<>("Message" + i);
            item.getChildren().add(new TreeItem<String>("第三级"));
            rootItem.getChildren().add(item);
        }
        // 创建TreeView
        TreeView<String> tree = new TreeView<>(rootItem);

        StackPane root = new StackPane();
        root.getChildren().add(tree);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();


    }
}
