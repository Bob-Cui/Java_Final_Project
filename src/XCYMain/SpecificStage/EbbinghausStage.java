package XCYMain.SpecificStage;

import DataManager.Data.SubTitleManager;
import DataManager.Data.TitleManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;


/**
 * 如果弄模糊或者是记得清楚这项功能的话有点太复杂
 * 我会被累死的
 */
public class EbbinghausStage extends Stage {


    /**
     * 一天对应有多少毫秒
     */
    public static final int DAY = 24 * 60 * 60 * 1000;


    /**
     * 一个小时有多长时间
     */
    public static final int HOUR = 60 * 60 * 1000;

    /**
     * 需要塞到listview里面的item
     */
    private static class EbbinghausItem {
        /**
         * 需要复习的科目的名字,以及属于哪一个科目
         */
        private String subTitleName;
        private String name;
        /**
         * 上次学习的日期
         */
        private Date lastLearn;

        private int timeSpan;

        public EbbinghausItem(String subTitleName, String name, Date lastLearn) {
            this.subTitleName = subTitleName;
            this.name = name;
            this.lastLearn = lastLearn;
        }

        public String getSubTitleName() {
            return subTitleName;
        }

        public void setSubTitleName(String subTitleName) {
            this.subTitleName = subTitleName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getLastLearn() {
            return lastLearn;
        }

        public void setLastLearn(Date lastLearn) {
            this.lastLearn = lastLearn;
        }

        public int getTimeSpan() {
            return timeSpan;
        }

        public void setTimeSpan(int timeSpan) {
            this.timeSpan = timeSpan;
        }
    }


    /**
     * 用于存放所有需要被处理的复习项目
     */
    private LinkedList<EbbinghausItem> ebbinghausItemLinkedList;


    private ListView<EbbinghausItem> ebbinghausItemListView;


    private GridPane mainGriPane;

    /**
     * 检查这个人需要进行复习的科目
     */
    private void initTimeList() {

        for (Map.Entry<String, SubTitleManager> stringNewProblemsEntry : XCYMain.allData.getStringNewSubTitleManagerHashMap().entrySet()) {
//            if(!stringNewProblemsEntry.getValue().isAbleToLearn())
//                continue;
            for (Map.Entry<Integer, TitleManager> integerNewTitleManagerEntry : stringNewProblemsEntry.getValue().getIntegerNewTitleManagerTreeMap().entrySet()) {
//                if(!integerNewTitleManagerEntry.getValue().isLearned()) continue;
                EbbinghausItem ebbinghausItem = new EbbinghausItem(stringNewProblemsEntry.getKey(), integerNewTitleManagerEntry.getValue().getName(), integerNewTitleManagerEntry.getValue().getDate());


                int span = getSpanBetween(integerNewTitleManagerEntry.getValue().getDate());

                if (span >= 9) {
                    //大于9个小时的加进去
                    ebbinghausItem.setTimeSpan(span);
                    ebbinghausItemLinkedList.add(ebbinghausItem);
                }

            }
        }
//        ebbinghausItemLinkedList.sort(new Comparator<EbbinghausItem>() {
//            @Override
//            public int compare(EbbinghausItem o1, EbbinghausItem o2) {
//                return o1.getTimeSpan() - o2.getTimeSpan();
//            }
//        });


    }

    /**
     * 两个date之间差多少小时
     *
     * @return
     */
    private int getSpanBetween(Date date) {
        Date now = new Date();
        return (int) (now.getTime() - date.getTime()) / HOUR;
    }


    public EbbinghausStage() {
//this.setResizable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension dimension = toolkit.getScreenSize();
        double width = dimension.getWidth();
        double height = dimension.getHeight();
        HBox mainHBox = new HBox();
        double len = 400;
        Image image = new Image("file:src/Source/abhs.png", width / 3 - width / 40, 2 * height, true, true);
        ImageView imageView = new ImageView(image);
        imageView.setY(height / 4);
        ebbinghausItemLinkedList = new LinkedList<>();

        initTimeList();

        ObservableList<EbbinghausItem> ebbinghausItemObservableList = FXCollections.observableArrayList();
        ebbinghausItemObservableList.addAll(ebbinghausItemLinkedList);
        ebbinghausItemListView = new ListView<>(ebbinghausItemObservableList);

        ebbinghausItemListView.setCellFactory(new Callback<ListView<EbbinghausItem>, ListCell<EbbinghausItem>>() {
            @Override
            public ListCell<EbbinghausItem> call(ListView<EbbinghausItem> ebbinghausItemListView) {
                return new EbbinghausItemCell();
            }
        });
        {


            mainGriPane = new GridPane();

            mainGriPane.add(ebbinghausItemListView, 1, 1);
            mainGriPane.add(imageView, 0, 1);

            mainGriPane.setVgap(50);
            mainGriPane.setHgap(20);

            mainGriPane.setStyle("-fx-background-image: url(" + "file:src/Source/backcq.jpg" + ")");

        }


//        {
//            mainHBox.getChildren().add(imageView);
//            mainHBox.getChildren().add(ebbinghausItemListView);
//
//            mainHBox.setSpacing(10);
//            mainHBox.setStyle("-fx-background-image: url(" + "file:src/Source/backcq.jpg" + ")");
//        }


        {
            this.setWidth(width / 2);
            this.setHeight(2 * height / 3);
            ebbinghausItemListView.setMaxWidth(width / 6);
            ebbinghausItemListView.setMinWidth(width / 6);
            ebbinghausItemListView.setMinHeight(height / 2);
            ebbinghausItemListView.setMaxHeight(height / 2);
        }
        {
            Tooltip tooltip = new Tooltip("请根据遗忘曲线进行复习");
            Image image1 = new Image("file:src/Source/pricq.png", 30, 30, true, true);
            tooltip.setGraphic(new ImageView(image1));
            tooltip.setFont(new Font(25));
            ebbinghausItemListView.setTooltip(tooltip);
        }
        {




        }
        {
            this.getIcons().add(new Image("file:src/Source/midcq.png"));
            this.setTitle("艾宾浩斯曲线复习界面");
        }

/**
 * 打开这个窗体的时候是不能打开其他窗体的
 */
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.setScene(new Scene(mainGriPane));
    }

    private static class EbbinghausItemCell extends ListCell<EbbinghausItem> {

        private HBox mainHBox, rightBottomHBox;

        private VBox rightVBox;

        private Label titleName;
        private Label timeSpan;
        private Label lastLearnTime;


        private ImageView leftDog;

        public EbbinghausItemCell() {

            double len = 35;
            Image image = new Image("file:src/Source/mlcq.jpg", len, len, true, true);
            leftDog = new ImageView(image);


            mainHBox = new HBox();
            rightBottomHBox = new HBox();
            rightVBox = new VBox();


/**
 * 我真是烦透了这个new语句了，为什么不能智能化
 */
            timeSpan = new Label();
            titleName = new Label();
            lastLearnTime = new Label();

            {

                titleName.setStyle("-fx-font-weight: bolder;-fx-font-size: 15px");
                lastLearnTime.setStyle("-fx-font-size: 13px;-fx-text-fill: #4183C4");
                timeSpan.setStyle("-fx-font-size: 13px;-fx-font-weight: bold");
            }


            {//左边是上次学习的日期，右边是上次学习的时间与这次的日期的间隔
                rightBottomHBox.getChildren().add(lastLearnTime);
                rightBottomHBox.getChildren().add(timeSpan);
                rightBottomHBox.setSpacing(30);
            }

            rightVBox.getChildren().add(titleName);
            rightVBox.getChildren().add(rightBottomHBox);


            mainHBox.getChildren().add(leftDog);
            mainHBox.getChildren().add(rightVBox);
        }

        @Override
        protected void updateItem(EbbinghausItem ebbinghausItem, boolean b) {
            super.updateItem(ebbinghausItem, b);
/**
 * ebbinghausItem放了想要显示的信息，updateItem将其显示出来
 */
            if (ebbinghausItem != null && !b) {
/**
 * 这个项目的名字
 */
                titleName.setText(ebbinghausItem.getSubTitleName() + "    " + ebbinghausItem.getName());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时");

                /**
                 * 获取时间
                 */
                lastLearnTime.setText(simpleDateFormat.format(ebbinghausItem.getLastLearn()));


                if (ebbinghausItem.getTimeSpan() >= 24) {
                    timeSpan.setText(String.valueOf(ebbinghausItem.getTimeSpan() / 24) + "天");

                    timeSpan.setStyle("-fx-text-fill: hotpink;-fx-font-size: 13px;-fx-font-weight: bold");
                } else {
                    timeSpan.setText(ebbinghausItem.getTimeSpan() + "小时");
                }
                titleName.setWrapText(true);
                setGraphic(mainHBox);

            } else {
                setGraphic(null);
            }
        }
    }


}
