package main.java.CBGui.SpecificStage;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


/**
 * 统计这个人学过的所有内容
 */
public class LearnStatistics extends Stage {

    public static class LearnedItem {
        private String subTitle;
        private String titleName;

        /**
         * 对了多少道题
         */
        private int right;

        public LearnedItem(String subTitle, String titleName, int right) {
            this.subTitle = subTitle;
            this.titleName = titleName;
            this.right = right;
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
    }

    /**
     * 依然是熟悉的listView
     */
    private ListView<LearnedItem> learnedItemListView;

    public LearnStatistics() {


    }

    public static class LearnItemCell extends ListCell<LearnedItem> {




    }
}
