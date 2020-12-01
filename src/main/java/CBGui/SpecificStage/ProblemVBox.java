package main.java.CBGui.SpecificStage;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProblemVBox extends VBox {

    private ToggleGroup toggleGroup;
    private RadioButton a, b, c, d;
    //四个单选框
    private HBox A, B, C, D;

    private VBox vBox;

    public ProblemVBox() {


        toggleGroup = new ToggleGroup();
        a.setToggleGroup(toggleGroup);
        b.setToggleGroup(toggleGroup);
        c.setToggleGroup(toggleGroup);
        d.setToggleGroup(toggleGroup);


        vBox.getChildren().addAll(a, b, c, d);


    }
}
