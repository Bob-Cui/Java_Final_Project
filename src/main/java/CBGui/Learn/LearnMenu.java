package main.java.CBGui.Learn;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LearnMenu extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Menus");

        HBox root = new HBox();
        Scene scene = new Scene(root, 300, 250);

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("File");
        menu.getItems().add(new MenuItem("New"));
        menu.getItems().add(new MenuItem("Save"));
        menu.getItems().add(new SeparatorMenuItem());
        menu.getItems().add(new MenuItem("Exit"));

        CustomMenuItem customMenuItem = new CustomMenuItem(new Slider());
        customMenuItem.setHideOnClick(false);
        menu.getItems().add(customMenuItem);

        menuBar.getMenus().add(menu);

        menuBar.prefWidthProperty().bind(stage.widthProperty());

        root.getChildren().add(menuBar);
        stage.setScene(scene);
        stage.show();
    }
}
