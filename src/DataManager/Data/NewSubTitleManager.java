package DataManager.Data;

import java.util.HashMap;
import java.util.TreeMap;

public class NewSubTitleManager {

    private boolean ableToLearn;

    private TreeMap<String, NewTitleManager> stringNewTitleManagerTreeMap;




    private TreeMap<Integer, NewTitleManager> integerNewTitleManagerTreeMap;


    public static void main(String[] args) {

    }

    public TreeMap<String, NewTitleManager> getStringNewTitleManagerTreeMap() {
        return stringNewTitleManagerTreeMap;
    }

    public TreeMap<Integer, NewTitleManager> getIntegerNewTitleManagerTreeMap() {
        return integerNewTitleManagerTreeMap;
    }

    public NewSubTitleManager(boolean ableToLearn) {
        this.ableToLearn = ableToLearn;
        this.stringNewTitleManagerTreeMap = new TreeMap<>();
        this.integerNewTitleManagerTreeMap = new TreeMap<>();    }

    public boolean isAbleToLearn() {
        return ableToLearn;
    }

    public void setAbleToLearn(boolean ableToLearn) {
        this.ableToLearn = ableToLearn;
    }


}
