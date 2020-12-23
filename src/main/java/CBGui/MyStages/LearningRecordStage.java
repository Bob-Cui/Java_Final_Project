package main.java.CBGui.MyStages;

import DataManager.Data.LearnRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.SimpleTimeZone;

public class LearningRecordStage extends Stage {
    /**
     * 目前的想法是左边是图，右边是listview
     */

    private final NumberAxis xAxis = new NumberAxis();
    private final NumberAxis yAxis = new NumberAxis();
    private final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(
            xAxis, yAxis);

    private HBox mainHBox;

    private ObservableList<LearnRecord.TimeItem> timeItemObservableList;
    private ListView<LearnRecord.TimeItem> timeItemListView;


    private void initStage() {
        Image image = new Image("file:src/Source/javasmall.jpg", 20, 20, true, true);
        this.getIcons().add(image);
        this.setTitle("用户历史记录");
    }

    /**
     * @param learnRecord
     */
    public LearningRecordStage(LearnRecord learnRecord) {
        mainHBox = new HBox();
        lineChart.setTitle("浏览记录折线图");
        xAxis.setLabel("访问过程记录");
        yAxis.setLabel("访问时长(单位:分钟)");
        initStage();

        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName("浏览历史记录");


        XYChart.Series<Number, Number> avgSeries = new XYChart.Series<>();

        long sum = 0;
        timeItemObservableList = FXCollections.observableArrayList();

        for (Map.Entry<Integer, LearnRecord.TimeItem> integerTimeItemEntry : learnRecord.getIntegerTimeItemTreeMap().entrySet()) {
            timeItemObservableList.add(integerTimeItemEntry.getValue());
            series.getData().add(new XYChart.Data<>(integerTimeItemEntry.getKey(), integerTimeItemEntry.getValue().getTimeSpan()));
            sum += integerTimeItemEntry.getValue().getTimeSpan();
        }


        long avg = sum / learnRecord.getIntegerTimeItemTreeMap().size();
        for (int i = 0; i < learnRecord.getIntegerTimeItemTreeMap().size(); i++) {
            avgSeries.getData().add(new XYChart.Data<>(i, avg));
        }

        avgSeries.setName("平均使用时间");
        lineChart.getData().add(series);

        lineChart.getData().add(avgSeries);


        timeItemListView = new ListView<>(timeItemObservableList);

        timeItemListView.setCellFactory(new Callback<ListView<LearnRecord.TimeItem>, ListCell<LearnRecord.TimeItem>>() {
            @Override
            public ListCell<LearnRecord.TimeItem> call(ListView<LearnRecord.TimeItem> timeItemListView) {
                return new TimeItemCell();
            }
        });


        Scene scene = new Scene(mainHBox);
        mainHBox.setStyle("-fx-background-color: linear-gradient(to right, white, #87CEFA)");

        mainHBox.getChildren().addAll(lineChart, timeItemListView);

        mainHBox.setSpacing(50);
        mainHBox.setAlignment(Pos.CENTER);

        this.setScene(scene);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setMinHeight(dimension.getHeight() / 2);
        this.setMinWidth(dimension.getWidth() / 2);

        this.initModality(Modality.APPLICATION_MODAL);
    }

    /**
     * 我要是牛逼的话就能弄上 浏览记录
     */
    public static class TimeItemCell extends ListCell<LearnRecord.TimeItem> {

        private Label beginLabel, endLabel;
        private Label beginStr, endStr, sumStr;


        private VBox mainVBox;
        private HBox beginHBox, endHBox, sumHBox;


        public TimeItemCell() {


            Image image = new Image("file:src/Source/javaback.jpg", 25, 25, true, true);
            beginLabel = new Label();
            endLabel = new Label();


            beginLabel.setGraphic(new ImageView(image));
            endLabel.setGraphic(new ImageView(image));
//            sumTime.setGraphic(new ImageView(image))


            beginStr = new Label();
            endStr = new Label();
            sumStr = new Label();


            beginLabel.setText("开始时间");
            endLabel.setText("结束时间");


            beginLabel.setStyle("-fx-text-fill:#87CEFA;-fx-font-size: 17px;-fx-font-weight: bold;");
            endLabel.setStyle("-fx-text-fill:#87CEFA;-fx-font-size: 17px;-fx-font-weight: bold;");

            beginStr.setStyle("-fx-font-size: 14px;-fx-font-weight: bold;");
            endStr.setStyle("-fx-font-size: 14px;-fx-font-weight: bold;");

            sumStr.setStyle("-fx-text-fill:blue;-fx-font-size: 15px;-fx-font-weight: bold;");


            beginHBox = new HBox();
            endHBox = new HBox();
            sumHBox = new HBox();

            beginHBox.setSpacing(15);
            endHBox.setSpacing(15);
            sumHBox.setSpacing(15);

            beginHBox.getChildren().addAll(beginLabel, beginStr);
            endHBox.getChildren().addAll(endLabel, endStr);
            sumHBox.getChildren().addAll( sumStr);

            beginHBox.setAlignment(Pos.CENTER);
            endHBox.setAlignment(Pos.CENTER);
            sumHBox.setAlignment(Pos.BASELINE_LEFT);


            mainVBox = new VBox();

            mainVBox.getChildren().addAll(beginHBox, endHBox, sumHBox);
            mainVBox.setSpacing(10);
        }

        @Override
        protected void updateItem(LearnRecord.TimeItem timeItem, boolean b) {
            super.updateItem(timeItem, b);
            if (timeItem != null && !b) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日HH时");
                beginStr.setText(simpleDateFormat.format(timeItem.getBeginDate()));
                endStr.setText(simpleDateFormat.format(timeItem.getEndDate()));
                sumStr.setText(String.format("累计学习时长%d分钟", timeItem.getTimeSpan()));
                setGraphic(mainVBox);
            } else {
                setGraphic(null);
            }
        }
    }


}
