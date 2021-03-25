package main.java.CBGui.MyStages;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;

public class MyNoteStage extends Stage {

    private static final String CHINESE = "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>";
    private HTMLEditor htmlEditor;
    private static String prefix = "src/notes/";
    private GridPane mainGridPane;
    private Button save;
    public static boolean hasWriteBefore = false;

    /**
     * @param name 这个标题的题目，对应一个笔记文件的地址
     */
    public MyNoteStage(String name) throws IOException {
        this.getIcons().add(new Image("file:src/Source/javasmall.jpg"));
        this.setTitle(String.format("%s的笔记", name));
        htmlEditor = new HTMLEditor();
        mainGridPane = new GridPane();

        String fileName = String.format("%s.html", prefix + name);
        File file = new File(fileName);

        if (file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            htmlEditor.setHtmlText(getHtmlText(bufferedReader));
            bufferedReader.close();
            hasWriteBefore = true;
        }

        save = new Button();

        save.setText("保存");

        save.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                try {
                    FileWriter fileWriter = new FileWriter(file);
                    if (hasWriteBefore) {
                        fileWriter.write(htmlEditor.getHtmlText());
                    } else {
                        fileWriter.write(chineseEnable(htmlEditor.getHtmlText()));
                    }
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Alert success = new Alert(Alert.AlertType.INFORMATION);


                Image image = new Image("file:src/Source/javafa.jpg", 60, 60, true, true);
                success.setGraphic(new ImageView(image));
                success.setTitle("操作成功");
                success.setHeaderText("笔记保存成功");
                /**
                 * 为什么内部类能访问address
                 */
                success.setContentText(String.format("你成功的保存了%s的笔记", name));

                success.showAndWait();
            }

        });


        mainGridPane.add(htmlEditor, 1, 1);
        mainGridPane.add(save, 1, 2);


        GridPane.setHalignment(save, HPos.CENTER);
        save.setStyle("-fx-font-size:20px");

        Scene scene = new Scene(mainGridPane);

        this.setScene(scene);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setMinWidth(dimension.getWidth() / 2);
        this.setMinHeight(dimension.getHeight());
    }


    /**
     * 使得笔记可以显示中文
     *
     * @param input
     * @return
     */
    private String chineseEnable(String input) {
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

    /**
     * 太智能了
     *
     * @param bufferedReader 传入一个bufferReader
     * @return
     * @throws IOException
     */
    private String getHtmlText(BufferedReader bufferedReader) throws IOException {
        StringBuilder ans = new StringBuilder();
        String t = null;
        while ((t = bufferedReader.readLine()) != null) {

            ans.append(t);
        }
        return ans.toString();
    }
}