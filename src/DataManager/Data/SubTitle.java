package DataManager.Data;

import java.util.HashMap;

public class SubTitle {


    private HashMap<String, Title> stringNewTitleManagerHashMap;
    private HashMap<Integer, Title> integerNewTitleManagerHashMap;

    public HashMap<Integer, Title> getIntegerNewTitleManagerHashMap() {
        return integerNewTitleManagerHashMap;
    }

    public void setIntegerNewTitleManagerHashMap(HashMap<Integer, Title> integerNewTitleManagerHashMap) {
        this.integerNewTitleManagerHashMap = integerNewTitleManagerHashMap;
    }

    public SubTitle(HashMap<String, Title> stringNewTitleManagerHashMap, HashMap<Integer, Title> integerNewTitleManagerHashMap) {
        this.stringNewTitleManagerHashMap = stringNewTitleManagerHashMap;
        this.integerNewTitleManagerHashMap = integerNewTitleManagerHashMap;
    }

    public SubTitle(boolean ableToLearn) {
        this.stringNewTitleManagerHashMap = new HashMap<>();
        this.integerNewTitleManagerHashMap = new HashMap<>();
    }


    public HashMap<String, Title> getStringNewTitleManagerHashMap() {
        return stringNewTitleManagerHashMap;
    }

    public void setStringNewTitleManagerHashMap(HashMap<String, Title> stringNewTitleManagerHashMap) {
        this.stringNewTitleManagerHashMap = stringNewTitleManagerHashMap;
    }
}
