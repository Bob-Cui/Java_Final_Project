package DataManager.Data;

import java.util.TreeMap;

public class SubTitleManager {

    private boolean ableToLearn;

    //  private TreeMap<String, NewTitleManager> stringNewTitleManagerTreeMap;


    private TreeMap<Integer, TitleManager> integerNewTitleManagerTreeMap;


    public TreeMap<Integer, TitleManager> getIntegerNewTitleManagerTreeMap() {
        return integerNewTitleManagerTreeMap;
    }

    public SubTitleManager(boolean ableToLearn) {
        this.ableToLearn = ableToLearn;
        this.integerNewTitleManagerTreeMap = new TreeMap<>();
    }

    public boolean isAbleToLearn() {
        return ableToLearn;
    }

    public void setAbleToLearn(boolean ableToLearn) {
        this.ableToLearn = ableToLearn;
    }


}
