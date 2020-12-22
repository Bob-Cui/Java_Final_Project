package DataManager.Data;

import java.util.HashMap;


/**

 */
public class AllData {
    /**
     * 这是哈希表
     * 感觉应该不会被问到哈希表的原理
     */
    private HashMap<String, SubTitleManager> stringNewSubTitleManagerHashMap;
    private Problems priNewProblems, midNewProblems, senNewProblems;


    public AllData() {
        stringNewSubTitleManagerHashMap = new HashMap<>();
    }


    public HashMap<String, SubTitleManager> getStringNewSubTitleManagerHashMap() {
        return stringNewSubTitleManagerHashMap;
    }

    public void setStringNewSubTitleManagerHashMap(HashMap<String, SubTitleManager> stringNewSubTitleManagerHashMap) {
        this.stringNewSubTitleManagerHashMap = stringNewSubTitleManagerHashMap;
    }


    public Problems getPriNewProblems() {
        return priNewProblems;
    }
    public void setPriNewProblems(Problems priNewProblems) {
        this.priNewProblems = priNewProblems;
    }
    public Problems getMidNewProblems() {
        return midNewProblems;
    }
    public void setMidNewProblems(Problems midNewProblems) {
        this.midNewProblems = midNewProblems;
    }
    public Problems getSenNewProblems() {
        return senNewProblems;
    }
    public void setSenNewProblems(Problems senNewProblems) {
        this.senNewProblems = senNewProblems;
    }
}
