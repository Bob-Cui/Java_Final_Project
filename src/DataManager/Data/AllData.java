package DataManager.Data;

import java.util.HashMap;


/**

 */
public class AllData {

    public HashMap<String, NewSubTitleManager> getStringNewSubTitleManagerHashMap() {
        return stringNewSubTitleManagerHashMap;
    }

    public void setStringNewSubTitleManagerHashMap(HashMap<String, NewSubTitleManager> stringNewSubTitleManagerHashMap) {
        this.stringNewSubTitleManagerHashMap = stringNewSubTitleManagerHashMap;
    }

    public AllData() {
        stringNewSubTitleManagerHashMap = new HashMap<>();
    }

    /**
     * 这是哈希表
     * 感觉应该不会被问到哈希表的原理
     */
    private HashMap<String, NewSubTitleManager> stringNewSubTitleManagerHashMap;
    private NewProblems priNewProblems, midNewProblems, senNewProblems;


    public NewProblems getPriNewProblems() {
        return priNewProblems;
    }
    public void setPriNewProblems(NewProblems priNewProblems) {
        this.priNewProblems = priNewProblems;
    }
    public NewProblems getMidNewProblems() {
        return midNewProblems;
    }
    public void setMidNewProblems(NewProblems midNewProblems) {
        this.midNewProblems = midNewProblems;
    }
    public NewProblems getSenNewProblems() {
        return senNewProblems;
    }
    public void setSenNewProblems(NewProblems senNewProblems) {
        this.senNewProblems = senNewProblems;
    }
}
