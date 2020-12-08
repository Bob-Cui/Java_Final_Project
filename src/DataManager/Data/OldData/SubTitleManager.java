package DataManager.Data.OldData;

import java.util.LinkedList;

public class SubTitleManager {
    private boolean ableToLearn;
    private TitleType titleType;
    private LinkedList<TitleManager> titleList;
    /**
     * 题库
     */


    public SubTitleManager() {
        ableToLearn = false;
        titleType = TitleType.PRIMARY;
        titleList = new LinkedList<>();

    }

    public SubTitleManager(TitleType titleType) {
        this.titleType = titleType;
        ableToLearn = false;
        titleList = new LinkedList<>();
    }

    public SubTitleManager(boolean ableToLearn, TitleType titleType, LinkedList<TitleManager> linkedListTitle) {
        this.ableToLearn = ableToLearn;
        this.titleType = titleType;
        this.titleList = linkedListTitle;
    }

    public boolean isAbleToLearn() {
        return ableToLearn;
    }

    public void setAbleToLearn(boolean ableToLearn) {
        this.ableToLearn = ableToLearn;
    }

    public TitleType getTitleType() {
        return titleType;
    }

    public void setTitleType(TitleType titleType) {
        this.titleType = titleType;
    }

    public LinkedList<TitleManager> getTitleList() {
        return titleList;
    }

    public void setTitleList(LinkedList<TitleManager> titleList) {
        this.titleList = titleList;
    }
}
