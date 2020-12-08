package DataManager.Data.OldData;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;

public class Problems {


    @SerializedName("linkedList")
    private LinkedList<SelectProblem> selectProblemLinkedList;

    public Problems(LinkedList<SelectProblem> selectProblemLinkedList) {
        this.selectProblemLinkedList = selectProblemLinkedList;
    }

    public LinkedList<SelectProblem> getSelectProblemLinkedList() {
        return selectProblemLinkedList;
    }

    public void setSelectProblemLinkedList(LinkedList<SelectProblem> selectProblemLinkedList) {
        this.selectProblemLinkedList = selectProblemLinkedList;
    }
}
