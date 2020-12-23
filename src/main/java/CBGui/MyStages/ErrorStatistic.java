package main.java.CBGui.MyStages;

import DataManager.Data.SelectProblem;
import DataManager.Data.SubTitle;
import DataManager.Data.Title;
import DataManager.DataProcess.JsonManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.java.CBGui.LetsGo;


import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class ErrorStatistic extends Stage {


    private int total, totalWrong;

    private HBox mainHBox;


    private static ObservableList<PieChart.Data> dataObservableList;

    public static PieChart pieChart;
    private ListView<ErrorItem> errorItemListView;
    private ObservableList<ErrorItem> errorItemObservableList;

    public static class ErrorItem {
        private String subTitleName;
        private String titleName;
        private int wrong, totalSize;

        public ErrorItem(String subTitleName, String titleName, int wrong, int totalSize) {
            this.subTitleName = subTitleName;
            this.titleName = titleName;
            this.wrong = wrong;
            this.totalSize = totalSize;
        }

        public String getSubTitleName() {
            return subTitleName;
        }

        public void setSubTitleName(String subTitleName) {
            this.subTitleName = subTitleName;
        }

        public String getTitleName() {
            return titleName;
        }

        public void setTitleName(String titleName) {
            this.titleName = titleName;
        }

        public int getWrong() {
            return wrong;
        }

        public void setWrong(int wrong) {
            this.wrong = wrong;
        }

        public int getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(int totalSize) {
            this.totalSize = totalSize;
        }
    }


    public ErrorStatistic() {


        dataObservableList = FXCollections.observableArrayList(
                new PieChart.Data("正确数量", 10),
                new PieChart.Data("错误数量", 10)
        );
        pieChart = new PieChart(dataObservableList);
        pieChart.setTitle("");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(60);
        pieChart.setStartAngle(90);


        total = 0;
        totalWrong = 0;
        errorItemObservableList = FXCollections.observableArrayList();

        mainHBox = new HBox();
        try {
            for (Map.Entry<String, SubTitle> stringSubTitleEntry : JsonManager.getBigTitle().getStringNewSubTitleManagerHashMap().entrySet()) {
//                if (!stringSubTitleEntry.getValue().isAbleToLearn())
//                    continue;
                for (Map.Entry<Integer, Title> integerTitleManagerEntry : stringSubTitleEntry.getValue().getIntegerNewTitleManagerHashMap().entrySet()) {
                    int count = 0;
                    for (Map.Entry<Integer, SelectProblem> integerSelectProblemEntry : integerTitleManagerEntry.getValue().getIntegerSelectProblemHashMap().entrySet()) {
                        if (integerSelectProblemEntry.getValue().getAnswer() != integerSelectProblemEntry.getValue().getYourAnswer()) {
                            count++;
                        }
                    }
                    //总数增加
                    total += integerTitleManagerEntry.getValue().getIntegerSelectProblemHashMap().size();
                    //错误的数量增加
                    totalWrong += count;
                    ErrorItem errorItem = new ErrorItem(stringSubTitleEntry.getKey(), integerTitleManagerEntry.getValue().getName(), count, integerTitleManagerEntry.getValue().getIntegerSelectProblemHashMap().size());
                    errorItemObservableList.add(errorItem);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        errorItemListView = new ListView<>(errorItemObservableList);




        ObservableList<String> strings = FXCollections.observableArrayList();


        strings.add("dfasdf");
        strings.add("dsfsdfsd");

        strings.add("dsfsdfsd");

        ListView<String> listView = new ListView<>(strings);


        errorItemListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                ErrorItem errorItem = errorItemListView.getItems().get(t1.intValue());
                pieChart.setTitle(String.format("%s选项分布", errorItem.getTitleName()));
                pieChart.getData().get(0).setPieValue(errorItem.getTotalSize() - errorItem.getWrong());
                pieChart.getData().get(1).setPieValue(errorItem.getWrong());
//                System.out.println("dsafas");
            }
        });
        errorItemListView.setCellFactory(new Callback<ListView<ErrorItem>, ListCell<ErrorItem>>() {
            @Override
            public ListCell<ErrorItem> call(ListView<ErrorItem> errorItemListView) {
                return new ErrorItemCell();
            }
        });

        mainHBox.setAlignment(Pos.CENTER);

        mainHBox.getChildren().add(pieChart);
        mainHBox.getChildren().add(errorItemListView);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        Scene scene = new Scene(mainHBox);


//        dimension.getWidth() / 2*(3/5), dimension.getHeight() / 2*(3/5)
        this.setMinWidth(dimension.getWidth() / 2 * (3 / 5));
        this.setMinHeight(dimension.getHeight() / 2 * (3 / 5));

        this.setScene(scene);
        Image image = new Image("file:src/Source/javasmall.jpg", 20, 20, true, true);
        this.getIcons().add(image);

        this.setTitle("用户错题统计");

    }



//    }


    public static class ErrorItemCell extends ListCell<ErrorItem> {

        private VBox mainVBox;
        private Label upTitle;
        private Label title;
        //        private Label lastLearn;
        private Label rightAnswer;


        private HBox rightAnswerHBox;


        public ErrorItemCell() {
            mainVBox = new VBox();
            {
                upTitle = new Label();
                title = new Label();
                rightAnswer = new Label();
            }
            {
                Image image = new Image("file:src/Source/javafa.jpg", 25, 25, true, true);
                upTitle.setGraphic(new ImageView(image));
            }
            {
                Image image = new Image("file:src/Source/javaRed.jpg", 20, 20, true, true);
                title.setGraphic(new ImageView(image));
            }
            upTitle.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;-fx-text-fill:#FF4500;");
            title.setStyle("-fx-font-size: 15px;-fx-font-weight: bold;-fx-text-fill:#FF8C00;");
            {
                rightAnswer = new Label();
                rightAnswerHBox = new HBox();
                rightAnswerHBox.setSpacing(20);
                Label labelLearnLeft = new Label();
                Label rightAnswerLeft = new Label();

                labelLearnLeft.setText("上次学习时间");
                rightAnswerLeft.setText("错误率");


                labelLearnLeft.setStyle("-fx-font-size: 12px;-fx-text-fill: #BA55D3;");
                rightAnswer.setStyle("-fx-font-size: 14px;-fx-text-fill: #DC143C");
                rightAnswerHBox.getChildren().addAll(rightAnswerLeft, rightAnswer);
            }


            mainVBox.getChildren().addAll(upTitle, title, rightAnswerHBox);
            mainVBox.setSpacing(5);
            mainVBox.setAlignment(Pos.CENTER_LEFT);
        }

        @Override
        protected void updateItem(ErrorItem errorItem, boolean b) {
            //这句话千万不要删啊
            super.updateItem(errorItem, b);
            if (errorItem != null && !b) {
                upTitle.setText(errorItem.getSubTitleName());
                title.setText(errorItem.getTitleName());
                String strRight = String.format("%d/%d", errorItem.getWrong(), errorItem.getTotalSize());
                rightAnswer.setText(strRight);


                setGraphic(mainVBox);
            } else {
                setGraphic(null);
            }

        }
    }
}
