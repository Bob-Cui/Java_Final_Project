package main.java.CBGui.Learn;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.io.*;

public class LearnHTMLEditor extends Application {

    private String temp;
    private static final String CHINESE = "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>";

    @Override
    public void start(Stage stage) throws Exception {


        Button button = new Button("打印一下");
        Button button1 = new Button("生成文件试一试");

        HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);

        htmlEditor.setHtmlText("<html dir=\"ltr\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head><body contenteditable=\"true\">张辉</body></html>");


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println((htmlEditor.getHtmlText()));
                test(htmlEditor.getHtmlText());
            }
        });
//        htmlEditor.getAccessibleText()
        button1.setOnAction(new EventHandler<ActionEvent>() {

            //    @lombok.SneakyThrows
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    to_HTML(test(htmlEditor.getHtmlText()));


                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("success!");
            }
        });
        VBox vBox = new VBox();
        vBox.getChildren().addAll(button, button1, htmlEditor);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();

    }

    private String test(String input) {
        int loc = input.indexOf("<head>");


        String front = input.substring(0, loc);


        String after = input.substring(loc + 13);
        String ans = front + CHINESE + after;
        return ans;
    }

    private void to_HTML(String input) throws IOException {
        File file = new File("for_test.html");


        int loc = input.indexOf("<head>");


        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(input);
        fileWriter.close();

    }

}
