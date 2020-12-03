package DataManager.Data;

import java.util.LinkedList;

public class SubTitleManager {
    private boolean ableToLearn;
    private TitleType titleType;
    private LinkedList<TitleManager> linkedListTitle;


    public SubTitleManager() {
        ableToLearn = false;
        titleType = TitleType.PRIMARY;
        linkedListTitle = new LinkedList<>();

    }

    public SubTitleManager(TitleType titleType) {
        this.titleType = titleType;
        ableToLearn = false;
        linkedListTitle = new LinkedList<>();
    }

    public SubTitleManager(boolean ableToLearn, TitleType titleType, LinkedList<TitleManager> linkedListTitle) {
        this.ableToLearn = ableToLearn;
        this.titleType = titleType;
        this.linkedListTitle = linkedListTitle;
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

    public LinkedList<TitleManager> getLinkedListTitle() {
        return linkedListTitle;
    }

    public void setLinkedListTitle(LinkedList<TitleManager> linkedListTitle) {
        this.linkedListTitle = linkedListTitle;
    }
}
