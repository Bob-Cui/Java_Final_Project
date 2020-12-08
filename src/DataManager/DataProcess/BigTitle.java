package DataManager.DataProcess;

import java.util.LinkedList;

public class BigTitle {

    private LinkedList<Title> PriTitleList;
    private LinkedList<Title> MidTitleList;
    private LinkedList<Title> SenTitleList;

    public LinkedList<Title> getPriTitleList() {
        return PriTitleList;
    }

    public void setPriTitleList(LinkedList<Title> priTitleList) {
        PriTitleList = priTitleList;
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

    public BigTitle(LinkedList<Title> priTitleList, LinkedList<Title> midTitleList, LinkedList<Title> senTitleList) {
        PriTitleList = priTitleList;
        MidTitleList = midTitleList;
        SenTitleList = senTitleList;
    }
}
