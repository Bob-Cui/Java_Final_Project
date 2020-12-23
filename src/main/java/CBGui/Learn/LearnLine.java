package main.java.CBGui.Learn;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * 我爱死这个东西了  我去
 */
public class LearnLine extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(
                xAxis, yAxis);

        lineChart.setTitle("Line Chart");
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName("My Data");
        // populating the series with data
        series.getData().add(new XYChart.Data<Number, Number>(1, 23));
        series.getData().add(new XYChart.Data<Number, Number>(2, 114));
        series.getData().add(new XYChart.Data<Number, Number>(3, 15));
        series.getData().add(new XYChart.Data<Number, Number>(4, 124));
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }
}
