package XCYMain.SpecificStage;

import DataManager.Data.SelectProblem;
import DataManager.Data.SubTitleManager;
import DataManager.Data.TitleManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * 统计这个人学过的所有内容
 */
public class LearnHistoryStage extends Stage {

    public static class LearnedItem {
        private String subTitle;
        private String titleName;

        /**
         * 对了多少道题
         */
        private int right;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        /**
         * 一共有多少题
         */

        private int total;
        private Date lastLearn;

        public LearnedItem(String subTitle, String titleName, int right, Date lastLearn) {
            this.subTitle = subTitle;
            this.titleName = titleName;
            this.right = right;
            this.lastLearn = lastLearn;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getTitleName() {
            return titleName;
        }

        public void setTitleName(String titleName) {
            this.titleName = titleName;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public Date getLastLearn() {
            return lastLearn;
        }

        public void setLastLearn(Date lastLearn) {
            this.lastLearn = lastLearn;
        }
    }

    /**
     * 依然是熟悉的listView
     */

    private ObservableList<LearnedItem> observableList;
    private ListView<LearnedItem> learnedItemListView;

    public LearnHistoryStage() {
        this.getIcons().add(new Image("file:src/Source/icon.jpg"));

        this.setTitle("你的学习历史记录");


        dealAllData();

        VBox vBox = new VBox();
        learnedItemListView = new ListView<>(observableList);

        learnedItemListView.setCellFactory(new Callback<ListView<LearnedItem>, ListCell<LearnedItem>>() {
            @Override
            public ListCell<LearnedItem> call(ListView<LearnedItem> learnedItemListView) {
                return new LearnItemCell();
            }

        });


        vBox.getChildren().add(learnedItemListView);

        this.setScene(new Scene(vBox));
        this.setResizable(false);
        this.initModality(Modality.APPLICATION_MODAL);

    }

    public static void main(String[] args) {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日HH时");


        System.out.println(simpleDateFormat.format(new Date()));

    }

    /**
     * 用于计算回答正确的数量
     *
     * @param newTitleManager 需要被检查的title
     * @return 此人回答的正确答案的数量
     */
    private int countRight(TitleManager newTitleManager) {
        int right = 0;


        for (Map.Entry<Integer, SelectProblem> integerNewSelectProblemEntry : newTitleManager.getIntegerSelectProblemHashMap().entrySet()) {
            if (integerNewSelectProblemEntry.getValue().getYourAnswer() == integerNewSelectProblemEntry.getValue().getAnswer()) {
                right++;
            }

        }
        return right;
    }

    /**
     *
     */
    private void dealAllData() {
        observableList = FXCollections.observableArrayList();
        for (Map.Entry<String, SubTitleManager> stringNewSubTitleManagerEntry : XCYMain.allData.getStringNewSubTitleManagerHashMap().entrySet()) {
            String subTitleName = stringNewSubTitleManagerEntry.getKey();//这里指的是名字

            if (!stringNewSubTitleManagerEntry.getValue().isAbleToLearn())
                continue;
            for (Map.Entry<Integer, TitleManager> integerNewTitleManagerEntry : stringNewSubTitleManagerEntry.getValue().getIntegerNewTitleManagerTreeMap().entrySet()) {
                System.out.println(integerNewTitleManagerEntry.getValue().getName());

                System.out.println(integerNewTitleManagerEntry.getValue().getDate().toString());
                if (integerNewTitleManagerEntry.getValue().isLearned()) {//只有学过的才会被记录

                    int right = countRight(integerNewTitleManagerEntry.getValue());
                    LearnedItem learnedItem = new LearnedItem(subTitleName, integerNewTitleManagerEntry.getValue().getName(), right, integerNewTitleManagerEntry.getValue().getDate());
                    learnedItem.setTotal(integerNewTitleManagerEntry.getValue().getIntegerSelectProblemHashMap().size());


                    observableList.add(learnedItem);
                }
            }
        }


    }


    public static class LearnItemCell extends ListCell<LearnedItem> {

        private VBox mainVBox;
        private Label bigTitle;
        private Label title;
        private Label lastLearn;
        private Label rightAnswer;


        private HBox lastLearnHBox, rightAnswerHBox;

        public LearnItemCell() {
            mainVBox = new VBox();
            {
                bigTitle = new Label();
                title = new Label();
                lastLearn = new Label();
                rightAnswer = new Label();
            }
            {
                Image image = new Image("file:src/Source/sencq.png", 20, 20, true, true);
                bigTitle.setGraphic(new ImageView(image));
            }
            {
                Image image = new Image("file:src/Source/midcq.png", 20, 20, true, true);
                title.setGraphic(new ImageView(image));
            }


            bigTitle.setStyle("-fx-font-size: 25px;-fx-font-weight: bold;-fx-text-fill:#FF4500;");
            title.setStyle("-fx-font-size: 20px;-fx-font-weight: bold;-fx-text-fill:#FF8C00;");


            {
                lastLearn = new Label();
                rightAnswer = new Label();

                lastLearnHBox = new HBox();
                rightAnswerHBox = new HBox();


                lastLearnHBox.setSpacing(20);
                rightAnswerHBox.setSpacing(20);


                Label labelLearnLeft = new Label();
                Label rightAnswerLeft = new Label();

                labelLearnLeft.setText("上次学习时间");
                rightAnswerLeft.setText("正确率");


                labelLearnLeft.setStyle("-fx-font-size: 12px;-fx-text-fill: #BA55D3;");
                rightAnswer.setStyle("-fx-font-size: 14px;-fx-text-fill: #DC143C");
                lastLearnHBox.getChildren().addAll(labelLearnLeft, lastLearn);
                rightAnswerHBox.getChildren().addAll(rightAnswerLeft, rightAnswer);
            }


            mainVBox.getChildren().addAll(bigTitle, title, lastLearnHBox, rightAnswerHBox);
            mainVBox.setSpacing(5);
            mainVBox.setAlignment(Pos.CENTER_LEFT);

        }

        @Override
        protected void updateItem(LearnedItem learnedItem, boolean b) {
            //   super.updateItem(learnedItem, b);
            if (learnedItem != null && !b) {
                bigTitle.setText(learnedItem.getSubTitle());
                title.setText(learnedItem.getTitleName());


                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YY年MM月dd日HH时");

                String date = simpleDateFormat.format(learnedItem.getLastLearn());

                lastLearn.setText(date);

                String strRight = String.format("%d/%d", learnedItem.getRight(), learnedItem.getTotal());
                rightAnswer.setText(strRight);

                setGraphic(mainVBox);
            } else {
                setGraphic(null);
            }

        }
    }
}
