package main.java.CBGui.CbStage;

import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.Date;

public class LearningHistory extends Stage {

    private static class LearnItem {
        private String subTitleName;
        private String titleName;
        private long span;
        private Date date;

        /**
         * 正确的和错误的数量
         */
        private int right, wrong;


        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getWrong() {
            return wrong;
        }

        public void setWrong(int wrong) {
            this.wrong = wrong;
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

        public long getSpan() {
            return span;
        }

        public void setSpan(long span) {
            this.span = span;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public LearnItem(String subTitleName, String titleName, long span, Date date) {
            this.subTitleName = subTitleName;
            this.titleName = titleName;
            this.span = span;
            this.date = date;
        }

        public LearnItem(String subTitleName, String titleName, long span, Date date, int right, int wrong) {
            this.subTitleName = subTitleName;
            this.titleName = titleName;
            this.span = span;
            this.date = date;
            this.right = right;
            this.wrong = wrong;
        }
    }


    private ListView<LearnItem> learnItemListView;

    private void initListView() {




    }

    public LearningHistory() {


    }


}
