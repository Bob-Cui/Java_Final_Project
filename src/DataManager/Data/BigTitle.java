package DataManager.Data;

import java.util.LinkedList;

/**
 * 用于存储所有关于题目的数据
 */
public class BigTitle {






    private LinkedList<Title> PriTitleList;
    private LinkedList<Title> MidTitleList;
    private LinkedList<Title> SenTitleList;




    /**
     *
     * @param primaryTitleList
     * @param midTitleList
     * @param senTitleList
     */
    public BigTitle(LinkedList<Title> primaryTitleList, LinkedList<Title> midTitleList, LinkedList<Title> senTitleList) {
        PriTitleList = primaryTitleList;
        MidTitleList = midTitleList;
        SenTitleList = senTitleList;
    }

    public LinkedList<Title> getPrimaryTitleList() {
        return PriTitleList;
    }

    public void setPrimaryTitleList(LinkedList<Title> primaryTitleList) {
        PriTitleList = primaryTitleList;
    }

    public LinkedList<Title> getMidTitleList() {
        return MidTitleList;
    }

    public void setMidTitleList(LinkedList<Title> midTitleList) {
        MidTitleList = midTitleList;
    }

    public LinkedList<Title> getSenTitleList() {
        return SenTitleList;
    }

    public void setSenTitleList(LinkedList<Title> senTitleList) {
        SenTitleList = senTitleList;
    }

    @Override
    public String toString() {
        return "BigTitle{" +
                "PriTitleList=" + PriTitleList +
                ", MidTitleList=" + MidTitleList +
                ", SenTitleList=" + SenTitleList +
                '}';
    }
}


