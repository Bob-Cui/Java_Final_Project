package main.java.CBGui.SpecificStage;

import DataManager.Data.NewProblems;
import DataManager.Data.NewSelectProblem;
import DataManager.Data.NewSubTitleManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Map;

import static main.java.CBGui.SpecificStage.XCYMain.newNewBigTitleManager;

/**
 * 如果弄模糊或者是记得清楚这项功能的话有点太复杂
 * 我会被累死的
 */
public class EbbinghausStage extends Stage {



    private ListView<NewSelectProblem> newSelectProblemListView;


    /**
     * 检查这个人需要进行复习的科目
     */
    private void timeCheck() {

        for(Map.Entry<String, NewSubTitleManager>stringNewProblemsEntry:newNewBigTitleManager.getStringNewSubTitleManagerHashMap().entrySet())
        {
            if(!stringNewProblemsEntry.getValue().isAbleToLearn())
                continue;

        }




    }

    public EbbinghausStage(NewProblems newProblems) {

        HBox mainHBox = new HBox();
        double len = 400;
        Image image = new Image("file:src/Source/abhs.png", len, len, true, true);
        ImageView imageView = new ImageView(image);


        ObservableList<NewSelectProblem> newSelectProblemObservableList = FXCollections.observableArrayList();

        for (Map.Entry<Integer, NewSelectProblem> integerSelectProblemEntry : newProblems.getIntegerNewSelectProblemHashMap().entrySet()) {
            newSelectProblemObservableList.add(integerSelectProblemEntry.getValue());
        }
        newSelectProblemListView = new ListView<>(newSelectProblemObservableList);


        mainHBox.getChildren().add(imageView);
        mainHBox.getChildren().add(newSelectProblemListView);

        this.setScene(new Scene(mainHBox));


    }


    /**
     * 继承了一个容器，问就说是在官网上看的
     */
//    private static  class EbbinghausStageCell extends
}
