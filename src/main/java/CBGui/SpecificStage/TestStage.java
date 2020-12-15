package main.java.CBGui.SpecificStage;

import DataManager.Data.NewProblems;
import DataManager.Data.NewSelectProblem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//import javax.swing.text.html.ListView;
import java.util.Map;

/**
 * 用于显示能够用来测试的界面
 * 这个界面可以复用
 */
public class TestStage extends Stage {
    private ListView<NewSelectProblem> mainListView;

    /**
     *
     * @param title
     * @param newProblems
     */
    public TestStage(String title, NewProblems newProblems) {
        VBox mainVBox = new VBox();
        Text text = new Text();
        ObservableList<NewSelectProblem>newSelectProblemObservableList=FXCollections.observableArrayList();
        for (Map.Entry<Integer, NewSelectProblem> integerNewSelectProblemEntry : newProblems.getIntegerNewSelectProblemHashMap().entrySet()) {
            newSelectProblemObservableList.add(integerNewSelectProblemEntry.getValue());
        }
        mainListView = new ListView<>(newSelectProblemObservableList);
    }
}
