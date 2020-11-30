package main.java.CBGui.LearnJavaFX;

import DataManager.Data.BigTitleData;
import DataManager.Data.TitleData;
import DataManager.JsonManager;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class LearnTreeView extends Application {


    @Override
    public void start(Stage stage) throws Exception {


//        TreeItem<String> rootItem = new TreeItem<>("快乐学JAVA");
//
//        rootItem.setExpanded(true);
//
//        BigTitleData bigTitleData = JsonManager.getBigTitleData();
//        //越来越佩服自己了
//        for (TitleData c : bigTitleData.getDatas()) {
//
//            TreeItem<String> item = new TreeItem<>(c.getTitle());
//
//            for (TitleData.Subtitle c1 : c.getSubtitles()) {
//
//                TreeItem<String> item1 = new TreeItem<>(c1.getTitle());
//                for (String str : c1.getSubtitles()) {
//                    TreeItem<String> item2 = new TreeItem<>(str);
//                    item1.getChildren().add(item2);
//                }
//                item.getChildren().add(item1);
//            }
//            rootItem.getChildren().add(item);
//        }


//
//        TreeView<String> tree = new TreeView<>(rootItem);
//
//        tree.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//
//                System.out.println(tree.getTreeItemLevel(tree.getTreeItem(t1.intValue())));
//                System.out.println(tree.getTreeItem(t1.intValue()));
//
//            }
//        });
//        tree.setStyle("-fx-font-size: 25px");

        StackPane root = new StackPane();


       // root.getChildren().add(tree);
        stage.setScene(new Scene(root, 600, 600));
        stage.show();


    }
}
