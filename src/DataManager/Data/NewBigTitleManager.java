package DataManager.Data;

import java.util.HashMap;

public class NewBigTitleManager {
    /**
     * 无参构造函数
     */
    public NewBigTitleManager() {

        stringNewSubTitleManagerHashMap = new HashMap<>();

    }

    private HashMap<String, NewSubTitleManager> stringNewSubTitleManagerHashMap;

    public NewBigTitleManager(HashMap<String, NewSubTitleManager> stringNewSubTitleManagerHashMap) {
        this.stringNewSubTitleManagerHashMap = stringNewSubTitleManagerHashMap;
    }

    public HashMap<String, NewSubTitleManager> getStringNewSubTitleManagerHashMap() {
        return stringNewSubTitleManagerHashMap;
    }

    public void setStringNewSubTitleManagerHashMap(HashMap<String, NewSubTitleManager> stringNewSubTitleManagerHashMap) {
        this.stringNewSubTitleManagerHashMap = stringNewSubTitleManagerHashMap;
    }
}
