package DataManager.Data;

import java.util.HashMap;

public class SubTitle {

    private boolean ableToLearn;

    private HashMap<String, Title> stringNewTitleManagerHashMap;
    private HashMap<Integer, Title> integerNewTitleManagerHashMap;

    public HashMap<Integer, Title> getIntegerNewTitleManagerHashMap() {
        return integerNewTitleManagerHashMap;
    }

    public void setIntegerNewTitleManagerHashMap(HashMap<Integer, Title> integerNewTitleManagerHashMap) {
        this.integerNewTitleManagerHashMap = integerNewTitleManagerHashMap;
    }

    public SubTitle(boolean ableToLearn, HashMap<String, Title> stringNewTitleManagerHashMap) {
        this.ableToLearn = ableToLearn;
        this.stringNewTitleManagerHashMap = stringNewTitleManagerHashMap;
    }

    public SubTitle(boolean ableToLearn) {
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

    public HashMap<String, Title> getStringNewTitleManagerHashMap() {
        return stringNewTitleManagerHashMap;
    }

    public void setStringNewTitleManagerHashMap(HashMap<String, Title> stringNewTitleManagerHashMap) {
        this.stringNewTitleManagerHashMap = stringNewTitleManagerHashMap;
    }
}
