package DataManager.Data;

import java.util.LinkedList;

/**
 * 用于存储所有关于题目的数据
 */
public class BigTitleManager {

    /**
     *
     * 修改原来的设计
     */
    private LinkedList<SubTitleManager> subTitleManagerLinkedLists;

    public BigTitleManager() {
        subTitleManagerLinkedLists = new LinkedList<>();
    }


    public BigTitleManager(LinkedList<SubTitleManager> subTitleManagerLinkedLists) {
        this.subTitleManagerLinkedLists = subTitleManagerLinkedLists;
    }

    public LinkedList<SubTitleManager> getSubTitleManagerLinkedLists() {
        return subTitleManagerLinkedLists;
    }

    public void setSubTitleManagerLinkedLists(LinkedList<SubTitleManager> subTitleManagerLinkedLists) {
        this.subTitleManagerLinkedLists = subTitleManagerLinkedLists;
    }
}


