package main.java.CBGui.SpecificStage;

import DataManager.Data.BigTitleData;
import DataManager.Data.TitleData;
import DataManager.JsonManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CBMain extends Stage {


    private TreeItem<String> treeItem;


    private void init_treeItem()
    {
        TreeItem<String> rootItem = new TreeItem<>("快乐学JAVA");

        rootItem.setExpanded(true);

        BigTitleData bigTitleData = null;
        try {
            bigTitleData = JsonManager.getBigTitleData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //越来越佩服自己了
        for (TitleData c : bigTitleData.getDatas()) {

            TreeItem<String> item = new TreeItem<>(c.getTitle());

            for (TitleData.Subtitle c1 : c.getSubtitles()) {

                TreeItem<String> item1 = new TreeItem<>(c1.getTitle());
                for (String str : c1.getSubtitles()) {
                    TreeItem<String> item2 = new TreeItem<>(str);
                    item1.getChildren().add(item2);
                }
                item.getChildren().add(item1);
            }
            rootItem.getChildren().add(item);
        }


        TreeView<String> tree = new TreeView<>(rootItem);

        tree.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                System.out.println(tree.getTreeItemLevel(tree.getTreeItem(t1.intValue())));
                System.out.println(tree.getTreeItem(t1.intValue()));

            }
        });
        tree.setStyle("-fx-font-size: 25px");

        tree.setMaxWidth(500);
        tree.setMinWidth(500);

    }
    public CBMain() {






//         Image image = new Image("C:\\Users\\DELL\\Desktop\\JavaFinalProject\\Resource\\slcj.png",false);
//        Image image3 = new Image("file:src/slcj.png", 400, 400, false, false);
//
//        ImageView imageView = new ImageView();
//        imageView.setImage(image3);
//
//      //  HBox hBox = new HBox(tree, imageView);
//        Scene scene = new Scene(hBox);
//        this.setScene(scene);
    }
}
