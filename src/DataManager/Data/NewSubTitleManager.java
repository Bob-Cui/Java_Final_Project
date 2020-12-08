package DataManager.Data;

import java.util.HashMap;

public class NewSubTitleManager {

    private boolean ableToLearn;

    private HashMap<String, NewTitleManager> stringNewTitleManagerHashMap;
    private HashMap<Integer, NewTitleManager> integerNewTitleManagerHashMap;

    public HashMap<Integer, NewTitleManager> getIntegerNewTitleManagerHashMap() {
        return integerNewTitleManagerHashMap;
    }

    public void setIntegerNewTitleManagerHashMap(HashMap<Integer, NewTitleManager> integerNewTitleManagerHashMap) {
        this.integerNewTitleManagerHashMap = integerNewTitleManagerHashMap;
    }

    public NewSubTitleManager(boolean ableToLearn, HashMap<String, NewTitleManager> stringNewTitleManagerHashMap) {
        this.ableToLearn = ableToLearn;
        this.stringNewTitleManagerHashMap = stringNewTitleManagerHashMap;
    }

    public NewSubTitleManager(boolean ableToLearn) {
        this.ableToLearn = ableToLearn;
        this.stringNewTitleManagerHashMap = new HashMap<>();
        this.integerNewTitleManagerHashMap = new HashMap<>();
    }

    public boolean isAbleToLearn() {
        return ableToLearn;
    }

    public void setAbleToLearn(boolean ableToLearn) {
        this.ableToLearn = ableToLearn;
    }

    public HashMap<String, NewTitleManager> getStringNewTitleManagerHashMap() {
        return stringNewTitleManagerHashMap;
    }

    public void setStringNewTitleManagerHashMap(HashMap<String, NewTitleManager> stringNewTitleManagerHashMap) {
        this.stringNewTitleManagerHashMap = stringNewTitleManagerHashMap;
    }
}
