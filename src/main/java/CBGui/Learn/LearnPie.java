package main.java.CBGui.Learn;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * 学习画一个饼图
 */
public class LearnPie extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Iphone 5S", 13),
                new PieChart.Data("Samsung Grand", 25),
                new PieChart.Data("MOTO G", 10),
                new PieChart.Data("Nokia Lumia", 22));

        PieChart pieChart = new PieChart(pieChartData);

        pieChart.setTitle("学习画饼图");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(60);
        pieChart.setStartAngle(90);
        Group root = new Group(pieChart);
        Scene scene = new Scene(root, 600, 300);
        stage.setScene(scene);
        stage.show();

    }
}
